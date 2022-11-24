package uzvagontamir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TransportApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TransportApplication.class, args);

		ApplicationContext contexto = new SpringApplicationBuilder(TransportApplication.class)
				.web(WebApplicationType.SERVLET)
				.headless(false)
				.run(args);
	}

}
