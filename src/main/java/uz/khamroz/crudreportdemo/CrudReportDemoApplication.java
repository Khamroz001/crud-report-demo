package uz.khamroz.crudreportdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudReportDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudReportDemoApplication.class, args);
	}

}
