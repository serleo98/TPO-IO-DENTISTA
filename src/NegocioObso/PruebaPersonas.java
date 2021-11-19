package NegocioObso;

import java.util.Scanner;

public class PruebaPersonas {

	public static void main(String[] args) {
		System.out.println("Creador de 1 persona");
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el nombre");
		String nombre = sc.next();
		System.out.println("Escriba el apellido");
		String apellido = sc.next();
		System.out.println("Escriba el DNI");
		int dni = sc.nextInt();
		System.out.println("Escriba el domicilio");
		String domicilio = sc.next();
		System.out.println("Escriba cuando se dio de alta en el siguiente formato dd/mm/aaaa");
		String fecha = sc.next();
		System.out.println("Escriba un usuario");
		String usuario = sc.next();
		System.out.println("Escriba una contraseña");
		String contraseña = sc.next();
		Paciente p = new Paciente(nombre, apellido, dni, domicilio, fecha, usuario, contraseña);
		System.out.println("\n" + p.getNombre() + "\n" + p.getApellido() + "\n" + p.getDni() + "\n" + p.getDomicilio() + "\n" + p.getFechaAlta() + "\n" + p.getUsuario() + "\n" + p.getPassword());
		
		System.out.println("Desea modificar datos escriba, 1 para si, 2 para borrar, 3 nada");
		int sino = sc.nextInt();
		if(sino == 1){
			while (sino == 1){
				System.out.println("Que datos quiere modificar");
				int info = sc.nextInt();
				p.ModificarDatos(info);
				System.out.println("\n" + p.getNombre() + "\n" + p.getApellido() + "\n" + p.getDni() + "\n" + p.getDomicilio() + "\n" + p.getFechaAlta() + "\n" + p.getUsuario() + "\n" + p.getPassword());
				System.out.println("Desea seguir modificando datos escriba, 1 para si, 2 para no");
				sino = sc.nextInt();
				
			}
		}
		
	}

}
