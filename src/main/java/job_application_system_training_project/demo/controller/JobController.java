package job_application_system_training_project.demo.controller;

import job_application_system_training_project.demo.dto.CreateJobRequestDTO;
import job_application_system_training_project.demo.dto.JobResponseDTO;
import job_application_system_training_project.demo.entity.Job;
import job_application_system_training_project.demo.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @PostMapping("/create")
//    public ResponseEntity<Job> createJob(@RequestBody CreateJobRequestDTO createJobRequestDTO){
//        return ResponseEntity.ok(jobService.createJob(createJobRequestDTO));
//    }

    //or
    @PreAuthorize("hasRole('JOB_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<JobResponseDTO> createJob(@RequestBody CreateJobRequestDTO createJobRequestDTO){
        Job job = jobService.createJob(createJobRequestDTO);

        JobResponseDTO responseDTO = JobResponseDTO.builder()
                .jobId(job.getId())
                .positionName(job.getPositionName())
                .description(job.getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
