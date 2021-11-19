package DAO.Turno;

import Negocio.Turno;
import java.util.ArrayList;
import java.util.*;

public class TurnoService {

    private ITurnoDAO TurnoDAO;

    public TurnoService(){
        TurnoDAO = new TurnoDAO();
    }

    public void guardarTU(Turno Turno){
        TurnoDAO.guardarTU(Turno);
    }

    public Turno recuperarTU(long id){
        return TurnoDAO.recuperarTU(id);
    }

    public void eliminarTU(long id){
        TurnoDAO.eliminarTU(id);
    }

    public ArrayList<Turno> listarTU(){
        return TurnoDAO.listarTU();
    }

}
