package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarTurnos extends JPanel {
	private JLabel info;
	private JComboBox turnos;
	private JButton seleccionar;
	public void armarPanelModTurnos(PanelManager panelManager) {
		
		info = new JLabel("Seleccione el turno a modificar");
		Dimension size1 = info.getPreferredSize();
        info.setBounds(50, 50, 200, size1.height);
		
		turnos = new JComboBox();
		size1 = turnos.getPreferredSize();
        turnos.setBounds(50, 100, 100, size1.height);
		new AgregarItems(turnos, 4);
		
		seleccionar = new JButton("SELECCIONAR");
		size1 = seleccionar.getPreferredSize();
        seleccionar.setBounds(200, 100, 150, size1.height);
		
		add(info);
		add(turnos);
		add(seleccionar);
        
		setLayout(null);
		
		seleccionar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent k) {

				String turnoString = (String) turnos.getSelectedItem();
				String[] strSplit = turnoString.split(" | ");
				String id = strSplit[0];

				panelManager.mostrarPanelTurnos();

			}
		});
	}

}
