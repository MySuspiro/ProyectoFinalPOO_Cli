package logico;

import java.util.ArrayList;


public class Historial {

	private String codigo;
	private String paciente;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Consulta> misConsultas;
	
	public Historial(String paciente) {
		super();
		this.codigo = "H-" + Clinica.histCod;
		Clinica.histCod++;
		this.paciente = paciente;
		this.misEnfermedades = new ArrayList<Enfermedad>();
		this.misVacunas = new ArrayList<Vacuna>();
		this.misConsultas = new ArrayList<Consulta>();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getPaciente() {
		return paciente;
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}
	
	public void addMisEnfermedades(Enfermedad enf) {
		this.misEnfermedades.add(enf);
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
