package com.utn.vista;

public interface RopaDAO {

	public void modeloGetStock(Ropa ropa);
	
	public void modeloGetPrecio(Ropa ropa);
	
	public void modeloGetFabrica(Ropa ropa);
	
	public void modeloGetFechaInicioProd(Ropa ropa);
	
	public int modeloRealizarVenta(Ropa ropa);
	
	public int modeloModificar(Ropa ropa);

	public String dbGetCredentials();
	
	public void dbSetCredentials();
}
