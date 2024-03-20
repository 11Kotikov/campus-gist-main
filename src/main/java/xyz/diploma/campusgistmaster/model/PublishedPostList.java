package xyz.diploma.campusgistmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="published_post")

public class PublishedPostList {

    @Id
    private Long id;
    private String title;
    private String content;

    public PublishedPostList(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}

