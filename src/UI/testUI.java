package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import DAO.Odontologo.OdontologoService;
import Negocio.Odontologo;

public class testUI {

	public static void main(String[] args) {
		
		//PanelTurnos pt = new PanelTurnos();
		
		//PanelModificar pm = new PanelModificar();
		
		//PanelLogIN li = new PanelLogIN();
		
		//teste a = new teste();
		
		
		 
		
		 
		
		PanelManager panelManager = new PanelManager();
		panelManager.armarManager();
		panelManager.mostrarPanelLogIN();
	}

}
