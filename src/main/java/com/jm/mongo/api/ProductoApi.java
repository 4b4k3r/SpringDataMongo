package com.jm.mongo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.mongo.model.Producto;

import java.util.*;

import javax.websocket.server.PathParam;

@RestController()
public class ProductoApi {

	@Autowired
	@Qualifier("mongoOperations")
	MongoOperations mongoOperations;

	@GetMapping(path = "/product/list")
	public List<Producto> getProductos() {
		return new LinkedList<>();
	}

	@PutMapping(path = "/puduct")
	public String newProduct(@PathParam(value = "product") Producto product) {
		try {
			mongoOperations.insert(product);
			return "{\"status\":\"200\"}";
		} catch (Exception e) {
			return "{\"status\":\"400\", \"error\": \"" + e.getMessage() + "\"}";
		}
	}
}
