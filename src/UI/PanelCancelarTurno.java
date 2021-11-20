package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCancelarTurno extends JPanel{
	private JLabel info;
	private JComboBox turnos;
	private JButton seleccionar;
	private AgregarItems ai;
	private PanelManager panelManager;
	private JPanel jp;
	
	public void armarPanelCancelarTurnos(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		jp = this;
		
		info = new JLabel("Seleccione el turno que desee cancelar");
		Dimension size1 = info.getPreferredSize();
        info.setBounds(50, 50, 250, size1.height);
		
		turnos = new JComboBox();
		size1 = turnos.getPreferredSize();
        turnos.setBounds(50, 100, 100, size1.height);
        ai = new AgregarItems(turnos, 4);
        
		
		seleccionar = new JButton("CANCELAR");
		size1 = seleccionar.getPreferredSize();
        seleccionar.setBounds(200, 100, 150, size1.height);
		
		add(info);
		add(turnos);
		add(seleccionar);
        
		setLayout(null);
		
		
		seleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				int resultado3 = JOptionPane.showConfirmDialog(jp,
					"Esta seguro que quiere cancelar el turno del dia: x"+" a las x horas con el medico x", "Cancelar turno",
					JOptionPane.OK_CANCEL_OPTION);
						if(resultado3 == JOptionPane.OK_OPTION) {
							//eliminar turno de la base de datos
							JOptionPane.showMessageDialog(jp, "El turno fue cancelado",
							"", JOptionPane.INFORMATION_MESSAGE);
						}
				
			
			}
		});
	}
}
