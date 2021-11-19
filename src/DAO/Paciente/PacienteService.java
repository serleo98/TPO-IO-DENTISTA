package DAO.Paciente;

import DAO.Odontologo.OdontologoDAO;
import Negocio.Paciente;
import java.util.ArrayList;

public class PacienteService {

    private IPacienteDAO PacienteDAO;

    public PacienteService(){
        PacienteDAO = new PacienteDAO();
    }

    public void guardarPA(Paciente Paciente){

        PacienteDAO.guardarPA(Paciente);
    }

    public Paciente recuperarPA(long id){
        return PacienteDAO.recuperarPA(id);
    }

    public void eliminarPA(long id){
        PacienteDAO.eliminarPA(id);
    }

    public ArrayList<Paciente> listarPA() {
        return PacienteDAO.listarPA();
    }

}
