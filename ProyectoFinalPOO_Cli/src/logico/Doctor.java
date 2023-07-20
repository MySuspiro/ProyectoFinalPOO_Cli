package logico;

import java.io.Serializable;

public class Doctor extends Persona implements Serializable {
	private String especialidad;

	public Doctor(String cedula, String nombre, String dir, String codigo, String telefono, char sexo, String correoElectronico, String especialidad) {
		super(cedula, nombre, dir, codigo, telefono, sexo,correoElectronico);
		this.especialidad = especialidad;
		
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
