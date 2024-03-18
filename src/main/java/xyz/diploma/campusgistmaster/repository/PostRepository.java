package xyz.diploma.campusgistmaster.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.diploma.campusgistmaster.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
