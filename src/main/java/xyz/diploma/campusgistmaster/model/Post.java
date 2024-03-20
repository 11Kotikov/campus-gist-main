/**
 * Пакет для классов, представляющих модели данных в приложении.
 */
package xyz.diploma.campusgistmaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Этот класс представляет сущность "заметка" в базе данных. Он используется для
 * хранения и управления информацией о заметках пользователя.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")  // Указывает таблицу в базе данных, соответствующую этой сущности
@SequenceGenerator(name = "post_seq", sequenceName = "post_seq", allocationSize = 1)  // Генератор последовательностей для автогенерации идентификаторов заметок
public class Post {

    /**
     * Идентификатор заметки, генерируемый автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @Column(name = "id")
    private Long id;

    /**
     * Заголовок заметки.
     */
    @Column(name = "title")
    private String title;

    /**
     * Содержимое заметки.
     */
    @Column(name = "content")
    private String content;
}
