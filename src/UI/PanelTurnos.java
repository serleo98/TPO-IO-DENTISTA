package UI;

import javax.swing.*;

import DAO.Odontologo.OdontologoService;
import DAO.Turno.TurnoService;
import Negocio.Odontologo;
import Negocio.Turno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class PanelTurnos extends JPanel{
	
	private JLabel medicoL, fechaL, horaL;
	private JComboBox medicoJC, fechaJC, horaJC;
	private JButton reservar, modificar;;
	private JPanel jp;
	private Dimension size1, size2;
	private AgregarItems ai;
	private PanelManager panelManager;
	private int modificacion;
	private int resultado3;
	private TurnoService ts;
	private Turno turno;
	
	
	public void armarPanelTurnos(PanelManager panelManager){
		
		this.panelManager = panelManager;
		jp = this;
		 
		
		medicoL = new JLabel("Odontologo:");
		size1 = medicoL.getPreferredSize();
        medicoL.setBounds(50, 50, 76, size1.height);
        medicoJC = new JComboBox();
        size2 = medicoJC.getPreferredSize();
        medicoJC.setBounds(150, 50, 200, size2.height);
        ai = new AgregarItems(medicoJC, 1);
        
		
        
		fechaL = new JLabel("Fecha:");
		size1 = fechaL.getPreferredSize();
        fechaL.setBounds(83, 100, 41, size1.height);
        fechaJC = new JComboBox();
        size2 = fechaJC.getPreferredSize();
        fechaJC.setBounds(150, 100, 200, size2.height);
        ai = new AgregarItems(fechaJC, 2);
        fechaJC.setVisible(false);
        fechaL.setVisible(false);
        
        horaL = new JLabel("Hora:");
		size1 = horaL.getPreferredSize();
        horaL.setBounds(83, 150, 40, size1.height);
        horaJC = new JComboBox();
        size2 = horaJC.getPreferredSize();
        horaJC.setBounds(150, 150, 200, size2.height);
        ai = new AgregarItems(horaJC, 3);
        horaJC.setVisible(false);
        horaL.setVisible(false);
        
        reservar = new JButton("Reservar turno");
        size1 = reservar.getPreferredSize();
        reservar.setBounds(405, 100, 150, size1.height);
        reservar.setVisible(false);
        
        modificar = new JButton("Modificar turno");
        size1 = modificar.getPreferredSize();
        modificar.setBounds(405, 100, 150, size1.height);
        modificar.setVisible(false);
        
        
        add(medicoL);
        add(medicoJC);
        add(fechaL);
		add(fechaJC);
		add(horaL);
		add(horaJC);
		add(reservar);
		add(modificar);

		setLayout(null);
		
		
		medicoJC.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				fechaL.setVisible(true);
				fechaJC.setVisible(true);
			}
		});
		
		fechaJC.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent p) {
				horaL.setVisible(true);
				horaJC.setVisible(true);
			}
		});
		
		horaJC.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent l) {
				
				if(modificacion == 0) {
					reservar.setVisible(true);
				}
								
				if(modificacion == 1) {
					modificar.setVisible(true);
				}
			}
		});
		
		reservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				// usar esto para sacar los datos de los JC (JC.getSelectedItem())
				resultado3= JOptionPane.showConfirmDialog(jp, "Esta seguro que quiere reservar un turno el dia: " + 
				fechaJC.getSelectedItem() + " a las " + horaJC.getSelectedItem() + " con el odntologo " + medicoJC.getSelectedItem(), 
				"Confirmar turno", JOptionPane.OK_CANCEL_OPTION);
				if(resultado3 == JOptionPane.OK_OPTION) {
					
					
					ts = new TurnoService();
					try{
						BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

			        	String linea = leer.readLine();
						//System.out.println(linea);
						
						String[] parts = linea.split(";");
						TurnoService ts = new TurnoService();
						String id1 = parts[0];
						long Id = Long.parseLong(id1);
						//Odontologo odontologo = (Odontologo) medicoJC.getSelectedItem();
						String indetificador = (String) medicoJC.getSelectedItem();

						String[] indetificadores= indetificador.split("-");
						Odontologo odontologoSelected=new OdontologoService().recuperarODByMatricula(indetificadores[1]);

						String fecha1 = fechaJC.getSelectedItem().toString();
						String hora1 = horaJC.getSelectedItem().toString();
						turno = new Turno(Id, fecha1 , hora1 , odontologoSelected);
						ts.guardarTU(turno);
						
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
					fechaL.setVisible(false);
					fechaJC.setVisible(false);
					horaL.setVisible(false);
					horaJC.setVisible(false);
					reservar.setVisible(false);
					}
										
										
										
			}
		});
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent n) {
				// usar esto para sacar los datos de los JC (JC.getSelectedItem())
				
				resultado3 = JOptionPane.showConfirmDialog(jp, "Esta seguro que quiere modificar el turno el dia: " +
				" aca agregar fecha del turno a modificar \n"+ " por el turno dia: " + fechaJC.getSelectedItem() + " a las " 
				+ horaJC.getSelectedItem() + " con el odntologo " + medicoJC.getSelectedItem(), 
				"Confirmar turno", JOptionPane.OK_CANCEL_OPTION);
				if(resultado3 == JOptionPane.OK_OPTION) {
					//aca es donde guardo los datos en base de datos
					fechaL.setVisible(false);
					fechaJC.setVisible(false);
					horaL.setVisible(false);
					horaJC.setVisible(false);
					modificar.setVisible(false);
				}

			}
		});

	}
	
	public void mod(int bandera) {
		modificacion = bandera;
	}

}
