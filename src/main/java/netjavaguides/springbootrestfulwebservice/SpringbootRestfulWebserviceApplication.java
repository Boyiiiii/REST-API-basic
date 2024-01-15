package netjavaguides.springbootrestfulwebservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Documentation",
				description = "Spring Boot API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "xxx",
						email ="xxx@gmail.com"
				),
				license = @License(
						name = "APP"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "User Management Documentation"

		)
)
public class SpringbootRestfulWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebserviceApplication.class, args);
	}

}
