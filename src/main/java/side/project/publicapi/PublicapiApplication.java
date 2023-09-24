package side.project.publicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
// @EnableScheduling //Scheduler 시작
@SpringBootApplication
public class PublicapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicapiApplication.class, args);
	}

}
