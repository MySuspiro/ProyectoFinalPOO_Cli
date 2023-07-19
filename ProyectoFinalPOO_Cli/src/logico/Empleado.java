package logico;

public class Empleado extends Persona {
	private String puestoLaboral;

	public Empleado(String cedula, String nombre, String dir, String codigo, String telefono, char sexo, String puestoLaboral) {
		super(cedula, nombre, dir, codigo, telefono, sexo);
		this.puestoLaboral=puestoLaboral;
	}

	public String getPuestoLaboral() {
		return puestoLaboral;
	}

	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}
	

}
