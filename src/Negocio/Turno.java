package Negocio;
import java.time.LocalDateTime;
import java.util.*;
import java.io.Serializable;


public class Turno implements Serializable {

    private long id;
    private long idClient;
    private String Dia;
    private String Hora;
    private Odontologo odontologo;
    //id paciente

    //id odontologo


    //contructur
    public Turno(long idClient, String Dia, String Hora, Odontologo odontologo){
        this.idClient = idClient;
        this.Dia = Dia;
        this.Hora = Hora;
        this.odontologo = odontologo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", Dia='" + Dia + '\'' +
                ", Hora='" + Hora + '\'' +
                ", odontologo=" + odontologo +
                '}';
    }
}
