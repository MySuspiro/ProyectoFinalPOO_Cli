package logico;

import java.util.Date;

public class Consulta {
	
	private String codigo;
	private Date fechaConsulta;
	private String diagnostico;
    private  Enfermedad enfermedad;
    private Paciente paciente;
    private Doctor doctor;
	public Consulta(String diagnostico, Enfermedad enfermedad,
			Paciente paciente, Doctor doctor) {
		super();
		this.codigo = "CO-"+Clinica.conCod;
		Clinica.conCod++;
		this.fechaConsulta =  new Date();
		this.diagnostico = diagnostico;
		this.enfermedad = enfermedad;
		this.paciente = paciente;
		this.doctor = doctor;
	}
	public String getCodigoConsulta() {
		return codigo;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
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

	public Doctor getDoctor() {
		return doctor;
	}


    
    
    
    
}
