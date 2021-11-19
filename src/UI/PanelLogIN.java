package UI;

import javax.swing.*;

import DAO.Paciente.PacienteService;
import Negocio.Odontologo;
import Negocio.Paciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PanelLogIN extends JPanel {
    //private JPanel panel;
    private JLabel l_user, l_password;
    private JCheckBox jcb;
    private JTextField user;
    private JPasswordField password;
    private JButton login, register;
    private PanelManager panelManager;
    private Paciente paciente;

    public void armarPanelLogIN(PanelManager panelManager){
    	
        //frame = new JFrame("Login");
        //panel = new JPanel();
        jcb = new JCheckBox("Mostrar contaseña");
        
        this.panelManager = panelManager;

        //frame.getContentPane();

        l_user = new JLabel("Nombre de usuario");
        user = new JTextField(16);

        l_password = new JLabel("Contrasena");
        password = new JPasswordField(16);

        login = new JButton("Iniciar Sesion");
        register = new JButton("Registrarse");

        Dimension size = l_user.getPreferredSize();
        l_user.setBounds(175, 30, 125, size.height);

        size = user.getPreferredSize();
        user.setBounds(161, 53, size.width, size.height);

        size = l_password.getPreferredSize();
        l_password.setBounds(175, 82, 80, 13);

        size = password.getPreferredSize();
        password.setBounds(161, 105, size.width, size.height);
        
        size = jcb.getPreferredSize();
        jcb.setBounds(175, 132, 150, size.height);

        size = login.getPreferredSize();
        login.setBounds(175, 159, 120, size.height);

        size = register.getPreferredSize();
        register.setBounds(175, 190, 120, size.height);

        
        add(l_user);
        add(user);
        add(l_password);
        add(password);
        add(login);
        add(register);
        add(jcb);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(null);

        /*frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(501, 299);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);*/
        //panel.setLayout(null);
        
        
        
        
        jcb.addActionListener(ae -> {
	    	JCheckBox c = (JCheckBox) ae.getSource();
	        password.setEchoChar(c.isSelected() ? '\u0000' : (Character)          
          UIManager.get("PasswordField.echoChar"));
	      });
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ValidacionLogIn(password);
                
            }
        });
        
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPanelRegistroUsuario();
                
            }
        });
        
 }
    private void ValidacionLogIn(JTextField password){
    	//cambiar admin al de done busca de base de datos
    	PacienteService ps = new PacienteService();
    	ArrayList <Paciente> listaP = ps.listarPA();
    	int i = 1;
    	for(Paciente paciente : listaP) {
    		if (user.getText().equals(ps.recuperarPA(i).getUsuario()) && password.getText().equals(ps.recuperarPA(i).getPassword())) {
    			
    			
    	    	try {
    				
    				
    				BufferedWriter writer = new BufferedWriter(new FileWriter("Cache.txt"));

    				writer.write(

    						ps.recuperarPA(i).getId()         +";"+
    						ps.recuperarPA(i).getNombre()     +";"+
    						ps.recuperarPA(i).getApellido()   +";"+
    						ps.recuperarPA(i).getDNI()        +";"+
    						ps.recuperarPA(i).getDomicilio()  +";"+
    						ps.recuperarPA(i).getFechaAlta()  +";"+
    						ps.recuperarPA(i).getUsuario()    +";"+
    						ps.recuperarPA(i).getPassword()         
    	        
    						);
    	        
    	        writer.close();
    	        }
    			catch (IOException e){
    				System.out.println("No existia el archivo, entonces lo creamos.");
    	            
    				System.out.println("An error occurred.");
    			    e.printStackTrace();
    	           }
    			
    			panelManager.armarPI();
    			password.setText("");
        		panelManager.mostrarPanelInicio();
        		return;
    			
    		}
    		i++;
    	}
    		
        		        
    	JOptionPane.showMessageDialog(this,"Usuario o contrasena incorrecta!","Error de ingreso",JOptionPane.ERROR_MESSAGE);
    

    			//file.delete();
    }
    	
  }



    	  	
    	


