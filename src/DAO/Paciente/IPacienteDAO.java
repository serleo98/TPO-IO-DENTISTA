package DAO.Paciente;

import Negocio.Paciente;
import java.io.FileInputStream;
import java.util.*;

public interface IPacienteDAO {

    public void guardarPA(Paciente Paciente);
    public Paciente recuperarPA(long id);
    public void eliminarPA(long id);
    public ArrayList<Paciente>listarPA();
}
