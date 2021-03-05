/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la persona en
 * el Dao.
 */

package com.lascorz.crud.UD22_3.service;

import javax.swing.JOptionPane;

import com.lascorz.crud.UD22_3.controller.AsignadoController;
import com.lascorz.crud.UD22_3.dao.AsignadoDao;
import com.lascorz.crud.UD22_3.dto.Asignado;



public class AsignadoServ {
	
	private AsignadoController asignadoController; 
	public static boolean consultaAsignado=false;
	public static boolean modificaAsignado=false;
	
	//Metodo de vinculación con el controller principal
	public void setasignadoController(AsignadoController asignadoController) {
		this.setController(asignadoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Asignado miAsignado) {
		AsignadoDao miAsignadoDao;
		if (miAsignado.getCientifico().length() == 8 && miAsignado.getProyecto().length() == 4) {
			miAsignadoDao = new AsignadoDao();
			miAsignadoDao.registrarAsignado(miAsignado);						
		}else {
			if(miAsignado.getCientifico().length() != 8) {
				JOptionPane.showMessageDialog(null,"El DNi del cientifico debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
			if(miAsignado.getProyecto().length() != 4) {
				JOptionPane.showMessageDialog(null,"El codigo del proyecto debe ser de 4 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Asignado validarConsulta(String codigoAsignado) {
		AsignadoDao miAsignadoDao;
		
		try {
			if (codigoAsignado.length() == 8) {
				miAsignadoDao = new AsignadoDao();
				consultaAsignado=true;
				return miAsignadoDao.buscarAsignado(codigoAsignado);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del asignado debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaAsignado=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaAsignado=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaAsignado=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Asignado miAsignado) {
		AsignadoDao miAsignadoDao;
		if (miAsignado.getCientifico().length() == 8 && miAsignado.getProyecto().length() == 4) {
			miAsignadoDao = new AsignadoDao();
			miAsignadoDao.modificarAsignado(miAsignado);	
			modificaAsignado=true;
		}else{
			if(miAsignado.getCientifico().length() != 8 ) {
				JOptionPane.showMessageDialog(null,"El DNi del cientifico debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaAsignado=false;
			}
			if(miAsignado.getProyecto().length() != 4) {
				JOptionPane.showMessageDialog(null,"El codigo del proyecto debe ser de 4 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaAsignado=false;
			}
		}
	}
	

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		AsignadoDao miAsignadoDao=new AsignadoDao();
		miAsignadoDao.eliminarAsignado(codigo);
	}

	
	
	public AsignadoController getAsignadoController() {
		return asignadoController;
	}

	public void setController(AsignadoController asignadoController) {
		this.asignadoController = asignadoController;
	}



}
