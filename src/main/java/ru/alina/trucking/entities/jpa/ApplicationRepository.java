package ru.alina.trucking.entities.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alina.trucking.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	Optional<Application> findById(Long id);
}
