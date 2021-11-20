package DAO.Turno;

import Negocio.Turno;
import java.io.FileInputStream;
import java.util.*;

public interface ITurnoDAO {

    public void guardarTU(Turno Turno);
    public Turno recuperarTU(long id);
    public List<Turno> recuperarTUByClienteId(long id);
    public void eliminarTU(long id);
    public ArrayList<Turno> listarTU();
}
