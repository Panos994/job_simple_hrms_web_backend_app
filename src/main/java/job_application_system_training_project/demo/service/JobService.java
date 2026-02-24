package job_application_system_training_project.demo.service;


import job_application_system_training_project.demo.dto.ApplyJobRequestDTO;
import job_application_system_training_project.demo.dto.CreateJobRequestDTO;
import job_application_system_training_project.demo.entity.Application;
import job_application_system_training_project.demo.entity.Job;
import job_application_system_training_project.demo.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(CreateJobRequestDTO createJobRequestDTO){
        Job job = new Job();
        job.setDescription(createJobRequestDTO.getDescription());
        job.setPositionName(createJobRequestDTO.getPositionName());

        return jobRepository.save(job);
    }


}
