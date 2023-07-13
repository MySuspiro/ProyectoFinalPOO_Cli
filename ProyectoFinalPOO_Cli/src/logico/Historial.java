package logico;

import java.util.ArrayList;


public class Historial {

	private String codigo;
	private String cedPaciente;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Consulta> misConsultas;
	
	public Historial(String cedPaciente) {
		super();
		this.codigo = "H-" + Clinica.histCod;
		Clinica.histCod++;
		this.cedPaciente = cedPaciente;
		misVacunas = new ArrayList<Vacuna>();
		misConsultas = new ArrayList<Consulta>();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getcedPaciente() {
		return cedPaciente;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void addMisVacunas(Vacuna vac) {
		this.misVacunas.add(vac);
	}
	

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void addMisConsultas(Consulta con) {
		this.misConsultas.add(con);
	}
	
	
	
}
