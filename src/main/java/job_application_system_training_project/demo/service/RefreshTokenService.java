package job_application_system_training_project.demo.service;

import job_application_system_training_project.demo.entity.RefreshToken;
import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    public RefreshTokenService(RefreshTokenRepository repository) {
        this.repository = repository;
    }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken rt = new RefreshToken();
        rt.setUser(user);
        rt.setToken(UUID.randomUUID().toString());
        rt.setExpiryDate(Instant.now().plus(30, ChronoUnit.DAYS));
        return repository.save(rt);
    }

    public RefreshToken verify(String token) {
        RefreshToken rt = (RefreshToken) repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (rt.getExpiryDate().isBefore(Instant.now())) {
            repository.delete(rt);
            throw new RuntimeException("Expired refresh token");
        }
        return rt;
    }
}
