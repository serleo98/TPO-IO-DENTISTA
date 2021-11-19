package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Modificar {
	private JButton aceptar = new JButton("Aceptar");
	private JButton cancelar = new JButton("Cancelar");
	private String base_datos;
	public Modificar(JTextField Texto, JButton boton, JPanel jp) {
		int posx = boton.getBounds().x;
		int posy = boton.getBounds().y;
		Dimension size1 = aceptar.getPreferredSize();
		aceptar.setBounds(posx, posy, 81, size1.height);
	    int mod = posx+85;
	    Dimension size2 = cancelar.getPreferredSize();
	    cancelar.setBounds(mod, posy, 88, size2.height);
		Texto.setText("");
		Texto.setEditable(true); 
		boton.setVisible(false);
		jp.add(aceptar);
		jp.add(cancelar);
		
		jp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		base_datos = "Conseguir el dato en base de datos";
		
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent i) {
				aceptar.setVisible(false);
				cancelar.setVisible(false);
				boton.setVisible(true);
				Texto.setEditable(false);
				Texto.setText(base_datos);
			}
		});
		aceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent i) {
				String texto = Texto.getText();
				//enviar esto a base de datos
				aceptar.setVisible(false);
				cancelar.setVisible(false);
				boton.setVisible(true);
				Texto.setEditable(false);
				base_datos = texto;
				Texto.setText(base_datos);
			}
		});
	}
	
}
