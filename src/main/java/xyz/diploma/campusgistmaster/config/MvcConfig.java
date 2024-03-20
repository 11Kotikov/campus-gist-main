/**
 * Пакет для классов конфигурации, связанных с Spring MVC.
 */
package xyz.diploma.campusgistmaster.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Этот класс реализует интерфейс WebMvcConfigurer для настройки отображения
 * контроллеров в Spring MVC. Он упрощает сопоставление URL-адресов с именами представлений
 * без необходимости создания отдельных контроллеров.
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Этот метод настраивает сопоставление URL-адресов с именами представлений.
     * Он регистрирует несколько сопоставлений для общих страниц, таких как "home",
     * "bye", "login" и "create-post-page".
     *
     * @param registry Объект ViewControllerRegistry, используемый для регистрации сопоставлений.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Сопоставляет URL-адреса с именами представлений:
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");  // Корневой URL-адрес также сопоставляется с представлением "home".
        registry.addViewController("/bye").setViewName("bye");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/create-post-page").setViewName("create-post-page");
    }
}
