package job_application_system_training_project.demo.security;

import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userRepository.findByEmail(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("User not found");
                });

        return new CustomUserDetails(user);
    }
}
