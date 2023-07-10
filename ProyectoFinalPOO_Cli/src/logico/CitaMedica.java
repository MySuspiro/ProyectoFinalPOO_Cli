package logico;

import java.util.Date;

public class CitaMedica {

	private String codigo;
	private Date fecha;
	private Persona persona;
	private Doctor doctor;
	private String hora;
	public CitaMedica(String codigo, Persona persona, Doctor doctor, String hora) {
		super();
		this.codigo = codigo;
		this.persona = persona;
		this.doctor = doctor;
		this.hora = hora;
		this.fecha =  new Date();
	}
	public String getCodigo() {
		return codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public String getHora() {
		return hora;
	}
	
	


}
