package job_application_system_training_project.demo.dto;

import job_application_system_training_project.demo.entity.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private UUID id;
    private String fullName;
    private String email;
    private Role role;
}
