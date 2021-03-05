package com.lascorz.crud.UD22_3.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.AsignadoController;
import com.lascorz.crud.UD22_3.dto.Asignado;




public class VentanaRegistroAsignado extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AsignadoController asignadoController;
	private JLabel labelTitulo;
	private JTextField textCientifico, textProyecto;
	private JLabel cientifico,proyecto;
	private JButton botonGuardar,botonCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroAsignado frame = new VentanaRegistroAsignado();
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
	public VentanaRegistroAsignado() {
		botonGuardar = new JButton();
		botonGuardar.setBounds(20, 124, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(150, 124, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("Asignar Cientifico al Proyecto");
		labelTitulo.setBounds(10, 11, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cientifico=new JLabel();
		cientifico.setText("DNI");
		cientifico.setBounds(73, 52, 52, 25);
		getContentPane().add(cientifico);
		
		proyecto=new JLabel();
		proyecto.setText("Codigo Proyecto");
		proyecto.setBounds(20, 88, 105, 25);
		getContentPane().add(proyecto);

		
		textCientifico=new JTextField();
		textCientifico.setBounds(131, 52, 80, 25);
		getContentPane().add(textCientifico);
		
		textProyecto=new JTextField();
		textProyecto.setBounds(131, 88, 130, 25);
		getContentPane().add(textProyecto);
		

		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(340, 203);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textCientifico.setText("");
		textProyecto.setText("");
	}


	public void setCoordinador(AsignadoController asignadoController) {
		this.asignadoController=asignadoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Asignado miAsignado=new Asignado();
				miAsignado.setCientifico(textCientifico.getText());
				miAsignado.setProyecto(textProyecto.getText());


				asignadoController.registrarAsignado(miAsignado);	
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


