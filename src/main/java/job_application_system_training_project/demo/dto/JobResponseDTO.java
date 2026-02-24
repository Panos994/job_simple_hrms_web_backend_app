package job_application_system_training_project.demo.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponseDTO {

    private UUID jobId;
    private String positionName;
    private String description;
}
