package com.jm.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class })
@ComponentScan(basePackages = { "com.jm.mongo.api", "com.jm.mongo.dao" })
public class MongoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoProjectApplication.class, args);
	}

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean(name = "mongoOperations")
	public MongoOperations getMongoOperations() {
		MongoClientURI mongoUri = new MongoClientURI("mongodb+srv://<user>:<password>@cluster0-4uw90.mongodb.net/<db>?retryWrites=true&w=majority");
		return new MongoTemplate(new MongoClient(mongoUri), "<db>");
	}
}
