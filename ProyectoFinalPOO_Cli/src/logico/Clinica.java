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
		this.misEnfermedades = new ArrayList<Enfermedad>();
		this.misVacunas = new ArrayList<Vacuna>();
		this.misConsultas = new ArrayList<Consulta>();
		this.misPersonas = new ArrayList<Persona>();
		this.misHistoriales = new ArrayList<Historial>();
		this.misCitas = new ArrayList<CitaMedica>();
		
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

}
