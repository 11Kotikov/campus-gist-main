package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.diploma.campusgistmaster.model.Educator;

public interface EducatorRepository extends JpaRepository<Educator, Long> {
}
