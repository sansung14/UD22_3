package com.lascorz.crud.UD22_3.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.CientificoController;
import com.lascorz.crud.UD22_3.dto.Cientifico;




public class VentanaRegistroCientifico extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CientificoController cientificoController;
	private JLabel labelTitulo;
	private JTextField textNombre, textDni;
	private JLabel nombre,dni;
	private JButton botonGuardar,botonCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroCientifico frame = new VentanaRegistroCientifico();
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
	public VentanaRegistroCientifico() {
		botonGuardar = new JButton();
		botonGuardar.setBounds(20, 124, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(150, 124, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CIENTIFICOS");
		labelTitulo.setBounds(10, 11, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		dni=new JLabel();
		dni.setText("Codigo");
		dni.setBounds(73, 52, 52, 25);
		getContentPane().add(dni);
		
		nombre=new JLabel();
		nombre.setText("Nombre Apellidos");
		nombre.setBounds(20, 88, 105, 25);
		getContentPane().add(nombre);

		
		textDni=new JTextField();
		textDni.setBounds(131, 52, 80, 25);
		getContentPane().add(textDni);
		
		textNombre=new JTextField();
		textNombre.setBounds(131, 88, 130, 25);
		getContentPane().add(textNombre);
		

		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(312, 203);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textNombre.setText("");
		textDni.setText("");
	}


	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico miCientifico=new Cientifico();
				miCientifico.setDNI(Integer.parseInt(textDni.getText()));
				miCientifico.setNomApels(textNombre.getText());


				cientificoController.registrarCientifico(miCientifico);	
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


