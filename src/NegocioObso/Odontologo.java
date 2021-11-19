package NegocioObso;

public class Odontologo extends Persona{
	private int Matricula;

	public Odontologo (String Nombre, String Apellido, int Matricula) {
		super(Nombre, Apellido);
		this.setMatricula(Matricula);
		
	}
	//agrego getter de matricula?
	
	public void ModificarMatricula(int Matricula) {
		this.setMatricula(Matricula);
	}

	public int getMatricula() {
		return Matricula;
	}

	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
}
