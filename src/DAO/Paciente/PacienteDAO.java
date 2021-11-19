package DAO.Paciente;
import Negocio.Paciente;

import java.io.FileInputStream;
import java.util.*;
import java.util.ArrayList;

public class PacienteDAO implements IPacienteDAO {

    @Override
    public void guardarPA(Paciente paciente) {

        ArchivoPaciente archivo = new ArchivoPaciente("pacientes.txt");
        ArrayList lista = archivo.listarArchivoPA();
        long max = 0;

        if (paciente.getId() == 0) {
            for (Object objeto: lista) {
                if (((Paciente) objeto).getId() > max)
                    max = ((Paciente) objeto).getId();
            }
            paciente.setId(max + 1);
            lista.add(paciente);
        } else {
            int index = 0;
            int i = 0;
            for (Object objeto : lista) {
                Paciente pa = (Paciente) objeto;
                if (pa.getId() == paciente.getId()) {
                    lista.remove(pa);
                    lista.add(paciente);
                }
            }
            lista.remove(index);
        }
        lista.remove(paciente);
        lista.add(paciente);
        archivo.guardarArchivoPA(lista);
    }

    @Override
    public Paciente recuperarPA(long id) {
        ArrayList<Paciente> paciente = this.listarPA();
        Paciente resultado = null;

        for (Paciente pa : paciente) {
            if (pa.getId() == id)
                resultado = pa;
        }

        return resultado;
    }

    @Override
    public void eliminarPA(long id) {
        ArchivoPaciente archivo = new ArchivoPaciente("pacientes.txt");
        ArrayList lista = archivo.listarArchivoPA();

        int index = 0;
        int i = 0;
        for (Object objeto : lista) {
            if (((Paciente) objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardarArchivoPA(lista);

    }


    @Override
    public ArrayList<Paciente> listarPA() {
        ArchivoPaciente archivo = new ArchivoPaciente("pacientes.txt");
        ArrayList lista = archivo.listarArchivoPA();
        ArrayList<Paciente> paciente = new ArrayList<>();

        for(Object obj: lista)
            paciente.add((Paciente) obj);

        return paciente;
    }

}
