/**
 * Пакет для классов конфигурации, связанных с Spring Security.
 */
package xyz.diploma.campusgistmaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Этот класс определяет конфигурации Spring Security для приложения.
 * Он аннотируется {@link EnableWebSecurity}
 * для включения веб-безопасности.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Этот метод определяет цепочку безопасности для приложения.
     * Использует объект {@link HttpSecurity} для настройки правил авторизации
     * и формы входа в систему.
     *
     * @param http Объект HttpSecurity, используемый для настройки безопасности.
     * @return SecurityFilterChain Объект цепочки безопасности.
     * @throws Exception Если возникает ошибка при настройке безопасности.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Определяет правила авторизации для разных шаблонов URL.
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/to-students").permitAll() // Разрешает доступ к этим URL без аутентификации.
                        .anyRequest().authenticated() // Требует аутентификации для любого другого запроса.
                )
                // Настраивает параметры формы входа.
                .formLogin((form) -> form
                        .loginPage("/login")  // Устанавливает URL страницы входа.
                        .permitAll()         // Разрешает доступ к странице входа без аутентификации.
                )
                // Настраивает поведение выхода из системы.
                .logout((logout) -> logout.permitAll());  // Разрешает любому выйти из системы.

        return http.build();
    }

    /**
     * Этот метод создает объект типа {@link UserDetailsService}.
     * Он определяет три учетные записи пользователей в памяти с ролями "преподаватель".
     *
     * @return UserDetailsService Bean, который предоставляет сведения о пользователях.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails educator1 =
                User.withDefaultPasswordEncoder() // Использует кодировщик паролей по умолчанию Spring.
                        .username("head")
                        .password("123")
                        .roles("EDUCATOR")
                        .build();
        UserDetails educator2 =
                User.withDefaultPasswordEncoder()
                        .username("neck")
                        .password("456")
                        .roles("EDUCATOR")
                        .build();
        UserDetails educator3 =
                User.withDefaultPasswordEncoder()
                        .username("shoulders")
                        .password("789")
                        .roles("EDUCATOR")
                        .build();

        return new InMemoryUserDetailsManager(educator1, educator2, educator3);
    }
}