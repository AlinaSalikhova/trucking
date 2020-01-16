package ru.alina.trucking.entities.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alina.trucking.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUsername(String username);
}
