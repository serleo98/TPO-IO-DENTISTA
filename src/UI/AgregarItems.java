package UI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JComboBox;

import DAO.Odontologo.OdontologoService;
import DAO.Turno.TurnoService;
import Negocio.Odontologo;
import Negocio.Turno;

public class AgregarItems {
    public AgregarItems(JComboBox jc, int d) {
        //aca tengo que trabajar la base de datos
        OdontologoService os = new OdontologoService();
        switch (d) {

            case 1:

                ArrayList<Odontologo> listaO = os.listarOD();
                for (Odontologo odontologo : listaO) {
                    jc.addItem(odontologo.getApellido() + "-" + odontologo.getMatricula());
                }
                break;

            case 2:

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = new Date();
                int a = fecha.getDay();
                int d1 = fecha.getDate() - a + 1;
                int m = fecha.getMonth();
                int y = fecha.getYear();
                Date b = new Date(y, m, d1);


			for(int i = 0; i < 5; i++) {
				sdf = new SimpleDateFormat("dd/MM/yyyy");
				jc.addItem(sdf.format(b));
				d1 = b.getDate()+1;
				b = new Date(y, m, d1);

			}
			break;
		case 3:

			int hora=8;
			for(int i = 0; i < 13; i++) {
				jc.addItem((hora+1*i+":00hs").toString());
			}
			break;

		case 4:

			TurnoService ts = new TurnoService();
			//implementar base de datos turnos que hay reservados, para modificar y cnacelar
            long id = getIdCached();

			ts.recuperarTUById(id).forEach(t -> jc.addItem(t.getId()+" | "+t.getDia()+" | "+t.getHora()+" | "+ t.getOdontologo().getNombre()+" " +t.getOdontologo().getApellido()));

			break;
		}

	}

    private long getIdCached(){

        long id = 0;

        try{
            BufferedReader leer = new BufferedReader(new FileReader("Cache.txt"));

            String linea = leer.readLine();

            String[] parts = linea.split(";");

            String id1 = parts[0];

            id = Long.parseLong(id1);

        }catch(Exception e){
            System.out.println(e);
        }
        return id;
    }
}
