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

import com.lascorz.crud.UD22_3.controller.CientificoController;
import com.lascorz.crud.UD22_3.dao.CientificoDao;
import com.lascorz.crud.UD22_3.dto.Cientifico;



public class CientificoServ {
	
	private CientificoController cientificoController; 
	public static boolean consultaCientifico=false;
	public static boolean modificaCientifico=false;
	
	//Metodo de vinculación con el controller principal
	public void setcientificoController(CientificoController cientificoController) {
		this.setController(cientificoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getNomApels().length()>3 && Integer.toString(miCientifico.getDNI()).length() == 8) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);						
		}else {
			if(miCientifico.getNomApels().length()<=3) {
				JOptionPane.showMessageDialog(null,"El nombre del cientifico debe ser mayor a 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
			if(Integer.toString(miCientifico.getDNI()).length() != 8) {
				JOptionPane.showMessageDialog(null,"El Dni del cientifico debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validarConsulta(String codigoCientifico) {
		CientificoDao miCientificoDao;
		
		try {
			if (codigoCientifico.length() == 8) {
				miCientificoDao = new CientificoDao();
				consultaCientifico=true;
				return miCientificoDao.buscarCientifico(codigoCientifico);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del cientifico debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCientifico=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getNomApels().length()>3 && Integer.toString(miCientifico.getDNI()).length() == 8) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(miCientifico);	
			modificaCientifico=true;
		}else{
			if(miCientifico.getNomApels().length()<=3) {
				JOptionPane.showMessageDialog(null,"El nombre del cientifico debe ser mayor a 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaCientifico=false;
			}
			if(Integer.toString(miCientifico.getDNI()).length() != 8) {
				JOptionPane.showMessageDialog(null,"El Dni del cientifico debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaCientifico=false;
			}
		}
	}
	

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		CientificoDao miCientificoDao=new CientificoDao();
		miCientificoDao.eliminarCientifico(codigo);
	}

	
	
	public CientificoController getCientificoController() {
		return cientificoController;
	}

	public void setController(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}



}
