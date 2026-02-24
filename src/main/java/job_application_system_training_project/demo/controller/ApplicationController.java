package job_application_system_training_project.demo.controller;

import job_application_system_training_project.demo.dto.ApplicationResponseDTO;
import job_application_system_training_project.demo.dto.ApplyJobRequestDTO;
import job_application_system_training_project.demo.entity.Application;
import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.security.CustomUserDetails;
import job_application_system_training_project.demo.service.ApplicationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    //@PostMapping("/apply/{userId}") //αντι να βαζουμε το userId για να τον user θα το κανουμε μεσω JWT
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/apply")
    public ResponseEntity<ApplicationResponseDTO> apply(@RequestBody ApplyJobRequestDTO applyJobRequestDTO, Authentication authentication){  //ειχαμε @PathVariable για το userId ==> @PathVariable UUID userId
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal(); //απο security config
        UUID userId = userDetails.getUser().getId();
        Application application = applicationService.applyToJob(applyJobRequestDTO.getJobId(), userId);

//        ApplicationResponseDTO applicationResponseDTO = ApplicationResponseDTO.builder()
//                .applicationId(application.getId())
//                .jobId(application.getJob().getId())
//                .jobTitle(application.getJob().getPositionName())
//                .status(application.getStatus().name())
//                .createdAt(application.getCreatedAt())
//                .build();    //αντι αυτου μπορω να εχω μια Helper method mapToResponse()

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToResponse(application));
    }
    @PreAuthorize("hasAnyRole('USER','JOB_ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getUserApplications(@PathVariable UUID userId){
        List<ApplicationResponseDTO> response = applicationService.getApplicationsByUser(userId).stream().map(this::mapToResponse).toList();

        return ResponseEntity.ok(response);

    }


    @PreAuthorize("hasRole('JOB_ADMIN')")
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getJobApplications(@PathVariable UUID jobId){
        List<ApplicationResponseDTO> response = applicationService.getApplicationsByJob(jobId)
                .stream()
                .map(this::mapToResponse)
                .toList();
        return ResponseEntity.ok(response);

    }

    //helper method
    private ApplicationResponseDTO mapToResponse(Application application) {
        return ApplicationResponseDTO.builder()
                .applicationId(application.getId())
                .jobId(application.getJob().getId())
                .jobTitle(application.getJob().getPositionName())
                .status(application.getStatus().name())
                .createdAt(application.getCreatedAt())
                .build();
    }

}
