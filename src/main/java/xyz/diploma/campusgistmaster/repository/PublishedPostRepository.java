package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.diploma.campusgistmaster.model.PublishedPostList;

public interface PublishedPostRepository extends JpaRepository <PublishedPostList, Long> {
}
