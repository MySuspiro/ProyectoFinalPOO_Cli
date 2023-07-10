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
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	


}
