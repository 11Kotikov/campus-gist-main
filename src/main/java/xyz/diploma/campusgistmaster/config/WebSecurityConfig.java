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

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/to-students").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails educator1 =
                User.withDefaultPasswordEncoder()
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