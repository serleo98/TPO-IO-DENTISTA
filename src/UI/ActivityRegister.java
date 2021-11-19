package UI;

import javax.swing.*;

import DAO.Paciente.PacienteService;
import Negocio.Paciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityRegister extends JPanel{
	
	private PanelManager panelManager;
	private JLabel nom, ape, dni, dom, fa, usu, con;
    private JTextField nomT, apeT, dniT, domT, faT, usuT, conT;
    private JButton registrar, atras;
    private JPanel jp;
    private Paciente paciente;
	
	public void armarActivityRegister(PanelManager panelManager) {
		this.panelManager = panelManager;
       
        jp = this;
        
        atras = new JButton("ATRAS");
        Dimension size1 = atras.getPreferredSize();
        atras.setBounds(50, 5, 80, size1.height);

        nom = new JLabel("Nombre ");
        nomT = new JTextField("", 25);

        ape = new JLabel("Apellido ");
        apeT = new JTextField("", 25);

        dni = new JLabel("DNI");
        dniT = new JTextField("", 25);

        dom = new JLabel("Domicilio");
        domT = new JTextField("", 25);

        usu = new JLabel("Usuario");
        usuT = new JTextField("", 25);

        con = new JLabel("Contraseña");
        conT = new JTextField("", 25);

        registrar = new JButton("Crear Cuenta");

        Dimension size2 = nom.getPreferredSize();
        nom.setBounds(200, 50, 65, size2.height);
        Dimension size3 = nomT.getPreferredSize();
        nomT.setBounds(300, 50, size3.width, size3.height);

        size2 = ape.getPreferredSize();
        ape.setBounds(200, 100, 65, size2.height);
        size3 = apeT.getPreferredSize();
        apeT.setBounds(300, 100, size3.width, size3.height);

        size2 = dom.getPreferredSize();
        dom.setBounds(200, 150, 65, size2.height);
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
        con.setBounds(185, 300, 80, size2.height);
        size3 = conT.getPreferredSize();
        conT.setBounds(300, 300, size3.width, size3.height);

        registrar.setBounds(350, 400, 190, 40);


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

        add(registrar);
        add(atras);
        
        setLayout(null);
        
        PacienteService ps = new PacienteService();
        
        atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelLogIN();;
			}
		});
        

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                PacienteService ps = new PacienteService();
                ArrayList <Paciente> listaP = ps.listarPA();
                int i = 1;
                for(Paciente paciente : listaP) {
            	    if (usuT.getText().equals(ps.recuperarPA(i).getUsuario())) {
                        JOptionPane.showMessageDialog(jp, "Error, el nombre de usuario seleccionado ya está en uso. Por favor intente con otro.",
        		"ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
            }
                }

            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    			sdf = new SimpleDateFormat("dd/MM/yyyy");
    			Date fecha = new Date();
    			int a = fecha.getDay();
    			int d1 = fecha.getDate();
    			int m = fecha.getMonth();
    			int y = fecha.getYear();
    			Date aux = new Date(y, m, d1);
    			sdf.format(aux);
    			String fechaalta = aux.toString();
    			
    			
    			
            	String nombre = nomT.getText();
            	String apellido = apeT.getText();
                String dni1 = dniT.getText();
                String domicilio = domT.getText();
                
                String usuario = usuT.getText();
                String password = conT.getText();
            	
            	paciente = new Paciente(nombre, apellido, dni1, domicilio, fechaalta, usuario, password);
            	ps.guardarPA(paciente);
            
            	JOptionPane.showMessageDialog(jp, "Cuenta creada exitosamente. Porfavor inicie sesion",
        		"EXITO", JOptionPane.INFORMATION_MESSAGE);

                panelManager.mostrarPanelLogIN();

            }
        });
        
	}
}
