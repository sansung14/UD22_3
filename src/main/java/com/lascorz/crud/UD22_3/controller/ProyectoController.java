
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package com.lascorz.crud.UD22_3.controller;

import com.lascorz.crud.UD22_3.dto.Proyecto;
import com.lascorz.crud.UD22_3.service.ProyectoServ;
import com.lascorz.crud.UD22_3.view.VentanaBuscarProyecto;
import com.lascorz.crud.UD22_3.view.VentanaPrincipal;
import com.lascorz.crud.UD22_3.view.VentanaRegistroProyecto;

public class ProyectoController {

	private ProyectoServ proyectoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroProyecto miVentanaRegistroProyecto;
	private VentanaBuscarProyecto miVentanaBuscarProyecto;

	// Metodos getter Setters de vistas
	public ProyectoServ getProyectoServ() {
		return proyectoServ;
	}

	public void setProyectoServ(ProyectoServ proyectoServ) {
		this.proyectoServ = proyectoServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroProyecto getMiVentanaRegistroProyecto() {
		return miVentanaRegistroProyecto;
	}

	public void setMiVentanaRegistroProyecto(VentanaRegistroProyecto miVentanaRegistroProyecto) {
		this.miVentanaRegistroProyecto = miVentanaRegistroProyecto;
	}

	public VentanaBuscarProyecto getMiVentanaBuscarProyecto() {
		return miVentanaBuscarProyecto;
	}

	public void setMiVentanaBuscarProyecto(VentanaBuscarProyecto miVentanaBuscarProyecto) {
		this.miVentanaBuscarProyecto = miVentanaBuscarProyecto;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroProyecto.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscarProyecto.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarProyecto(Proyecto miProyecto) {
		proyectoServ.validarRegistro(miProyecto);
	}

	public Proyecto buscarProyecto(String codigoProyecto) {
		return proyectoServ.validarConsulta(codigoProyecto);
	}

	public void modificarProyecto(Proyecto miProyecto) {
		proyectoServ.validarModificacion(miProyecto);
	}

	public void eliminarProyecto(String codigo) {
		proyectoServ.validarEliminacion(codigo);
	}

}
