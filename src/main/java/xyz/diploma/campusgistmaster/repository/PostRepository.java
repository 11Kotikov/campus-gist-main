package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.diploma.campusgistmaster.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
