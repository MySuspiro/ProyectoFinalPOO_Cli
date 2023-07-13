package logico;

import java.util.ArrayList;

public class Paciente extends Persona {
	
	private String Seguro;
	private Historial hist;

	public Paciente(String cedula, String nombre, String dir, String codigo, String telefono, char sexo,
			String seguro) {
		super(cedula, nombre, dir, codigo, telefono, sexo);
		Seguro = seguro;
		hist = new Historial(cedula);

	}

	public String getSeguro() {
		return Seguro;
	}

	public void setSeguro(String seguro) {
		Seguro = seguro;
	}

	public Historial getHist() {
		return hist;
	}

	public void setHist(Historial hist) {
		this.hist = hist;
	}
	
	

}
