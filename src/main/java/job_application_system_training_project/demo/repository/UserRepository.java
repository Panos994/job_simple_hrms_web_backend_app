package job_application_system_training_project.demo.repository;

import job_application_system_training_project.demo.entity.Application;
import job_application_system_training_project.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<Object> findByEmail(String username);
}
