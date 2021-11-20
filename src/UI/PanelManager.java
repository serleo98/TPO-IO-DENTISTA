package UI;

import javax.swing.*;

import DAO.Paciente.PacienteService;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PanelManager {

    private PanelInicio panelInicio;
    private PanelLogIN panelLogIN;
    private PanelTurnos panelTurnos;
    private BotonHome home;
    private PanelModificar panelModificar;
    private MenuInicio menu;
    private PanelModificarTurnos panelModTurnos;
    private PanelCancelarTurno panelCancelarTurno;
    private PanelRegistrarOdontologos panelRegisOdonto;
    private ActivityRegister panelRegistroUsuario;
    private int modificar;
    private JFrame jf;
    private String cache;

    public void armarManager() {
        jf = new JFrame();
        jf.setPreferredSize(new Dimension(500, 300));
        
        panelLogIN = new PanelLogIN();
        panelLogIN.armarPanelLogIN(this);
        
        home = new BotonHome();
        menu = new MenuInicio();
        menu.armarMenu(this);
        
        
        panelModificar = new PanelModificar();
        panelModificar.armarPanelModificar(this);
        
        panelTurnos = new PanelTurnos();
        panelTurnos.armarPanelTurnos(this);
        
        panelModTurnos = new PanelModificarTurnos();
        panelModTurnos.armarPanelModTurnos(this);
        
        panelCancelarTurno = new PanelCancelarTurno();
        panelCancelarTurno.armarPanelCancelarTurnos(this);
        
        panelRegisOdonto = new PanelRegistrarOdontologos();
        panelRegisOdonto.armarPanelRegisOdonto(this);
        
        panelRegistroUsuario = new ActivityRegister();
        panelRegistroUsuario.armarActivityRegister(this);
       
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.pack();
        jf.setLocationRelativeTo(null);
        
    }

    public void mostrarPanelLogIN() {
    	jf.setSize(500, 300);
    	menu.setVisible(false);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelLogIN);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelInicio() {
    	modificar = 0;
    	panelTurnos.mod(modificar);
    	menu.setVisible(true);
    	panelInicio.leectura();
    	jf.setJMenuBar(menu);
    	jf.setSize(850, 500);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelInicio);
        
        
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelModificar() {
    	menu.setVisible(false);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelModificar);
        home.armarBotonHome(this,panelModificar);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelTurnos() {
    	menu.setVisible(false);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelTurnos);
        home.armarBotonHome(this,panelTurnos);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelModTurnos() {
    	menu.setVisible(false);
    	modificar = 1;
    	panelTurnos.mod(modificar);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelModTurnos);
        home.armarBotonHome(this,panelModTurnos);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelCancelarTurno() {
    	menu.setVisible(false);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelCancelarTurno);
        home.armarBotonHome(this,panelCancelarTurno);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelRegistrarOdontologos() {
    	menu.setVisible(false);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelRegisOdonto);
        home.armarBotonHome(this, panelRegisOdonto);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void mostrarPanelRegistroUsuario() {
    	jf.setSize(850, 500);
    	jf.getContentPane().removeAll();
        jf.getContentPane().add(panelRegistroUsuario);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();
    }
    
    public void armarPI() {
    	panelInicio = new PanelInicio();
        panelInicio.armarPanelInicio(this);
    }
    

}



