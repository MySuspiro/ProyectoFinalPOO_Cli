package logico;

import java.util.Date;

public class Consulta {
	
	private String codigoConsulta;
	private Date fechaConsulta;
	private String diagnostico;
    private  Enfermedad enfermedad;
    private Paciente paciente;
    private Doctor doctor;
	public Consulta(String codigoConsulta, String diagnostico, Enfermedad enfermedad,
			Paciente paciente, Doctor doctor) {
		super();
		this.codigoConsulta = codigoConsulta;
		this.fechaConsulta = new Date();
		this.diagnostico = diagnostico;
		this.enfermedad = enfermedad;
		this.paciente = paciente;
		this.doctor = doctor;
	}
	public String getCodigoConsulta() {
		return codigoConsulta;
	}
	public void setCodigoConsulta(String codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

    
    
    
    
}
