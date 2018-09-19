package com.utn.vista;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

public interface RopaDAO {
	
	
	public Ropa modeloBuscar(Ropa ropa);
	
	public int modeloGetStock(Ropa ropa);
	
	public String modeloGetPrecio(Ropa ropa);
	
	public String modeloGetFabrica(Ropa ropa);
	
	public String modeloGetFechaInicioProd(Ropa ropa);
	
	public int modeloRealizarVenta(Ropa ropa);
	
	public int modeloModificar(Ropa ropa, Ropa nuevoRopa);

	public String dbGetCredentials();
	
	public void dbSetCredentials();
}
