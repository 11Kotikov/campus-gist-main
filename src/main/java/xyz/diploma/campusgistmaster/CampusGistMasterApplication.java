package xyz.diploma.campusgistmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Это Spring веб-приложение предназначенное для отправки заметок/заданий
 * от преподавателя студентам учебных заведений
 *
 * @author Andrey Petran <a href="https://github.com/11Kotikov">...</a>
 * @version 1.0
 */
@SpringBootApplication
public class CampusGistMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusGistMasterApplication.class, args);
	}

}
