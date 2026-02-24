package job_application_system_training_project.demo.repository;

import job_application_system_training_project.demo.entity.Application;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    @EntityGraph(attributePaths = {"job"})
    List<Application> findByJob_Id(UUID jobId);
    @EntityGraph(attributePaths = {"job"})
    List<Application> findByApplicant_Id(UUID userId);

    boolean existsByApplicant_IdAndJob_Id(UUID applicantId, UUID jobId); //“Υπάρχει application με αυτόν τον user και αυτό το job;”
}
