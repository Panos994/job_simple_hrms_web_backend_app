package job_application_system_training_project.demo.dto.authenticationdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class LoginRequestDTO {
    private String email;
    private String password;
}
