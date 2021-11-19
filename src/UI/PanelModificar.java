package UI;

import javax.swing.*;

import DAO.Paciente.PacienteService;
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




public class PanelModificar extends JPanel {
	
	//componentes
	private JLabel nom, ape, dni, dom, usu, con;
	private JTextField nomT, apeT, dniT, domT, usuT;
	private JButton modificar;
	private JPasswordField conT;
	private JPanel jp;
	private Modificar m;
	private PanelManager panelManager;
	private String nombre, apellido, dni2, domicilio,usuario, password, id1, fechaalta;
	Paciente paciente;
	
	public void armarPanelModificar(PanelManager panelManager) {
		
		this.panelManager = panelManager;
		
		jp = this;
		
		JCheckBox jcb = new JCheckBox("Mostrar contaseña");
		
		try{
			BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));
        	String linea = leer.readLine();
			String[] partes = linea.split(";");
			id1 = partes[0];
			nombre = partes[1];
			apellido = partes[2];
			dni2 = partes[3];
			domicilio = partes[4];
			fechaalta = partes[5];
			usuario = partes[6];
			password = partes[7];
			
		}
		catch(Exception e){

		}
		
		nom = new JLabel("Nombre ");
		nomT = new JTextField(nombre, 25);
		
		
		ape = new JLabel("Apellido ");
		apeT = new JTextField(apellido, 25);
		
		
		
		// desde dni a fecha alta mostrarlo si es odontologo
		dni = new JLabel("DNI");
		dniT = new JTextField(dni2, 25);
		
		
		dom = new JLabel("Domicilio");
		domT = new JTextField(domicilio, 25);
		
		
		usu = new JLabel("Usuario");
		usuT = new JTextField(usuario, 25);
		
		
		con = new JLabel("Contraseña");
		conT = new JPasswordField(password, 25);
		
		modificar = new JButton("Modificar");
		
		
        
		Dimension size2 = nom.getPreferredSize();
	    nom.setBounds(200, 50, 65, size2.height);
	    Dimension size3 = nomT.getPreferredSize();
        nomT.setBounds(300, 50, size3.width, size3.height);
        
        
       
        size2 = ape.getPreferredSize();
	    ape.setBounds(200, 100, 65, size2.height);
	    size3 = apeT.getPreferredSize();
        apeT.setBounds(300, 100, size3.width, size3.height);
        
        
        
        Dimension size1 = dom.getPreferredSize();
        dom.setBounds(200, 150, 150, size1.height);
	    size2 = domT.getPreferredSize();
        domT.setBounds(300, 150, size2.width, size2.height);
        
        
        
        
        size2 = dni.getPreferredSize();
	    dni.setBounds(200, 201, 65, size2.height);
	    size3 = dniT.getPreferredSize();
        dniT.setBounds(300, 201, size3.width, size3.height);
         
        
        
        
        size2 = usu.getPreferredSize();
	    usu.setBounds(200, 250, 65, size2.height);
	    size3 = usuT.getPreferredSize();
        usuT.setBounds(300, 250, size3.width, size3.height);
        
        
        
        size2 = con.getPreferredSize();
	    con.setBounds(185, 302, 80, size2.height);
	    size3 = conT.getPreferredSize();
        conT.setBounds(300, 302, size3.width, size3.height);
         
        
        Dimension size4 = jcb.getPreferredSize();
        jcb.setBounds(300, 335, 150, size4.height);
        
        size4 = modificar.getPreferredSize();
        modificar.setBounds(350, 375, 100, size4.height);
        
	    
		add(nom);
		add(nomT);
		
		add(ape);
		add(apeT);
		
		add(dom);
		add(domT);
		
		add(dni);
		add(dniT);
				
		add(usu);
		add(usuT);
		
		add(con);
		add(conT);
		
		add(modificar);
		add(jcb);
		
		setLayout(null);
		
		
		
	    jcb.addActionListener(ae -> {
	    	JCheckBox c = (JCheckBox) ae.getSource();
	        conT.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
	      });
		
		modificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PacienteService ps = new PacienteService();
				
				long id = Long.parseLong(id1);
				
				
				ps.recuperarPA(id).setNombre(nomT.getText());
				
				ps.recuperarPA(id).setApellido(apeT.getText());
				
				ps.recuperarPA(id).setDNI(dniT.getText());
				
				ps.recuperarPA(id).setDomicilio(domT.getText());
				
				ps.recuperarPA(id).setFechaAlta(fechaalta);
				
				ps.recuperarPA(id).setUsuario(usuT.getText());
				
				ps.recuperarPA(id).setPassword(conT.getText());
				
				
				
				
				System.out.println(nomT.getText());
				System.out.println(ps.recuperarPA(id).getApellido());
				System.out.println(ps.recuperarPA(id).getDNI());
				System.out.println(ps.recuperarPA(id).getDomicilio());
				System.out.println(ps.recuperarPA(id).getFechaAlta());
				System.out.println(ps.recuperarPA(id).getUsuario());
				System.out.println(ps.recuperarPA(id).getPassword());
				
				
				
				panelManager.mostrarPanelInicio();
				
			}
		});
		
		
		
	}
	
	
}

enum PasswordField {
	   SHOW, HIDE;
	}