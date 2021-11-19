package NegocioObso;

public class Persona {
	private String Nombre;
	private String Apellido;

	public Persona (String Nombre, String Apellido) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
}
