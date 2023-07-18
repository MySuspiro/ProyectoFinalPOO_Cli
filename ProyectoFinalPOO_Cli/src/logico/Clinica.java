package logico;

import java.util.ArrayList;

public class Clinica {

	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Historial> misHistoriales;
	private ArrayList<CitaMedica> misCitas;
	private static Clinica clinica=null;
	public static int histCod = 1000;
	public static int citCod = 1000;
	public static int conCod = 1000;
	public static int enfCod = 1000;
	public static int vacCod = 1000;
	public static int codigoPersona=1000;


	
	
	private Clinica() {
		super();
		misEnfermedades = new ArrayList<Enfermedad>();
		misVacunas = new ArrayList<Vacuna>();
		misConsultas = new ArrayList<Consulta>();
		misPersonas = new ArrayList<Persona>();
		misHistoriales = new ArrayList<Historial>();
		misCitas = new ArrayList<CitaMedica>();
		
	}
	
	public static Clinica getInstance() {
		
		if (clinica==null)
			clinica = new Clinica();
		return clinica;
		
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}

	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public ArrayList<Historial> getMisHistoriales() {
		return misHistoriales;
	}

	public void setMisHistoriales(ArrayList<Historial> misHistoriales) {
		this.misHistoriales = misHistoriales;
	}

	public ArrayList<CitaMedica> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<CitaMedica> misCitas) {
		this.misCitas = misCitas;
	}
	
	
	public void agregarPersona(Persona persona) {
        misPersonas.add(persona);
        codigoPersona++;
    }
	
	public void agregarVacuna(Vacuna vacuna) {
        misVacunas.add(vacuna);
    }
	
	public void agregarEnfermedad(Enfermedad enfermedad) {
        misEnfermedades.add(enfermedad);
    }
	public void agregarCita (CitaMedica cita) {
        misCitas.add(cita);
    }
	public void agregarConsulta(Consulta consulta) {
        misConsultas.add(consulta);
    }
	
	public void agregarHistorial(Historial historial) {
        misHistoriales.add(historial);
    }
	
	public Persona buscarPersonaByCodigo(String codigoPersona) {
		Persona aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getCodigo().equalsIgnoreCase(codigoPersona)){
				aux = misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Historial buscarHistorialByCedula(String cedula) {
		Historial aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misHistoriales.size()) {
			if(misHistoriales.get(i).getCodigo().equalsIgnoreCase(cedula)){
				aux = misHistoriales.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Persona buscarPersonaByCedula(String cedula) {
		Persona aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getCodigo().equalsIgnoreCase(cedula)){
				aux = misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public void eliminarPersona(logico.Persona selected) {
		misPersonas.remove(selected);
	}
	public void modificarPersona(Persona miPersona) {
		int index= buscarIndexPersonaByCode(miPersona);
		misPersonas.set(index,miPersona);	
		
	}
	
	private int buscarIndexPersonaByCode(Persona miPersona) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getCodigo().equalsIgnoreCase(miPersona.getCodigo())){
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Enfermedad buscarEnfermedadByCode(String Code) {
		Enfermedad aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misEnfermedades.size()) {
			if(misPersonas.get(i).getCodigo().equalsIgnoreCase(Code)){
				aux = misEnfermedades.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	

}
