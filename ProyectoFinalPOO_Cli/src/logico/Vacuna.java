package logico;

public class Vacuna {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private int cant;
	private Enfermedad enf;
	public Vacuna(String codigo, String nombre, String descripcion, int cant, Enfermedad enf) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cant = cant;
		this.enf = enf;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public Enfermedad getEnf() {
		return enf;
	}
	public void setEnf(Enfermedad enf) {
		this.enf = enf;
	}

}
