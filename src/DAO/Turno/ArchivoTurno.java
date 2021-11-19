package DAO.Turno;

import Negocio.Turno;
import java.io.*;
import java.util.*;

public class ArchivoTurno {

private String path;

    public ArchivoTurno(String path){
        this.path = path;
    }

    public void guardarArchivoTU(ArrayList coleccion)
    {

        try {
        	
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(coleccion);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Turno> listarArchivoTU()
    {
        ArrayList lista = null;
        try {
        	
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object objeto = objectInputStream.readObject();
            if(objeto != null) {
                lista = (ArrayList) objeto;
            }else
                lista = new ArrayList();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            lista = new ArrayList();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
