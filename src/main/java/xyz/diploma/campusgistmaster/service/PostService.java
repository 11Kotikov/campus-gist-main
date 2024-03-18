package xyz.diploma.campusgistmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.Post;
import xyz.diploma.campusgistmaster.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    public void updatePost(Post post) {
        postRepository.save(post);
    }

    /**
     * Методы удаления
     *
     * @
     */
    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }

    public void deletePost(Post post) {
        postRepository.delete(post);

    }

    public void deleteAllPosts() {
        postRepository.deleteAll();

    }

}

