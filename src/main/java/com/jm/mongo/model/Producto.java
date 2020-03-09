package com.jm.mongo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Date caducidad;
	private Integer cantidad;
}
