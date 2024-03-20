/**
 * Пакет для классов, представляющих модели данных в приложении.
 */
package xyz.diploma.campusgistmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Этот класс представляет сущность "опубликованная заметка" в базе данных. Он используется
 * для хранения и управления информацией об опубликованных заметках.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor  // Конструктор без аргументов, генерируемый Lombok
@Table(name = "published_post")  // Указывает таблицу в базе данных для этой сущности
public class PublishedPostList {

    /**
     * Идентификатор опубликованной заметки.
     */
    @Id
    private Long id;

    /**
     * Заголовок опубликованной заметки.
     */
    private String title;

    /**
     * Содержимое опубликованной заметки.
     */
    private String content;

    /**
     * Конструктор для создания экземпляров PublishedPostList с заданными значениями.
     *
     * @param id Идентификатор заметки.
     * @param title Заголовок заметки.
     * @param content Содержимое заметки.
     */
    public PublishedPostList(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
