package com.lascorz.crud.UD22_3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.ProyectoController;
import com.lascorz.crud.UD22_3.dto.Proyecto;
import com.lascorz.crud.UD22_3.service.ProyectoServ;



public class VentanaBuscarProyecto  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ProyectoController proyectoController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textNombre, textId, textHoras;
	private JLabel id, nombre, horas;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarProyecto() {

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
		labelTitulo.setText("ADMINISTRAR PROYECTO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("ID");
		id.setBounds(20, 70, 80, 25);
		add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 110, 80, 25);
		add(nombre);

		horas=new JLabel();
		horas.setText("Horas");
		horas.setBounds(20, 140, 80, 25);
		add(horas);

		
		textId=new JTextField();
		textId.setBounds(80, 70, 80, 25);
		add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 110, 190, 25);
		add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(80, 140, 190, 25);
		add(textHoras);

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

				proyectoController.modificarProyecto(miProyecto);
				
				if (ProyectoServ.modificaProyecto==true) {
					habilita(true, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Proyecto miProyecto=proyectoController.buscarProyecto(textId.getText());
			if (miProyecto!=null)
			{
				muestraProyecto(miProyecto);
			}
			else if(ProyectoServ.consultaProyecto==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true,true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Proyecto?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					proyectoController.eliminarProyecto(textId.getText());
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
	private void muestraProyecto(Proyecto miProyecto) {
		textNombre.setText(miProyecto.getNombre());
		textHoras.setText(Integer.toString(miProyecto.getHoras()));
		habilita(true, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textHoras.setText("");
		textNombre.setText("");
		textId.setText("");
		habilita(true, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dni
	 * @param nombre
	 * @param horas
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean id, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
