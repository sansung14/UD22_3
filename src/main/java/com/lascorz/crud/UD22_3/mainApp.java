package com.lascorz.crud.UD22_3;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.lascorz.crud.UD22_3.controller.AsignadoController;
import com.lascorz.crud.UD22_3.controller.CientificoController;
import com.lascorz.crud.UD22_3.controller.ProyectoController;
import com.lascorz.crud.UD22_3.service.AsignadoServ;
import com.lascorz.crud.UD22_3.service.CientificoServ;
import com.lascorz.crud.UD22_3.service.ProyectoServ;
import com.lascorz.crud.UD22_3.view.VentanaBuscarAsignado;
import com.lascorz.crud.UD22_3.view.VentanaBuscarCientifico;
import com.lascorz.crud.UD22_3.view.VentanaBuscarProyecto;
import com.lascorz.crud.UD22_3.view.VentanaPrincipal;
import com.lascorz.crud.UD22_3.view.VentanaRegistroAsignado;
import com.lascorz.crud.UD22_3.view.VentanaRegistroCientifico;
import com.lascorz.crud.UD22_3.view.VentanaRegistroProyecto;



public class mainApp extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CientificoServ micientificoServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscarCientifico miVentanaBuscarCientifico;
	VentanaRegistroCientifico miVentanaRegistroCientifico;
	CientificoController cientificoController;
	
	ProyectoServ miproyectoServ;
	VentanaBuscarProyecto miVentanaBuscarProyecto;
	VentanaRegistroProyecto miVentanaRegistroProyecto;
	ProyectoController proyectoController;

	AsignadoServ miasignadoServ;
	VentanaBuscarAsignado miVentanaBuscarAsignado;
	VentanaRegistroAsignado miVentanaRegistroAsignado;
	AsignadoController asignadoController;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mainApp miPrincipal = new mainApp();
				miPrincipal.iniciar();
			}
		});
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja el sistema
	 */
	private void iniciar() {
		/* Se instancian las clases */
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaRegistroCientifico = new VentanaRegistroCientifico();
		miVentanaBuscarCientifico = new VentanaBuscarCientifico();
		micientificoServ = new CientificoServ();
		cientificoController = new CientificoController();

		miVentanaRegistroProyecto = new VentanaRegistroProyecto();
		miVentanaBuscarProyecto = new VentanaBuscarProyecto();
		miproyectoServ = new ProyectoServ();
		proyectoController = new ProyectoController();
		
		miVentanaRegistroAsignado = new VentanaRegistroAsignado();
		miVentanaBuscarAsignado = new VentanaBuscarAsignado();
		miasignadoServ = new AsignadoServ();
		asignadoController = new AsignadoController();
		
		/* Se establecen las relaciones entre clases */
		miVentanaPrincipal.setCoordinadorCientifico(cientificoController);
		miVentanaRegistroCientifico.setCoordinador(cientificoController);
		miVentanaBuscarCientifico.setCoordinador(cientificoController);
		micientificoServ.setcientificoController(cientificoController);
		
		miVentanaPrincipal.setCoordinadorProyecto(proyectoController);
		miVentanaRegistroProyecto.setCoordinador(proyectoController);
		miVentanaBuscarProyecto.setCoordinador(proyectoController);
		miproyectoServ.setproyectoController(proyectoController);
		
		miVentanaPrincipal.setCoordinadorAsignado(asignadoController);
		miVentanaRegistroAsignado.setCoordinador(asignadoController);
		miVentanaBuscarAsignado.setCoordinador(asignadoController);
		miasignadoServ.setasignadoController(asignadoController);

		/* Se establecen relaciones con la clase coordinador */
		cientificoController.setMiVentanaPrincipal(miVentanaPrincipal);
		cientificoController.setMiVentanaRegistroCientifico(miVentanaRegistroCientifico);
		cientificoController.setMiVentanaBuscarCientifico(miVentanaBuscarCientifico);
		cientificoController.setCientificoServ(micientificoServ);
		
		proyectoController.setMiVentanaPrincipal(miVentanaPrincipal);
		proyectoController.setMiVentanaRegistroProyecto(miVentanaRegistroProyecto);
		proyectoController.setMiVentanaBuscarProyecto(miVentanaBuscarProyecto);
		proyectoController.setProyectoServ(miproyectoServ);
		
		asignadoController.setMiVentanaPrincipal(miVentanaPrincipal);
		asignadoController.setMiVentanaRegistroAsignado(miVentanaRegistroAsignado);
		asignadoController.setMiVentanaBuscarAsignado(miVentanaBuscarAsignado);
		asignadoController.setAsignadoServ(miasignadoServ);

		miVentanaPrincipal.setVisible(true);
	}


}
