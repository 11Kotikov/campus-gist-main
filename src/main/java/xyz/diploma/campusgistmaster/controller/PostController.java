package xyz.diploma.campusgistmaster.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.diploma.campusgistmaster.model.Post;
import xyz.diploma.campusgistmaster.model.PublishedPostList;
import xyz.diploma.campusgistmaster.service.PostService;
import xyz.diploma.campusgistmaster.service.PublishedPostService;

import java.util.List;

@Controller
@Data
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PublishedPostService publishedPostService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String makePost() {
        return "create-post-page";
    }

    @PostMapping("/save")
    public String addNote(Post post) {
        postService.savePost(post);
        return "redirect:/my-posts";
    }

    @GetMapping("/my-posts")
    public ModelAndView showAllMyPosts() {
        List<Post> allMyPosts = postService.getAllPosts();
        return new ModelAndView("my-posts", "posts", allMyPosts);
    }

    @GetMapping("/to-students")
    public String getMyPublishedPost(Model model) {
        List<PublishedPostList> list = publishedPostService.getAllPosts();
        model.addAttribute("posts", list);
        return "to-students";
    }

    @RequestMapping("/my-notes/{id}")
    public String getMyNotes(@PathVariable("id") Long id) {
        Post post = postService.getPostById(id);
        PublishedPostList publishedPostList = new PublishedPostList(post.getId(), post.getTitle(), post.getContent());
        publishedPostService.saveMyNote(publishedPostList);
        return "redirect:/to-students";
    }

    @RequestMapping("/deletePost/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return "redirect:/my-posts";
    }

    @RequestMapping("/editPost/{id}")
    public String editPost(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "note-edit";
    }


}
