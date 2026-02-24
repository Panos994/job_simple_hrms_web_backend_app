package job_application_system_training_project.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequestDTO {
    @JsonProperty("fullName") // Αυτό λέει στην Java: "Όταν δεις fullName στο JSON, βάλε το εδώ"
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
