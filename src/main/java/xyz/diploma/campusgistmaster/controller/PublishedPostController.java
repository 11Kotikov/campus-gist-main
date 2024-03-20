/**
 * Пакет для классов Spring MVC контроллеров, управляющих запросами к различным URL-адресам.
 */
package xyz.diploma.campusgistmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.diploma.campusgistmaster.service.PublishedPostService;

/**
 *  Этот класс является Spring MVC контроллером, обрабатывающим запрос на удаление
 *  опубликованной заметки. Он взаимодействует с сервисом {@link PublishedPostService}
 *  для удаления заметки по её идентификатору.
 */
@Controller
public class PublishedPostController {

    /**
     * Сервис для работы с опубликованными заметками.
     */
    @Autowired
    private PublishedPostService publishedPostService;

    /**
     * Обрабатывает GET-запрос на "/deleteMyNote/{id}" с использованием PathVariable для
     * получения идентификатора заметки из URL. Затем вызывает сервис publishedPostService
     * для удаления опубликованной заметки по этому идентификатору. После удаления
     * перенаправляет пользователя на страницу со всеми опубликованными заметками "/to-students".
     *
     * @param id Идентификатор опубликованной заметки, извлекаемый из URL.
     * @return Строка для перенаправления на "/to-students".
     */
    @RequestMapping("/deleteMyNote/{id}")
    public String deleteMyNote(@PathVariable Long id) {
        publishedPostService.deleteMyNoteById(id);
        return "redirect:/to-students";
    }
}
