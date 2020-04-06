package com.jm.mongo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jm.mongo.model.Producto;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.util.*;

import javax.websocket.server.PathParam;

@RestController()
public class ProductoApi {

	@Value("${spring.data.mongodb.uri}")
	String uri;

	@Value("${spring.data.mongodb.database}")
	String database;
	
	@Autowired
	@Qualifier("mongoOperations")
	MongoOperations mongoOperations;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/product")
	public String getProductos() {
		try {
			return new Gson().toJson(mongoOperations.findAll(Producto.class));
		} catch (Exception e) {
			return "{\"status\":\"400\", \"error\": \"" + e.getMessage() + "\"}";
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/product/{id}")
	public String getProductoPorId(@PathVariable(value = "id") String id) {
		try {
			return new Gson().toJson(mongoOperations.findById(id, Producto.class));
		} catch (Exception e) {
			return "{\"status\":\"400\", \"error\": \"" + e.getMessage() + "\"}";
		}
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(path = "/product")
	public String newProduct(@RequestBody Producto product) {
		try {
			return new Gson().toJson(mongoOperations.insert(product));
		} catch (Exception e) {
			return "{\"status\":\"400\", \"error\": \"" + e.getMessage() + "\"}";
		}
	}
	
	@Bean(name = "mongoOperations")
	public MongoOperations getMongoOperations() {
		MongoClientURI mongoUri = new MongoClientURI(uri);
		return new MongoTemplate(new MongoClient(mongoUri), database);
	}
}
