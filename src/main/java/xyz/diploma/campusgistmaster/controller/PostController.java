/**
 * Пакет для классов контроллеров Spring MVC, управляющих запросами к различным URL-адресам.
 */
package xyz.diploma.campusgistmaster.controller;

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

/**
 *  Этот класс является Spring MVC контроллером, обрабатывающим запросы, связанные с заметками.
 *  Он взаимодействует с сервисами {@link PostService} и {@link PublishedPostService}
 *  для выполнения операций с заметками, такими как создание, сохранение, получение, редактирование и удаление.
 */
@Controller
public class PostController {

    /**
     * Сервис для работы с черновиками заметок пользователя.
     */
    @Autowired
    private PostService postService;

    /**
     * Сервис для работы с опубликованными заметками.
     */
    @Autowired
    private PublishedPostService publishedPostService;

    /**
     * Конструктор класса PostController с зависимостью от сервиса PostService.
     *
     * @param postService Сервис для управления черновиками заметок.
     */
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Обрабатывает GET-запрос на "/post" и возвращает имя представления "create-post-page",
     * которое предположительно предназначено для создания новой заметки.
     *
     * @return Строка с названием представления "create-post-page".
     */
    @GetMapping("/post")
    public String makePost() {
        return "create-post-page";
    }

    /**
     * Обрабатывает POST-запрос на "/save" и вызывает сервис postService для сохранения
     * переданной в теле запроса заметки {@link Post}. После сохранения перенаправляет пользователя
     * на страницу со списком его заметок "/my-posts".
     *
     * @param post Заметка, которую необходимо сохранить.
     * @return Строка для перенаправления на "/my-posts".
     */
    @PostMapping("/save")
    public String addNote(Post post) {
        postService.savePost(post);
        return "redirect:/my-posts";
    }

    /**
     * Обрабатывает GET-запрос на "/my-posts" и использует сервис postService для получения
     * списка всех черновиков заметок пользователя. Результат помещается в ModelAndView объект
     * с названием представления "my-posts" и атрибутом "posts", содержащим список заметок.
     *
     * @return ModelAndView объект с названием представления и списком заметок.
     */
    @GetMapping("/my-posts")
    public ModelAndView showAllMyPosts() {
        List<Post> allMyPosts = postService.getAllPosts();
        return new ModelAndView("my-posts", "posts", allMyPosts);
    }

    /**
     * Обрабатывает GET-запрос на "/to-students" и использует сервис publishedPostService
     * для получения списка всех опубликованных заметок. Результат добавляется в Model объект
     * с атрибутом "posts" и названием представления "to-students".
     *
     * @param model Объект Model для хранения данных представления.
     * @return Строка с названием представления "to-students".
     */
    @GetMapping("/to-students")
    public String getMyPublishedPost(Model model) {
        List<PublishedPostList> list = publishedPostService.getAllPosts();
        model.addAttribute("posts", list);
        return "to-students";
    }

    /**
     * Обрабатывает GET-запрос на "/my-notes/{id}" с использованием PathVariable для получения
     * идентификатора заметки из URL. Затем вызывает сервис postService для получения заметки
     * по этому идентификатору. Создает объект PublishedPostList из полученной заметки и
     * вызывает сервис publishedPostService для сохранения ее как опубликованную заметку.
     * После этого перенаправляет пользователя на страницу со всеми опубликованными заметками
     * "/to-students".
     *
     * @param id Идентификатор заметки, извлекаемый из URL.
     * @return Строка для перенаправления на "/to-students".
     */
    @RequestMapping("/my-notes/{id}")
    public String getMyNotes(@PathVariable("id") Long id) {
        Post post = postService.getPostById(id);
        PublishedPostList publishedPostList = new PublishedPostList(post.getId(), post.getTitle(), post.getContent());
        publishedPostService.saveMyNote(publishedPostList);
        return "redirect:/to-students";
    }

    /**
     * Обрабатывает GET-запрос на "/deletePost/{id}" с использованием PathVariable для получения
     * идентификатора заметки из URL. Затем вызывает сервис postService для удаления заметки
     * по этому идентификатору. После удаления перенаправляет пользователя на страницу со
     * списком его заметок "/my-posts".
     *
     * @param id Идентификатор заметки, извлекаемый из URL.
     * @return Строка для перенаправления на "/my-posts".
     */
    @RequestMapping("/deletePost/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return "redirect:/my-posts";
    }

    /**
     * Обрабатывает GET-запрос на "/editPost/{id}" с использованием PathVariable для получения
     * идентификатора заметки из URL. Затем вызывает сервис postService для получения заметки
     * по этому идентификатору. Добавляет полученную заметку в Model объект с атрибутом "post"
     * и возвращает название представления "note-edit", которое предположительно предназначено
     * для редактирования заметки.
     *
     * @param id Идентификатор заметки, извлекаемый из URL.
     * @param model Объект Model для хранения данных представления.
     * @return Строка с названием представления "note-edit".
     */
    @RequestMapping("/editPost/{id}")
    public String editPost(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "note-edit";
    }
}
