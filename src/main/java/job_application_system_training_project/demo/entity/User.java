package job_application_system_training_project.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Ή GenerationType.UUID για Spring Boot 3+
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String fullname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "password is required")
    //@Size(min = 5, max = 15, message = "Password should be 5 to 15 characters long")
    private String password;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;



}
