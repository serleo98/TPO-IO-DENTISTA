package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonHome{
	private JButton home;
	private PanelManager panelManager;
	
	public void armarBotonHome(PanelManager panelManager, JPanel jp) {
		
		this.panelManager = panelManager;
		
		home = new JButton("INICIO");
        Dimension size1 = home.getPreferredSize();
        home.setBounds(50, 5, 80, size1.height);
		
        jp.add(home);
        
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelInicio();
			}
		});
	}
}
