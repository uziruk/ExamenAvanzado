package com.utn.vista;

import java.time.LocalDate;
import java.util.Date;

 

public class Ropa {

	private String nombreModelo;
	private float precio;
	private String precioString;
	private int fabrica;
	private String fabricaString;
	private Date fechaInicioProd;
	private String fechaString;
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
	public int getFabrica() {
		return fabrica;
	}
	public void setFabrica(int fabrica) {
		 this.fabrica = fabrica;
	}
	public Date getFechaInicioProd() {
		return fechaInicioProd;
	}
	public void setFechaInicioProd(Date date) {
		this.fechaInicioProd = date;
	}
	public String getFabricaString() {
		return fabricaString;
	}
	public void setFabricaString(String fabricaString) {
		this.fabricaString = fabricaString;
	}
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	public String getPrecioString() {
		return precioString;
	}
	public void setPrecioString(String precioString) {
		this.precioString = precioString;
	}
	
	
	
}
