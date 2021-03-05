package com.lascorz.crud.UD22_3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.lascorz.crud.UD22_3.dto.Asignado;
import com.lascorz.crud.UD22_3.model.conexion.Conexion;



/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class AsignadoDao
{

	public void registrarAsignado(Asignado miAsignado)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO asignado VALUES ('"+miAsignado.getCientifico()+"', '"+miAsignado.getProyecto()+"');";
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

	public Asignado buscarAsignado(String codigo) 
	{
		Conexion conex= new Conexion();
		Asignado asignado= new Asignado();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM asignado INNER JOIN cientificos on cientificos.DNI=asignado.cientifico INNER JOIN proyecto on proyecto.id=asignado.proyecto where cientifico = ?";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				asignado.setCientifico(res.getString("cientifico"));
				asignado.setProyecto(res.getString("proyecto"));
				asignado.setNomApels(res.getString("NomApels"));
				asignado.setNombre(res.getString("nombre"));
				asignado.setHoras(Integer.parseInt(res.getString("horas")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return asignado;
			}
			else return null;				
	}

	public void modificarAsignado(Asignado miAsignado) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE asignado SET cientifico= ? , proyecto = ?  WHERE cientifico= ? and proyecto= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miAsignado.getCientifico());
            estatuto.setString(2, miAsignado.getProyecto());
            estatuto.setString(3, miAsignado.getCientifico());
            estatuto.setString(4, miAsignado.getProyecto());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarAsignado(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM asignado WHERE cientifico='"+codigo+"'";
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
