package xyz.diploma.campusgistmaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name="published_post")

public class PublishedPostList {

    @Id
    private Long id;
    private String title;
    private String content;
    public PublishedPostList() {
        super();
    }

    public PublishedPostList(Long id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
