package job_application_system_training_project.demo.dto.apidto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorDTO {
    private String code;
    private String message;
}
