package pe.edu.cibertec.CL2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pe.edu.cibertec.model","pe.edu.cibertec.repository"})
public class Cl2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cl2Application.class, args);
	}

}
