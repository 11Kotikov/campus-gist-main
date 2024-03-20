/**
 * Пакет для классов сервисов, реализующих бизнес-логику приложения.
 */
package xyz.diploma.campusgistmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.PublishedPostList;
import xyz.diploma.campusgistmaster.repository.PublishedPostRepository;

import java.util.List;

/**
 *  Этот класс является Spring сервисом, предоставляющим методы для работы с
 *  опубликованными заметками. Он взаимодействует с репозиторием
 *  {@link PublishedPostRepository} для выполнения операций с опубликованными
 *  заметками в базе данных, такими как сохранение, получение и удаление.
 */
@Service
public class PublishedPostService {

    /**
     * Репозиторий для доступа к данным об опубликованных заметках в базе данных.
     */
    @Autowired
    private PublishedPostRepository publishedPostRepository;

    /**
     * Сохраняет переданный объект {@link PublishedPostList}, представляющий
     * опубликованную заметку, в базе данных.
     *
     * @param post Объект PublishedPostList, содержащий данные опубликованной заметки.
     */
    public void saveMyNote(PublishedPostList post) {
        publishedPostRepository.save(post);
    }

    /**
     * Получает список всех опубликованных заметок из базы данных.
     *
     * @return Список объектов {@link PublishedPostList}, представляющих опубликованные заметки.
     */
    public List<PublishedPostList> getAllPosts() {
        return publishedPostRepository.findAll();
    }

    /**
     * Удаляет опубликованную заметку из базы данных по её идентификатору.
     *
     * @param id Идентификатор опубликованной заметки, которую необходимо удалить.
     */
    public void deleteMyNoteById(Long id) {
        publishedPostRepository.deleteById(id);
    }
}
