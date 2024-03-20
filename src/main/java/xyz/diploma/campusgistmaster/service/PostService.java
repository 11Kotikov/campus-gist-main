/**
 * Пакет для классов сервисов, реализующих бизнес-логику приложения.
 */
package xyz.diploma.campusgistmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.Post;
import xyz.diploma.campusgistmaster.repository.PostRepository;

import java.util.List;

/**
 * Этот класс является Spring сервисом, предоставляющим методы для работы с черновиками
 * заметок пользователя. Он взаимодействует с репозиторием {@link PostRepository}
 * для выполнения операций с заметками в базе данных, такими как сохранение,
 * получение, обновление и удаление.
 */
@Service
public class PostService {

    /**
     * Репозиторий для доступа к данным о заметках в базе данных.
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Сохраняет переданную заметку {@link Post} в базе данных.
     *
     * @param post Заметка, которую необходимо сохранить.
     */
    public void savePost(Post post) {
        postRepository.save(post);
    }

    /**
     * Получает список всех черновиков заметок пользователя из базы данных.
     *
     * @return Список объектов {@link Post}, представляющих черновики заметок.
     */
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    /**
     * Получает конкретную заметку по её идентификатору из базы данных.
     *
     * @param id Идентификатор заметки.
     * @return Объект {@link Post}, представляющий найденную заметку,
     *         или null, если заметка с таким идентификатором не найдена.
     */
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    /**
     * Обновляет информацию о заметке в базе данных.
     *
     * @param post Заметка с обновлёнными данными.
     */
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    /**
     * Удаляет заметку из базы данных по её идентификатору.
     *
     * @param id Идентификатор заметки, которую необходимо удалить.
     */
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    /**
     * Удаляет переданную заметку {@link Post} из базы данных.
     *
     * @param post Заметка, которую необходимо удалить.
     */
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    /**
     * Удаляет все черновики заметок пользователя из базы данных.
     */
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }
}
