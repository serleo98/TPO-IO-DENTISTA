package DAO.Turno;

import Negocio.Turno;
import java.util.ArrayList;
import java.util.*;

public class TurnoService {

    private ITurnoDAO TurnoDAO;

    public TurnoService(){
        TurnoDAO = new TurnoDAO();
    }

    public void guardarTU(Turno turno){
        turno.setId(this.listarTU().size()+1);
        TurnoDAO.guardarTU(turno);
    }

    public Turno recuperarTU(long id){
        return TurnoDAO.recuperarTU(id);
    }

    public List<Turno> recuperarTUById(long id){
        return TurnoDAO.recuperarTUByClienteId(id);
    }

    public void modificar(Turno turno){

        List<Turno>listaTurno = this.listarTU();

        this.listarTU().forEach(t-> this.eliminarTU(t.getId()));
        listaTurno.set((int) turno.getId()-1,turno);
        listaTurno.forEach(this::guardarTU);

    }

    public void eliminarTU(long id){
        TurnoDAO.eliminarTU(id);
    }

    public ArrayList<Turno> listarTU(){
        return TurnoDAO.listarTU();
    }

}
