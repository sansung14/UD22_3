package com.lascorz.crud.UD22_3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.CientificoController;
import com.lascorz.crud.UD22_3.dto.Cientifico;
import com.lascorz.crud.UD22_3.service.CientificoServ;



public class VentanaBuscarCientifico  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private CientificoController cientificoController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textNombre, textDni;
	private JLabel dni, nombre;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 70, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR CIENTIFICO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(20, 70, 80, 25);
		add(dni);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 110, 80, 25);
		add(nombre);


		
		textDni=new JTextField();
		textDni.setBounds(80, 70, 80, 25);
		add(textDni);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 110, 190, 25);
		add(textNombre);

		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		add(botonCancelar);
		add(botonBuscar);
		add(botonModificar);
		add(botonEliminar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

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

				cientificoController.modificarCientifico(miCientifico);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico miCientifico=cientificoController.buscarCientifico(textDni.getText());
			if (miCientifico!=null)
			{
				muestraCientifico(miCientifico);
			}
			else if(CientificoServ.consultaCientifico==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textDni.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					cientificoController.eliminarCientifico(textDni.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraCientifico(Cientifico miCientifico) {
		textNombre.setText(miCientifico.getNomApels());
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textNombre.setText("");
		textDni.setText("");
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dni
	 * @param nombre
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean dni, boolean nombre, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDni.setEditable(dni);
		textNombre.setEditable(nombre);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
