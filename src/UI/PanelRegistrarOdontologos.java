package UI;

import DAO.Odontologo.OdontologoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Negocio.*;
public class PanelRegistrarOdontologos extends JPanel {
	
	private JLabel nom, ape, matri;
	private JTextField nomT, apeT, matriT;
	private JButton registrar;
	private PanelManager panelManager;
	private JPanel jp;
	private Dimension size2, size3;
	private Odontologo odontologo;
	
	public void armarPanelRegisOdonto(PanelManager panelManager) {
		
		this.panelManager = panelManager;
		jp = this;
		
		nom = new JLabel("Nombre ");
		nomT = new JTextField(25);
		
		ape = new JLabel("Apellido ");
		apeT = new JTextField(25);
		
		matri = new JLabel("Matricula ");
		matriT = new JTextField(25);
		
		
		registrar = new JButton("REGISTRAR");
		
		size2 = nom.getPreferredSize();
	    nom.setBounds(200, 50, 65, size2.height);
	    size3 = nomT.getPreferredSize();
        nomT.setBounds(300, 50, size3.width, size3.height);
        
        size2 = ape.getPreferredSize();
	    ape.setBounds(200, 100, 65, size2.height);
	    size3 = apeT.getPreferredSize();
        apeT.setBounds(300, 100, size3.width, size3.height);
        
        size2 = matri.getPreferredSize();
	    matri.setBounds(200, 150, 65, size2.height);
	    size3 = matriT.getPreferredSize();
        matriT.setBounds(300, 150, size3.width, size3.height);
        
        
        size2 = registrar.getPreferredSize();
	    registrar.setBounds(350, 200, 180, size2.height);
	    
        
        add(nom);
        add(nomT);
        add(ape);
		add(apeT);
		add(matri);
		add(matriT);
		add(registrar);
        
        setLayout(null);
        
        OdontologoService os = new OdontologoService();
        
    
        registrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int resultado3= JOptionPane.showConfirmDialog(jp, "Esta seguro que quiere guardar el odontologo: "+ apeT.getText()+", "+
						nomT.getText() + ".  Matricula: "+ matriT.getText()+ ".  Recuerde que no se puede modificar despues", "Registrar Odontologo", JOptionPane.OK_CANCEL_OPTION);
						if(resultado3 == JOptionPane.OK_OPTION) {
							//aca es donde guardo los datos en base de datos
							
							odontologo = new Odontologo(nomT.getText(),  apeT.getText(), matriT.getText());
							os.guardarOD(odontologo);
							
							JOptionPane.showMessageDialog(jp, "Odontologo registrado exitosamente",
			        		"EXITO", JOptionPane.INFORMATION_MESSAGE);
			        		panelManager.mostrarPanelInicio();
						}
			}
		});
	}
}
