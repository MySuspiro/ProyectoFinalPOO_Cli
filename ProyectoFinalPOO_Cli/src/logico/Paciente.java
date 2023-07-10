package logico;

import java.util.ArrayList;

public class Paciente extends Persona {
	
	private String Seguro;
	private Historial hist;
	private ArrayList<Consulta> misConsultas;

	public Paciente(String cedula, String nombre, String dir, String codigo, String telefono, String sexo) {
		super(cedula, nombre, dir, codigo, telefono, sexo);
		// TODO Auto-generated constructor stub
	}

}
