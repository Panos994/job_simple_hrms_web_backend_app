package job_application_system_training_project.demo.dto;

import java.time.LocalDateTime;

public record ErrorResponse (
        String message,
        int status,
        LocalDateTime timeStamp

)

{}
