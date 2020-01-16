package ru.alina.trucking.entities.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alina.trucking.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByUsername(String username);
}
