package Negocio;
import java.util.*;
import java.io.Serializable;


public class Turno implements Serializable {

    private long id;
    private String Dia;
    private String Hora;
    private Odontologo odontologo;
    //id paciente

    //id odontologo


    //contructur
    public Turno(long id, String Dia, String Hora, Odontologo odontologo){
        this.id = id;
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




}
