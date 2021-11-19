package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarTurnos extends JPanel {
	private JLabel info;
	private JComboBox turnos;
	private JButton seleccionar;
	private agregarItems ai;
	private PanelManager panelManager;
	private JPanel jp;
	
	public void armarPanelModTurnos(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		jp = this;
		
		info = new JLabel("Seleccione el turno a modificar");
		Dimension size1 = info.getPreferredSize();
        info.setBounds(50, 50, 200, size1.height);
		
		turnos = new JComboBox();
		size1 = turnos.getPreferredSize();
        turnos.setBounds(50, 100, 100, size1.height);
        ai = new agregarItems(turnos, 4);
        
		
		seleccionar = new JButton("SELECCIONAR");
		size1 = seleccionar.getPreferredSize();
        seleccionar.setBounds(200, 100, 150, size1.height);
		
		add(info);
		add(turnos);
		add(seleccionar);
        
		setLayout(null);
		
		seleccionar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent k) {
				
				panelManager.mostrarPanelTurnos();

			}
		});
	}

}
