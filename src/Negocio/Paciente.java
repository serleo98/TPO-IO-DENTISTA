package Negocio;
import java.util.Date;
import java.util.*;
import java.io.Serializable;

public class Paciente extends Persona implements Serializable {

    //atributo
    private String DNI;
    private String domicilio;
    private String fechaAlta;
    private String usuario;
    private String password;
    private long id;

    //constructur
    public Paciente(String nombre, String apellido, String DNI, String domicilio, String fechaAlta, String usuario, String password){
        super(nombre,apellido);
        this.DNI = DNI;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.usuario = usuario;
        this.password = password;
        
        
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
