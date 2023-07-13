package logico;

import java.util.Date;

public class CitaMedica {

	private String codigo;
	private Date fecha;
	private String persona;
	private Doctor doctor;
	private String hora;
	public CitaMedica(String codigo, String persona, Doctor doctor, String hora, Date fecha) {
		super();
		this.codigo = "CM-" + Clinica.citCod;
		Clinica.citCod++;
		this.persona = persona;
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
	
	
	public String getPersona() {
		return persona;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public String getHora() {
		return hora;
	}
	
	


}
