package xyz.diploma.campusgistmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.diploma.campusgistmaster.service.PublishedPostService;

@Controller
public class PublishedPostController {
    @Autowired
    private PublishedPostService publishedPostService;

    @RequestMapping("/deleteMyNote/{id}")
    public String deleteMyNote(@PathVariable Long id) {
        publishedPostService.deleteMyNoteById(id);
        return "redirect:/to-students";

    }
}
