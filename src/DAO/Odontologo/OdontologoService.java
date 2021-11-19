package DAO.Odontologo;

import Negocio.Odontologo;

import java.util.ArrayList;

public class OdontologoService {

    private IOdontologoDAO OdontologoDAO;

    public OdontologoService(){
        OdontologoDAO = new OdontologoDAO();
    }

    public void guardarOD(Odontologo Odontologo){
        //DAO.Odontologo.OdontologoDAO.guardar(Odontologo);
        OdontologoDAO.guardarOD(Odontologo);
    }

    public Odontologo recuperarOD(long id){
        return OdontologoDAO.recuperarOD(id);
    }

    public void eliminarOD(long id){
        OdontologoDAO.eliminarOD(id);
    }

    public ArrayList<Odontologo> listarOD() {
        return OdontologoDAO.listarOD();
    }

}

