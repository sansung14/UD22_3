package com.lascorz.crud.UD22_3.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.ProyectoController;
import com.lascorz.crud.UD22_3.dto.Proyecto;




public class VentanaRegistroProyecto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController;
	private JLabel labelTitulo;
	private JTextField textNombre, textId, textHoras;
	private JLabel nombre,id, horas;
	private JButton botonGuardar,botonCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroProyecto frame = new VentanaRegistroProyecto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistroProyecto() {
		botonGuardar = new JButton();
		botonGuardar.setBounds(20, 167, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(141, 167, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PROYECTO");
		labelTitulo.setBounds(10, 11, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("Codigo:");
		id.setBounds(73, 52, 67, 25);
		getContentPane().add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre Proyecto:");
		nombre.setBounds(20, 88, 105, 25);
		getContentPane().add(nombre);
		
		horas=new JLabel();
		horas.setText("Horas:");
		horas.setBounds(73, 124, 40, 25);
		getContentPane().add(horas);
		
		textId=new JTextField();
		textId.setBounds(131, 52, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(131, 88, 130, 25);
		getContentPane().add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(131, 124, 130, 25);
		getContentPane().add(textHoras);

		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(312, 255);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textNombre.setText("");
		textId.setText("");
		textHoras.setText("");

	}


	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Proyecto miProyecto=new Proyecto();
				miProyecto.setIdProyecto(textId.getText());
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(Integer.parseInt(textHoras.getText()));


				proyectoController.registrarProyecto(miProyecto);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
}



