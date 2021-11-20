package UI;

//panel menu.   se arme  manager y que desde aca lo llamamos

import java.awt.Dimension;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class PanelInicio extends JPanel{
	
	private JLabel l_datos, l_datos_username, l_turnos,l_nombre,l_apellido,l_id,l_dni,l_domicilio,l_fechaalta;
	private PanelManager panelManager;
	private JButton b_turnos;
	private String id,nombre,apellido,dni,domicilio,fechaalta,usuario,password;
	private JComboBox turnos1;


	public void armarPanelInicio(PanelManager panelManager) {
		
		//sacar user de base de datos. Nombre de usuario. aunque pondria el nombre mas que usuari
		
		
			try{
				BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

	        	String linea = leer.readLine();
				//System.out.println(linea);
				
				String[] parts = linea.split(";");

				id = parts[0];
				nombre = parts[1];
				apellido = parts[2];
				dni = parts[3];
				domicilio = parts[4];
				fechaalta = parts[5];
				usuario = parts[6];
				password = parts[7];

				leer.close();
				parts = fechaalta.split(" ");
				fechaalta = parts[2]+"/"+parts[1]+"/"+parts[5];
				
				// Fri Nov 19 00:00:00 ART 2021
				
				

			}catch(Exception e){

			}
			l_datos = new JLabel("Datos Personales");

			l_datos_username = new JLabel("- Usuario: " + usuario);
			l_nombre = new JLabel("- Nombre: " +nombre);
			l_apellido = new JLabel("- Apellido: " + apellido);
			l_id = new JLabel("- ID paciente: " + id);
			l_dni = new JLabel("- DNI: " + dni);
			l_domicilio = new JLabel("- Domicilio: " +domicilio);
			l_fechaalta = new JLabel("- Fecha Alta: " + fechaalta);

			l_turnos = new JLabel("Tus Turnos");
			b_turnos = new JButton("Dr Porongo | 18/11/2021 16:30hs");

			Dimension size = l_datos.getPreferredSize();
			l_datos.setBounds(350, 30, size.width, size.height);

			l_datos_username.setBounds(125, 70, 190, size.height);
			l_nombre.setBounds(125, 90, 190, size.height);
			l_apellido.setBounds(125, 110, 190, size.height);
			l_id.setBounds(125, 130, 190, size.height);
			l_dni.setBounds(125, 150, 190, size.height);
			l_domicilio.setBounds(125, 170, 190, size.height);
			l_fechaalta.setBounds(125, 190, 290, size.height);

			l_turnos.setBounds(350, 220, size.width, size.height);

			// Ac� creen un String que reciba los turnos que tiene asignados el paciente
			// UNO POR UNO por c/vuelta, las vueltas del for, van a estar determinadas
			// seg�n la cantidad de turnos que tenga el paciente obvio, eso lo pueden sacar
			// con la base de datos tambi�n.
			// El string tiene que ir en el texto del JButton de abajo.

		// Acá creen un String que reciba los turnos que tiene asignados el paciente
		// UNO POR UNO por c/vuelta, las vueltas del for, van a estar determinadas
		// según la cantidad de turnos que tenga el paciente obvio, eso lo pueden sacar
		// con la base de datos también.
		// El string tiene que ir en el texto del JButton de abajo.

		turnos1 = new JComboBox();
		size = turnos1.getPreferredSize();
		turnos1.setBounds(250, 260, 300, size.height);

		new AgregarItems(turnos1, 4);
			setLayout(null);

			add(l_datos);
			add(l_datos_username);
			add(l_nombre);
			add(l_apellido);
			add(l_id);
			add(l_turnos);
			add(l_dni);
			add(l_domicilio);
			add(l_fechaalta);
			add(turnos1);
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		
		
		public void leectura() {
			try{
				BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

	        	String linea = leer.readLine();
				//System.out.println(linea);
				
				String[] parts = linea.split(";");

				id = parts[0];
				nombre = parts[1];
				apellido = parts[2];
				dni = parts[3];
				domicilio = parts[4];
				fechaalta = parts[5];
				usuario = parts[6];
				password = parts[7];

				leer.close();
				parts = fechaalta.split(" ");
				fechaalta = parts[2]+"/"+parts[1]+"/"+parts[5];
				
				// Fri Nov 19 00:00:00 ART 2021
				l_datos_username.setText("- Usuario: " + usuario);
				l_nombre.setText("- Nombre: " +nombre);
				l_apellido.setText("- Apellido: " + apellido);
				l_id.setText("- ID paciente: " + id);
				l_dni.setText("- DNI: " + dni);
				l_domicilio.setText("- Domicilio: " +domicilio);
				l_fechaalta.setText("- Fecha Alta: " + fechaalta);
				

			}catch(Exception e){
				System.out.println(e);
			}
		}


	}
	


		

