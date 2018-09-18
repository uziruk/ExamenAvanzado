package com.utn.vista;

import java.time.LocalDate;
import java.util.Date;

 

public class Ropa {

	private String nombreModelo;
	private float precio;
	private String fabrica;
	private LocalDate fechaInicioProd;
	private int stock;
	
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getFabrica() {
		return fabrica;
	}
	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}
	public LocalDate getFechaInicioProd() {
		return fechaInicioProd;
	}
	public void setFechaInicioProd(LocalDate localDate) {
		this.fechaInicioProd = localDate;
	}
	
	
	
}
