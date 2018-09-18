package com.utn.vista;

import javax.swing.JOptionPane;
import javax.swing.*;

public class Test {

	public static void main(String[] args) {
		
		 
		
		boolean logInState = false;
		
		LogIn login = new LogIn();
		
		login.logInPrompt();
		
		logInState = login.logInCheck();
		
		if(!logInState) 
		
		{
			
			JOptionPane.showMessageDialog(null, "Usuario y contraseña equivocados.");
			
		}
		
		else 
		
		{
			Ropa ropa = new Ropa();
			
			JOptionPane.showMessageDialog(null, "Bienvenido");
			
			RopaDAOJDBCImpl ropaDAO = new RopaDAOFactory().crearRopaDAOJDBCImpl(); 
		
			boolean seguir = true;
			
			SwingUtilities.invokeLater( new Runnable() {
	            public void run() {
	                Object[] options = {
	                		"Agregar un modelo",
	                        "Ver stock de un modelo",
	                		"Ver precio de un modelo",
	                		"Ver fabrica de origen de un modelo",
	                		"Ver fecha de inicio de produccion de un modelo",
	                		"Realizar un venta",
	                		"Modificar un modelo",
	                		"Cerrar aplicacion"
	                		};
	    			
	                JComboBox optionList = new JComboBox(options);
	                optionList.setSelectedIndex(7);
	                
	                while(seguir) {
	                
	                JOptionPane.showMessageDialog(null, optionList, "Elija una opcion", JOptionPane.QUESTION_MESSAGE);
	            int choice = optionList.getSelectedIndex();
			
	           
	                  
	                switch(choice) 
			
			{
			
			case 0:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del nuevo modelo."));
				ropaDAO.agregarModelo(ropa);
				
				break;
			case 1:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo a revisar stock"));
				ropaDAO.modeloGetStock(ropa);

				break;
			case 2:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo del que desea obtener el precio"));
				ropaDAO.modeloGetPrecio(ropa);
				
				break;
			case 3:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo del que desea saber la fabrica de origen"));
				ropaDAO.modeloGetFabrica(ropa);
				
				break;
			case 4:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo del que desea obtener la fecha de inicio de produccion"));
				ropaDAO.modeloGetFechaInicioProd(ropa);
				
				break;
			case 5:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo a vender"));
				ropaDAO.modeloRealizarVenta(ropa);
								
				break;
			case 6:
				
				ropa.setNombreModelo(JOptionPane.showInputDialog("Por favor ingrese el nombre del modelo a modificar"));
				ropaDAO.modeloModificar(ropa);
				
				break;
			default:
			
				System.exit(0);
			
			}
	                }
	           	 }
			});	
			}
		
	
		}			

}
