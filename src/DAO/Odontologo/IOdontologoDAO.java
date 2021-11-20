package DAO.Odontologo;

import Negocio.Odontologo;
import java.io.FileInputStream;
import java.util.*;

public interface IOdontologoDAO {

    public void guardarOD(Odontologo Odontologo);
    public Odontologo recuperarOD(long id);
    public Odontologo recuperarODByMatricula(String matricula);
    public void eliminarOD(long id);
    public ArrayList<Odontologo> listarOD();

}
