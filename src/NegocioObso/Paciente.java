package NegocioObso;

import java.util.Scanner;

public class Paciente extends Persona{
	private int dni;
	private String Domicilio;
	private String FechaAlta;
	private String Usuario;
	private String Password;
	private Odontologo o;
	//agregar id
	
	
	public Paciente (String Nombre, String Apellido, int dni, String Domicilio, String FechaAlta, String Usuario, String Password) {
		super(Nombre, Apellido);
		this.dni = dni;
		this.Domicilio = Domicilio;
		this.FechaAlta = FechaAlta;
		this.Usuario = Usuario;
		this.Password = Password;
	}
	
}
