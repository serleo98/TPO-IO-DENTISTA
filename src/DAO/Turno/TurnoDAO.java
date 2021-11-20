package DAO.Turno;

import Negocio.Turno;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

        for (Turno tu : turno) {
            if (tu.getId() == id)
                return tu;
        }
        return null;
    }

    @Override
    public void eliminarTU(long id) {
        ArchivoTurno archivo = new ArchivoTurno("turnos.txt");
        ArrayList<Turno> lista = archivo.listarArchivoTU();

        int index = 0;
        int i = 0;
        for (Turno turno : lista) {
            if ( turno.getId() == id)
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

    @Override
    public List<Turno> recuperarTUByClienteId(long id){

        ArrayList<Turno> turno = this.listarTU();

       return turno.stream()
               .filter(t-> t.getIdClient() == id)
               .collect(Collectors.toList());
    }
}
