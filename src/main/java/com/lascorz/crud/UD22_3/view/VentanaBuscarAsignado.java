package com.lascorz.crud.UD22_3.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lascorz.crud.UD22_3.controller.AsignadoController;
import com.lascorz.crud.UD22_3.dto.Asignado;
import com.lascorz.crud.UD22_3.service.AsignadoServ;



public class VentanaBuscarAsignado extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private AsignadoController asignadoController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textCientifico, textProyecto, textNomApels, textNombre, textHoras;
	private JLabel cientifico, proyecto, NomApels, nombre,horas;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;

	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarAsignado() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(200, 70, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR PROYECTOS ASIGNADOS");
		labelTitulo.setBounds(20, 11, 430, 48);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cientifico=new JLabel();
		cientifico.setText("DNI Cientifico");
		cientifico.setBounds(20, 70, 80, 25);
		getContentPane().add(cientifico);
		
		proyecto=new JLabel();
		proyecto.setText("Proyecto:");
		proyecto.setBounds(20, 152, 80, 25);
		getContentPane().add(proyecto);


		
		textCientifico=new JTextField();
		textCientifico.setBounds(110, 70, 80, 25);
		getContentPane().add(textCientifico);
		
		textProyecto=new JTextField();
		textProyecto.setBounds(76, 152, 50, 25);
		getContentPane().add(textProyecto);

		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		NomApels = new JLabel("Nombre Ap.:");
		NomApels.setBounds(20, 116, 96, 14);
		getContentPane().add(NomApels);
		
		textNomApels = new JTextField();
		textNomApels.setText("");
		textNomApels.setEditable(false);
		textNomApels.setBounds(110, 111, 140, 25);
		getContentPane().add(textNomApels);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(144, 157, 46, 14);
		getContentPane().add(nombre);
		
		textNombre = new JTextField();
		textNombre.setText("");
		textNombre.setEditable(false);
		textNombre.setBounds(200, 152, 120, 25);
		getContentPane().add(textNombre);
		
		textHoras = new JTextField();
		textHoras.setText("");
		textHoras.setEditable(false);
		textHoras.setBounds(373, 152, 50, 25);
		getContentPane().add(textHoras);
		
		horas = new JLabel("Horas:");
		horas.setBounds(330, 157, 46, 14);
		getContentPane().add(horas);
		limpiar();


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

				asignadoController.modificarAsignado(miAsignado);
				
				if (AsignadoServ.modificaAsignado==true) {
					habilita(true, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Asignado miAsignado=asignadoController.buscarAsignado(textCientifico.getText());
			if (miAsignado!=null)
			{
				muestraAsignado(miAsignado);
			}
			else if(AsignadoServ.consultaAsignado==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCientifico.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Asignado?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					asignadoController.eliminarAsignado(textCientifico.getText());
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
	private void muestraAsignado(Asignado miAsignado) {
		textCientifico.setText(miAsignado.getCientifico());
		textProyecto.setText(miAsignado.getProyecto());
		textNomApels.setText(miAsignado.getNomApels());
		textNombre.setText(miAsignado.getNombre());
		textHoras.setText(Integer.toString(miAsignado.getHoras()));
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCientifico.setText("");
		textProyecto.setText("");
		textNomApels.setText("");
		textNombre.setText("");
		textHoras.setText("");

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
	public void habilita(boolean cientifico, boolean proyecto, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCientifico.setEditable(cientifico);
		textProyecto.setEditable(proyecto);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
