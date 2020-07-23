package com.jm.mongo.model;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Document(collection = "Products")
public class Producto {
	
	@Id
	private String id;
	
	private String nombre;
	private String descripcion;
	private Double precio;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	@DateTimeFormat(pattern = "yyyy/MM/dd", iso = ISO.DATE)
	@CreatedDate
	private Date caducidad;
	private Integer cantidad;
	
	public Producto() {
		
	}
}
