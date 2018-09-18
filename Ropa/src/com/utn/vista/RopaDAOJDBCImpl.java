package com.utn.vista;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;

import javax.swing.JOptionPane;

public class RopaDAOJDBCImpl implements RopaDAO {

	public String url = "jdbc:mysql://localhost:3306/ropa?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public void modeloGetStock(Ropa ropa) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT stock FROM modelos WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				ropa.setStock(Integer.parseInt(rs.getString("stock")));

				JOptionPane.showMessageDialog(null,
						"El stock del modelo " + ropa.getNombreModelo() + " es " + ropa.getStock());

			}

			else

			{

				JOptionPane.showMessageDialog(null, "modelo no encontrado");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{
				rs.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

	}

	public void modeloGetPrecio(Ropa ropa)

	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT precio FROM modelos WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				ropa.setPrecio(Float.parseFloat(rs.getString("precio")));

				JOptionPane.showMessageDialog(null,
						"El precio del modelo " + ropa.getNombreModelo() + " es " + ropa.getPrecio());

			}

			else

			{

				JOptionPane.showMessageDialog(null, "Precio no encontrado");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{
				rs.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

	}

	public void modeloGetFabrica(Ropa ropa)

	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT * FROM modelos INNER JOIN fabricas WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				ropa.setFabrica(rs.getString("f_nombre"));

				JOptionPane.showMessageDialog(null,
						"La fabrica del modelo " + ropa.getNombreModelo() + " es " + ropa.getFabrica());

			}

			else

			{

				JOptionPane.showMessageDialog(null, "Fabrica no encontrada");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{

				rs.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

	}

	public void modeloGetFechaInicioProd(Ropa ropa)

	{

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT fecha_inicio_prod FROM modelos WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				ropa.setFechaInicioProd(LocalDate.parse(rs.getString("fecha_inicio_prod")));

				JOptionPane.showMessageDialog(null, "LA fecha de inicio de produccion del modelo "
						+ ropa.getNombreModelo() + " es " + ropa.getFechaInicioProd());

			}

			else

			{

				JOptionPane.showMessageDialog(null, "Fecha no encontrada");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{

				rs.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

	}

	public int modeloRealizarVenta(Ropa ropa)

	{
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT stock FROM modelos WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				ropa.setStock(rs.getInt("stock"));

				if (ropa.getStock() >= 0) {

					stmt1 = con.prepareStatement("UPDATE modelos SET stock = ? WHERE nombre_modelo = ?");

					stmt1.setInt(1, (ropa.getStock() - 1));

					stmt1.setString(2, ropa.getNombreModelo());

					JOptionPane.showMessageDialog(null, "Venta realizada con exito");

					return stmt1.executeUpdate();
				}
				else {

					JOptionPane.showMessageDialog(null,
							"Error en el proseamiento de la venta.\nRevise que haya stock del modelo.");

				}
			}

			else

			{

				JOptionPane.showMessageDialog(null,
						"Error en el proseamiento de la venta.\nModelo no encontrado.");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{
				rs.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}
		return 0;
	}

	public int modeloModificar(Ropa ropa)

	{
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;

		try

		{

			con = DriverManager.getConnection(url, "root", dbGetCredentials());

			stmt = con.prepareStatement("SELECT * FROM modelos WHERE nombre_modelo = ?");

			stmt.setString(1, ropa.getNombreModelo());

			rs = stmt.executeQuery();

			if (rs.next())

			{

				String[] options = { "chon-wan", "JFK", "umbakte" };
				stmt1 = con.prepareStatement(
						"UPDATE modelos SET nombre_modelo = ?, precio = ?, fabrica = ?, fecha_inicio_prod = ?, stock = ? WHERE nombre_modelo = ?");

				stmt1.setString(1, JOptionPane.showInputDialog("Ingrese un nuevo nombre."));
				stmt1.setFloat(2, Float.parseFloat(JOptionPane.showInputDialog("Ingrese un nuevo precio.")));
				stmt1.setInt(3, ((JOptionPane.showOptionDialog(null, "Por favor elija una fabrica", null, 0, 0, null,
						options, 0)) + 1));

				Date date;
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane
							.showInputDialog("Por favor ingrese la fecha de inicio de produccion en dd/mm/yyyy"));

					java.sql.Date dateSql = new java.sql.Date(date.getTime());

					stmt1.setDate(4, dateSql);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				stmt1.setInt(5, Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el stock")));
				stmt1.setString(6, ropa.getNombreModelo());

				JOptionPane.showMessageDialog(null, "Modificacion realizada con exito");

				return stmt1.executeUpdate();
			}

			else

			{

				JOptionPane.showMessageDialog(null, "Error en el proseamiento de la modificacion.");

			}

		}

		catch (SQLException e)

		{

			throw new RuntimeException(e);

		}

		finally

		{

			try

			{
				rs.close();
				stmt1.close();
				stmt.close();
				con.close();

			}

			catch (SQLException e)

			{

				e.printStackTrace();

			}

		}
		return 0;

	}

	public int agregarModelo(Ropa ropa) {
		{
			Connection con = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			ResultSet rs = null;

			try

			{
				String password = dbGetCredentials();
				System.out.println(password);
				con = DriverManager.getConnection(url, "root", password);

				stmt = con.prepareStatement("SELECT * FROM modelos WHERE nombre_modelo = ?");

				stmt.setString(1, ropa.getNombreModelo());

				rs = stmt.executeQuery();

				if (!rs.next())

				{

					String[] options = { "chon-wan", "JFK", "umbakte" };
					stmt1 = con.prepareStatement(
							"INSERT INTO modelos (nombre_modelo, precio, fabrica, fecha_inicio_prod, stock) VALUES (?,?,?,?,?)");
					stmt1.setString(1, ropa.getNombreModelo());
					stmt1.setFloat(2, Float.parseFloat(JOptionPane.showInputDialog("Ingrese un  precio.")));
					stmt1.setInt(3, ((JOptionPane.showOptionDialog(null, "Por favor elija una fabrica", null, 0, 0,
							null, options, 0)) + 1));

					Date date;
					try {
						date = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane
								.showInputDialog("Por favor ingrese la fecha de inicio de produccion en dd/mm/yyyy"));

						java.sql.Date dateSql = new java.sql.Date(date.getTime());

						stmt1.setDate(4, dateSql);
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					stmt1.setInt(5, Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el stock")));

					JOptionPane.showMessageDialog(null, "Nuevo modelo ingresado con exito");

					return stmt1.executeUpdate();
				}

				else

				{

					JOptionPane.showMessageDialog(null, "Modelo ya existente.");

				}

			}

			catch (SQLException e)

			{

				throw new RuntimeException(e);

			}

			finally

			{

			}
			return 0;

		}

	}

	public String dbGetCredentials()

	{

		Path file = Paths.get("C:\\Users\\Laboratorio\\Desktop\\dbCredentials.txt");

		ObjectInputStream in;
		try

		{

			in = new ObjectInputStream(Files.newInputStream(file));

			StringBuilder cred = (StringBuilder) in.readObject();
			StringBuilder tmp = new StringBuilder();
			final int OFFSET = 4;

			for (int i = 0; i < cred.length(); i++)

			{

				tmp.append((char) (cred.charAt(i) - OFFSET));

			}

			String reversed = new StringBuffer(tmp.toString()).reverse().toString();
			return new String(Base64.getDecoder().decode(reversed));

		}

		catch (IOException | ClassNotFoundException e)

		{

			e.printStackTrace();

		}

		return null;

	}

	// Esta comentado porque si bien estaria bueno poder cambiar la pass desde el
	// programa
	// esto implicaria hacer el acceso al archivo config de sql y no al archivo del
	// cual levanta
	// el pass encriptado

	@Override
	public void dbSetCredentials()

	{

		/*
		 * Path file = Paths.get("C:\\Users\\Laboratorio\\Desktop\\dbCredentials.txt");
		 * 
		 * ObjectOutputStream out; try {
		 * 
		 * out = new ObjectOutputStream(Files.newOutputStream(file));
		 * 
		 * String b64encoded = Base64.getEncoder().encodeToString("asd123".getBytes());
		 * 
		 * String reverse = new StringBuffer(b64encoded).reverse().toString();
		 * 
		 * StringBuilder tmp = new StringBuilder(); final int OFFSET = 4; for (int i =
		 * 0; i < reverse.length(); i++) { tmp.append((char) (reverse.charAt(i) +
		 * OFFSET)); }
		 * 
		 * out.writeObject(tmp);
		 * 
		 * } catch (IOException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */

	}
}
