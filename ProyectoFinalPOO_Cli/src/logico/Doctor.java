package logico;

public class Doctor extends Persona {
	private String especialidad;

	public Doctor(String cedula, String nombre, String dir, String codigo, String telefono, String sexo, String especialidad) {
		super(cedula, nombre, dir, codigo, telefono, sexo);
		this.especialidad = especialidad;
		
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
