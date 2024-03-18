package xyz.diploma.campusgistmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.PublishedPostList;
import xyz.diploma.campusgistmaster.repository.PublishedPostRepository;

import java.util.List;

@Service
public class PublishedPostService {
    @Autowired
    private PublishedPostRepository publishedPostRepository;

    public void saveMyNote(PublishedPostList post) {
        publishedPostRepository.save(post);
    }

    public List<PublishedPostList> getAllPosts() {
        return publishedPostRepository.findAll();
    }

    public void deleteMyNoteById(Long id) {
        publishedPostRepository.deleteById(id);

    }
}
