package com.lascorz.crud.UD22_3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.lascorz.crud.UD22_3.dto.Cientifico;
import com.lascorz.crud.UD22_3.model.conexion.Conexion;



/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class CientificoDao
{

	public void registrarCientifico(Cientifico miCientifico)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO cientificos VALUES ('"+miCientifico.getDNI()+"', '"+miCientifico.getNomApels()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"El codigo de la persona ya existe","Advertencia",JOptionPane.WARNING_MESSAGE);

		}
	}

	public Cientifico buscarCientifico(String codigo) 
	{
		Conexion conex= new Conexion();
		Cientifico cientifico= new Cientifico();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM cientificos where DNI = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cientifico.setDNI(Integer.parseInt(res.getString("DNI")));
				cientifico.setNomApels(res.getString("NomApels"));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cientifico;
			}
			else return null;				
	}

	public void modificarCientifico(Cientifico miCientifico) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE cientificos SET DNI= ? , NomApels = ?  WHERE DNI= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miCientifico.getDNI());
            estatuto.setString(2, miCientifico.getNomApels());
            estatuto.setInt(3, miCientifico.getDNI());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCientifico(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM cientificos WHERE DNI='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
