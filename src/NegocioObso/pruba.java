package NegocioObso;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pruba {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hola mundo!!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Hola mundo");
		JButton button = new JButton("click aqui");

		frame.getContentPane().setLayout(new FlowLayout());

		frame.getContentPane().add(label);
		frame.getContentPane().add(button);
		frame.pack();
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola");
			}
			
			
		});
		
	}

}
