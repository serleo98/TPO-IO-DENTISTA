package DAO.Odontologo;
import Negocio.Odontologo;

import java.io.FileInputStream;
import java.util.Random;
import java.util.*;
import java.util.ArrayList;

public class OdontologoDAO implements IOdontologoDAO {

    @Override
    public void guardarOD(Odontologo odontologo) {
    
    	ArchivoOdontologo archivo = new ArchivoOdontologo("odontologos.txt");
        ArrayList lista = archivo.listarArchivoOD();
        long max = 0;

        if (odontologo.getIdO() == 0) {
            for (Object objeto: lista) {
                if (((Odontologo) objeto).getIdO() > max)
                    max = ((Odontologo) objeto).getIdO();
            }
            odontologo.setIdO(max + 1);
            lista.add(odontologo);
        } else {
        	int index = 0;
            int i = 0;
            for (Object objeto : lista) {
                //Odontologo od = (Odontologo) objeto;
                if (((Odontologo) objeto).getIdO() == odontologo.getIdO()) {
                	index = i;
                    i++;
                }
                
            }
            lista.remove(index);
        }
        lista.remove(odontologo);
        lista.add(odontologo);
        archivo.guardarArchivoOD(lista);
        
    }

    @Override
    public Odontologo recuperarOD(long id) {
        ArrayList<Odontologo> odontologo = this.listarOD();
        Odontologo resultado = null;

        for (Odontologo od : odontologo) {
            if (od.getIdO() == id)
                resultado = od;
        }

        return resultado;
    }

    @Override
    public void eliminarOD(long id) {
        ArchivoOdontologo archivo = new ArchivoOdontologo("odontologos.txt");
        ArrayList lista = archivo.listarArchivoOD();

        int index = 0;
        int i = 0;
        for (Object objeto : lista) {
            if (((Odontologo) objeto).getIdO() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardarArchivoOD(lista);

    }


    @Override
    public ArrayList<Odontologo> listarOD() {
        ArchivoOdontologo archivo = new ArchivoOdontologo("odontologos.txt");
        ArrayList lista = archivo.listarArchivoOD();
        ArrayList<Odontologo> odontologo = new ArrayList<>();

        for(Object obj: lista)
            odontologo.add((Odontologo) obj);

        return odontologo;
    }

    @Override
    public Odontologo recuperarODByMatricula(String matricula) {
        ArrayList<Odontologo> odontologo = this.listarOD();

        for (Odontologo od : odontologo) {
            if (od.getMatricula().equals(matricula))
                return  od;
        }
        return null;
    }
}

