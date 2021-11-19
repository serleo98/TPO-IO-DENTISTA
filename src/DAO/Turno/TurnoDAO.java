package DAO.Turno;

import Negocio.Turno;
import java.io.*;
import java.util.*;

public class TurnoDAO implements ITurnoDAO {

    @Override
    public void guardarTU(Turno turno) {
    	
    	ArchivoTurno archivo = new ArchivoTurno("turnos.txt");
        ArrayList lista = archivo.listarArchivoTU();
        long max = 0;

        if (turno.getId() == 0) {
            for (Object objeto: lista) {
                if (((Turno) objeto).getId() > max)
                    max = ((Turno) objeto).getId();
            }
            turno.setId(max + 1);
            lista.add(turno);
        } else {
        	int index = 0;
            int i = 0;
            for (Object objeto : lista) {
                //Odontologo od = (Odontologo) objeto;
                if (((Turno) objeto).getId() == turno.getId()) {
                	index = i;
                    i++;
                }
                
            }
            lista.remove(index);
        }
        lista.remove(turno);
        lista.add(turno);
        archivo.guardarArchivoTU(lista);
       
    }

    @Override
    public Turno recuperarTU(long id) {
        ArrayList<Turno> turno = this.listarTU();
        Turno resultado = null;

        for (Turno tu : turno) {
            if (tu.getId() == id)
                resultado = tu;
        }

        return resultado;
    }

    @Override
    public void eliminarTU(long id) {
        ArchivoTurno archivo = new ArchivoTurno("turnos.txt");
        ArrayList lista = archivo.listarArchivoTU();

        int index = 0;
        int i = 0;
        for (Object objeto : lista) {
            if (((Turno) objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardarArchivoTU(lista);

    }


    @Override
    public ArrayList<Turno> listarTU() {
        ArchivoTurno archivo = new ArchivoTurno("turnos.txt");
        ArrayList lista = archivo.listarArchivoTU();
        ArrayList<Turno> turno = new ArrayList<>();

        for(Object obj: lista)
            turno.add((Turno) obj);

        return turno;
    }

}
