package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.diploma.campusgistmaster.model.PublishedPostList;

@Repository
public interface PublishedPostRepository extends JpaRepository <PublishedPostList, Long> {
}
