package dauphine.miageif.site;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class MsaApplication {

	public static void main(String[] args) {
		run(MsaApplication.class, args);
	}

}