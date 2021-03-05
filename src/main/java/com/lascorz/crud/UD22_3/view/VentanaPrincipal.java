package com.lascorz.crud.UD22_3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.lascorz.crud.UD22_3.controller.AsignadoController;
import com.lascorz.crud.UD22_3.controller.CientificoController;
import com.lascorz.crud.UD22_3.controller.ProyectoController;


public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private CientificoController cientificoController; //objeto PersonaController que permite la relacion entre esta clase y la clase PersonaController
	private ProyectoController proyectoController;
	private AsignadoController asignadoController;
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion, labelProyecto, labelAssignado;
	private JButton botonRegistrarCientifico,botonBuscarCientifico, botonRegistrarProyecto, botonBuscarProyecto, botonRegistrarAsignado, botonBuscarAsignado;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrarCientifico = new JButton();
		botonRegistrarCientifico.setBounds(100, 180, 120, 25);
		botonRegistrarCientifico.setText("Registrar Cientifico");
		
		botonBuscarCientifico = new JButton();
		botonBuscarCientifico.setBounds(240, 180, 120, 25);
		botonBuscarCientifico.setText("Buscar Cientifico");

		
		botonRegistrarProyecto = new JButton();
		botonRegistrarProyecto.setBounds(100, 240, 120, 25);
		botonRegistrarProyecto.setText("Registrar Proyecto");
		
		botonBuscarProyecto = new JButton();
		botonBuscarProyecto.setBounds(240, 240, 120, 25);
		botonBuscarProyecto.setText("Buscar Proyecto");
		
		
		botonRegistrarAsignado = new JButton();
		botonRegistrarAsignado.setBounds(100, 300, 120, 25);
		botonRegistrarAsignado.setText("Asignar proyectos");
		
		botonBuscarAsignado = new JButton();
		botonBuscarAsignado.setBounds(240, 300, 120, 25);
		botonBuscarAsignado.setText("Buscar proyectos asignados");
		
		
		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar para Cientifico:");
		labelSeleccion.setBounds(75, 150, 300, 25);

		labelProyecto = new JLabel();
		labelProyecto.setText("Escoja que operacion desea realizar para proyecto:");
		labelProyecto.setBounds(75, 210, 300, 25);
		
		labelAssignado = new JLabel();
		labelAssignado.setText("Escoja que operacion desea realizar para assignar proyectos:");
		labelAssignado.setBounds(75, 270, 360, 25);

		textoIntroduccion = "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cientifico, proyecto y asignado_a.";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 60);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrarProyecto.addActionListener(this);
		botonBuscarCientifico.addActionListener(this);
		botonRegistrarCientifico.addActionListener(this);
		botonBuscarProyecto.addActionListener(this);
		botonRegistrarAsignado.addActionListener(this);
		botonBuscarAsignado.addActionListener(this);
		
		add(botonRegistrarCientifico);
		add(botonBuscarCientifico);
		add(botonRegistrarProyecto);
		add(botonBuscarProyecto);
		add(botonRegistrarAsignado);
		add(botonBuscarAsignado);
		add(labelAssignado);
		add(labelProyecto);
		add(labelSeleccion);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(480, 450);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinadorCientifico(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}
	
	public void setCoordinadorProyecto(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	
	public void setCoordinadorAsignado(AsignadoController asignadoController) {
		this.asignadoController=asignadoController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrarCientifico) {
			cientificoController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscarCientifico) {
			cientificoController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonRegistrarProyecto) {
			proyectoController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscarProyecto) {
			proyectoController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonRegistrarAsignado) {
			asignadoController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscarAsignado) {
			asignadoController.mostrarVentanaConsulta();			
		}
	}
}
