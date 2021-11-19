package Negocio;

import java.io.Serializable;

public class Odontologo extends Persona implements Serializable {
	
	
    private String matricula;
    private long id;

    //constructor
    public  Odontologo (String nombre, String apellido, String matricula){
        super(nombre, apellido);
        this.matricula = matricula;
    }
   


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public long getIdO() {
        return id;
    }

    public void setIdO(long id) {
        this.id = id;
    }
}
