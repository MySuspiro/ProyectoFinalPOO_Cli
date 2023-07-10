package logico;

public class Enfermedad {

	private String Codigo;
	private String Nombre;
	private String tipo;
	private String descripcion;
	public Enfermedad(String codigo, String nombre, String tipo, String descripcion) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
