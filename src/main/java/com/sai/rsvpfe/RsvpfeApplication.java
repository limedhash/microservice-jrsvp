package com.sai.rsvpfe;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableVaadin("com.sai.rsvpfe.views")
public class RsvpfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsvpfeApplication.class, args);
	}

}
