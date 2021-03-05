
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package com.lascorz.crud.UD22_3.controller;

import com.lascorz.crud.UD22_3.dto.Cientifico;
import com.lascorz.crud.UD22_3.service.CientificoServ;
import com.lascorz.crud.UD22_3.view.VentanaBuscarCientifico;
import com.lascorz.crud.UD22_3.view.VentanaPrincipal;
import com.lascorz.crud.UD22_3.view.VentanaRegistroCientifico;

public class CientificoController {

	private CientificoServ cientificoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCientifico miVentanaRegistroCientifico;
	private VentanaBuscarCientifico miVentanaBuscarCientifico;

	// Metodos getter Setters de vistas
	public CientificoServ getCientificoServ() {
		return cientificoServ;
	}

	public void setCientificoServ(CientificoServ cientificoServ) {
		this.cientificoServ = cientificoServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroCientifico getMiVentanaRegistroCientifico() {
		return miVentanaRegistroCientifico;
	}

	public void setMiVentanaRegistroCientifico(VentanaRegistroCientifico miVentanaRegistroCientifico) {
		this.miVentanaRegistroCientifico = miVentanaRegistroCientifico;
	}

	public VentanaBuscarCientifico getMiVentanaBuscarCientifico() {
		return miVentanaBuscarCientifico;
	}

	public void setMiVentanaBuscarCientifico(VentanaBuscarCientifico miVentanaBuscarCientifico) {
		this.miVentanaBuscarCientifico = miVentanaBuscarCientifico;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroCientifico.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscarCientifico.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarCientifico(Cientifico miCientifico) {
		cientificoServ.validarRegistro(miCientifico);
	}

	public Cientifico buscarCientifico(String codigoCientifico) {
		return cientificoServ.validarConsulta(codigoCientifico);
	}

	public void modificarCientifico(Cientifico miCientifico) {
		cientificoServ.validarModificacion(miCientifico);
	}

	public void eliminarCientifico(String codigo) {
		cientificoServ.validarEliminacion(codigo);
	}

}
