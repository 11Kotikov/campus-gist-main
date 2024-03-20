package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.diploma.campusgistmaster.model.Educator;

@Repository
public interface EducatorRepository extends JpaRepository<Educator, Long> {
}
