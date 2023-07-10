package logico;

import java.util.ArrayList;

public class Paciente extends Persona {
	
	private String Seguro;
	private Historial hist;
	private ArrayList<Consulta> misConsultas;

	public Paciente(String cedula, String nombre, String dir, String codigo, String telefono, String sexo,
			String seguro, ArrayList<Consulta> misConsultas) {
		super(cedula, nombre, dir, codigo, telefono, sexo);
		Seguro = seguro;
		hist = new Historial("H-"+Clinica.histCod, cedula);
		Clinica.histCod ++;
		this.misConsultas = misConsultas;
	}

}
