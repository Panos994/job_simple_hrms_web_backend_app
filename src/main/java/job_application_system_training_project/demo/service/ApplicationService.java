package job_application_system_training_project.demo.service;

import job_application_system_training_project.demo.entity.Application;
import job_application_system_training_project.demo.entity.ApplicationStatus;
import job_application_system_training_project.demo.entity.Job;
import job_application_system_training_project.demo.entity.User;
import job_application_system_training_project.demo.exceptions.DuplicateApplicationException;
import job_application_system_training_project.demo.repository.ApplicationRepository;
import job_application_system_training_project.demo.repository.JobRepository;
import job_application_system_training_project.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    public List<Application> getApplicationsByJob(UUID jobId) {
//        List<Application> jobApplications = applicationRepository.findByJob_Id(jobId);
//        return jobApplications;
        return applicationRepository.findByJob_Id(jobId);
    }

    public List<Application> getApplicationsByUser(UUID userId){
//        List<Application> userApplications = applicationRepository.findByApplicant_Id(userId);
//        return userApplications;
        return applicationRepository.findByApplicant_Id(userId);
    }

    public Application applyToJob(UUID jobId, UUID userId){

        if(applicationRepository.existsByApplicant_IdAndJob_Id(userId, jobId)){
            throw new DuplicateApplicationException("User has already applied for this job.");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        Application application = new Application();
        application.setApplicant(user);
        application.setJob(job);
        application.setStatus(ApplicationStatus.PENDING);
        application.setCreatedAt(LocalDateTime.now());
        return applicationRepository.save(application);
    }
}
