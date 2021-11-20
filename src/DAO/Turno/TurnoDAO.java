package DAO.Turno;

import Negocio.Turno;

import java.io.*;
import java.util.*;

public class TurnoDAO implements ITurnoDAO {

    @Override
    public void guardarTU(Turno turno) {

        ArchivoTurno archivo = new ArchivoTurno("turnos.txt");
        ArrayList<Turno> lista = archivo.listarArchivoTU();

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

        return  archivo.listarArchivoTU();
    }
}
