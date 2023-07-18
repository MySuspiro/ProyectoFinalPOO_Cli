package logico;

import java.util.Date;

public class CitaMedica {

	private String codigo;
	private Date fecha;
	private String cedPaciente;
	private String nomPaciente;
	private Doctor doctor;
	private String hora;
	public CitaMedica(String codigo, String cedPaciente, String nomPaciente, Doctor doctor, String hora, Date fecha) {
		super();
		this.codigo = "CM-" + Clinica.citCod;
		Clinica.citCod++;
		this.cedPaciente = cedPaciente;
		this.nomPaciente = nomPaciente;
		this.doctor = doctor;
		this.hora = hora;
		this.fecha =  fecha;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public String getHora() {
		return hora;
	}
	public String getCedPaciente() {
		return cedPaciente;
	}
	public String getNomPaciente() {
		return nomPaciente;
	}
	
	


}
