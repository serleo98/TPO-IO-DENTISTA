package UI;


import javax.swing.*;

import DAO.Paciente.PacienteService;
import DAO.Turno.TurnoService;
import Negocio.Odontologo;
import Negocio.Turno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class MenuInicio extends JMenuBar{
	private JMenu menu,submenu,submenu1;
    private JMenuItem agregar, mod_cuenta, cerrar_sesion, borrar_cuenta, modificar, eliminar, RegistrarO;
    private String user;
   
	private PanelManager panelManager;
	public void armarMenu(PanelManager panelManager) {
		
		this.panelManager = panelManager;
		
		JPanel jp = new JPanel();
		
		//user sacar el dato de nombre de usuario
		user = "admin";
		
    	menu=new JMenu("Menu");
    	submenu=new JMenu("Cuenta");
    	submenu1=new JMenu("Turnos");
    	

    	agregar=new JMenuItem("Agregar Turno");
    	modificar=new JMenuItem("Modificar Turno");
    	eliminar=new JMenuItem("Cancelar Turno");

    	mod_cuenta = new JMenuItem("Editar Cuenta");
    	cerrar_sesion = new JMenuItem("Cerrar Sesion");
    	borrar_cuenta = new JMenuItem("Borrar Cuenta");
    	
    	RegistrarO = new JMenuItem("Registrar Odontologos");

    	menu.add(submenu);
    	menu.add(submenu1);
    	
    	try{
			BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

        	String linea = leer.readLine();
			//System.out.println(linea);
			
			String[] parts = linea.split(";");

			user = parts[6];

			leer.close();

		}catch(Exception e){

		}
    	
    	if(user == "admin") {
    		menu.add(RegistrarO);
    	}
    	
    	submenu.add(mod_cuenta);
    	submenu.add(borrar_cuenta);
    	submenu.add(cerrar_sesion);
    	

    	submenu1.add(agregar);
    	submenu1.add(modificar);
    	submenu1.add(eliminar);

    	add(menu);
    	

    	cerrar_sesion.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		try {
    			File myObj = new File("Cache.txt"); 
    			myObj.delete();
    		    /*if (myObj.delete()) { 
    		      System.out.println("Deleted the file: " + myObj.getName());
    		    } else {
    		      System.out.println("Failed to delete the file.");
    		    }*/
    			
    			//File cache = new File("");
    			
    			
        		//cache.delete();
        		panelManager.mostrarPanelLogIN();
    		}
    		catch(Exception e2)
    		{
    		e2.printStackTrace();
    		}
    		
    		}
    	});
    	
    	agregar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		panelManager.mostrarPanelTurnos();
        		
        	}
        });
    	
    	mod_cuenta.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		panelManager.mostrarPanelModificar();
        		
        	}
        });
    	modificar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		panelManager.mostrarPanelModTurnos();
        		
        	}
        });
    	
    	eliminar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		panelManager.mostrarPanelCancelarTurno();
        		
        	}
        });
    	
    	borrar_cuenta.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		int resultado3 = JOptionPane.showConfirmDialog(jp,
        			"Esta seguro de eliminar PERMANENTEMENTE su cuenta.", "Borrar cuenta",
        			JOptionPane.OK_CANCEL_OPTION);
        			if(resultado3 == JOptionPane.OK_OPTION) {
        				//eliminar toda la cuenta
        				JOptionPane.showMessageDialog(jp, "Su cuenta a sido permanentemente eliminada. Esperamos verlo de nuevo",
        				"EXITO", JOptionPane.INFORMATION_MESSAGE);
        				PacienteService ps = new PacienteService();
    					try{
    						BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

    			        	String linea = leer.readLine();
    						
    						
    						String[] parts = linea.split(";");
    						String id1 = parts[0];
    						long Id = Long.parseLong(id1);
    						ps.eliminarPA(Id);
    						
    					}
    					catch(Exception e1){

    					}
        				panelManager.mostrarPanelLogIN();
        			}
        	}
        });
    	
    	RegistrarO.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		panelManager.mostrarPanelRegistrarOdontologos();;
        		
        	}
        });
	}
}
