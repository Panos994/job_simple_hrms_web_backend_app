package job_application_system_training_project.demo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponseDTO {
    private UUID applicationId;
    private UUID jobId;
    private String jobTitle;
    private String status;
    private LocalDateTime createdAt;
}
