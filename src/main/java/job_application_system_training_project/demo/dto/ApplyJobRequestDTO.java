package job_application_system_training_project.demo.dto;

import job_application_system_training_project.demo.entity.ApplicationStatus;
import job_application_system_training_project.demo.entity.Job;
import job_application_system_training_project.demo.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyJobRequestDTO {
    private UUID jobId;
}
