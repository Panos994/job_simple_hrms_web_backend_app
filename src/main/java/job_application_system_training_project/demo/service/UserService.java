package job_application_system_training_project.demo.service;

import job_application_system_training_project.demo.dto.ApplyJobRequestDTO;
import job_application_system_training_project.demo.dto.UserRegisterRequestDTO;
import job_application_system_training_project.demo.dto.UserResponseDTO;
import job_application_system_training_project.demo.entity.Application;
import job_application_system_training_project.demo.entity.Role;
import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Inject τον encoder


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegisterRequestDTO registerRequestDTO){ //DTO -> Entity -> Repository
        User user = new User();
        String email = registerRequestDTO.getEmail();
        user.setEmail(email);
        //String password = registerRequestDTO.getPassword();
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setRole(Role.USER);
        user.setFullname(registerRequestDTO.getFullName());
        return userRepository.save(user);
    }


}
