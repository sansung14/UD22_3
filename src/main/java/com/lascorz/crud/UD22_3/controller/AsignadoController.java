
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package com.lascorz.crud.UD22_3.controller;

import com.lascorz.crud.UD22_3.dto.Asignado;
import com.lascorz.crud.UD22_3.service.AsignadoServ;
import com.lascorz.crud.UD22_3.view.VentanaBuscarAsignado;
import com.lascorz.crud.UD22_3.view.VentanaPrincipal;
import com.lascorz.crud.UD22_3.view.VentanaRegistroAsignado;

public class AsignadoController {

	private AsignadoServ asignadoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroAsignado miVentanaRegistroAsignado;
	private VentanaBuscarAsignado miVentanaBuscarAsignado;

	// Metodos getter Setters de vistas
	public AsignadoServ getAsignadoServ() {
		return asignadoServ;
	}

	public void setAsignadoServ(AsignadoServ asignadoServ) {
		this.asignadoServ = asignadoServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroAsignado getMiVentanaRegistroAsignado() {
		return miVentanaRegistroAsignado;
	}

	public void setMiVentanaRegistroAsignado(VentanaRegistroAsignado miVentanaRegistroAsignado) {
		this.miVentanaRegistroAsignado = miVentanaRegistroAsignado;
	}

	public VentanaBuscarAsignado getMiVentanaBuscarAsignado() {
		return miVentanaBuscarAsignado;
	}

	public void setMiVentanaBuscarAsignado(VentanaBuscarAsignado miVentanaBuscarAsignado) {
		this.miVentanaBuscarAsignado = miVentanaBuscarAsignado;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroAsignado.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscarAsignado.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarAsignado(Asignado miAsignado) {
		asignadoServ.validarRegistro(miAsignado);
	}

	public Asignado buscarAsignado(String codigoAsignado) {
		return asignadoServ.validarConsulta(codigoAsignado);
	}

	public void modificarAsignado(Asignado miAsignado) {
		asignadoServ.validarModificacion(miAsignado);
	}

	public void eliminarAsignado(String codigo) {
		asignadoServ.validarEliminacion(codigo);
	}

}
