package logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Clinica implements Serializable{

	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Historial> misHistoriales;
	private ArrayList<CitaMedica> misCitas;
	//en prueba pa lo fichero
	private ArrayList<User> misUsers;
	private static User loginUser;
	//
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
		misUsers = new ArrayList<User>();
		
	}
	
	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
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
	
	//Probando fichero
	
	public static Clinica getClinica() {
		return clinica;
	}

	public static void setClinica(Clinica clinica) {
		Clinica.clinica = clinica;
	}
	
	public static void setLoginUser(User loginUser) {
		Clinica.loginUser = loginUser;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public void regUser(User user) {
		misUsers.add(user);
		
	}
	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (User user : misUsers) {
			if(user.getUserName().equals(text) && user.getPass().equals(text2)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	//
	
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
		int index = buscarIndexPersonaByCode(miPersona);
		if(misPersonas != null) {
			misPersonas.set(index,miPersona);	
		}
		
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
			if(misEnfermedades.get(i).getCodigo().equalsIgnoreCase(Code)){
				aux = misEnfermedades.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Enfermedad buscarEnfermedadByNom(String nom) {
		Enfermedad aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misEnfermedades.size()) {
			if(misEnfermedades.get(i).getNombre().equalsIgnoreCase(nom)){
				aux = misEnfermedades.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public CitaMedica buscarCitaByCode(String Code) {
		CitaMedica aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misCitas.size()) {
			if(misCitas.get(i).getCodigo().equalsIgnoreCase(Code)){
				aux = misCitas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public Persona buscarPersonaByNom(String nom) {
		Persona aux = null;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getNombre().equalsIgnoreCase(nom)){
				aux = misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	
	
	public void eliminarEnfermedad(logico.Enfermedad selected) {
		misEnfermedades.remove(selected);
	}
	public void eliminarCitas(CitaMedica cita) {
		misCitas.remove(cita);
	}
	public void modificarEnfermedad(Enfermedad miEnf) {
		int index= buscarIndexEnfermedadByCode(miEnf);
		misEnfermedades.set(index,miEnf);	
		
	}
	
	public void modificarCita(CitaMedica cit) {
		int index = buscarIndexCitaByCode(cit);
		misCitas.set(index,cit);
	}
	
	
	
	private int buscarIndexCitaByCode(CitaMedica cit) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misCitas.size()) {
			if(misCitas.get(i).getCodigo().equalsIgnoreCase(cit.getCodigo())){
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}

	
	private int buscarIndexEnfermedadByCode(Enfermedad miEnf) {
		int aux = -1;
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<misEnfermedades.size()) {
			if(misEnfermedades.get(i).getCodigo().equalsIgnoreCase(miEnf.getCodigo())){
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	
	public int cantMujeres() {
		
		int count=0;
		
		for (Persona persona: misPersonas)
		{
			if (persona.getSexo()=='F'&& persona instanceof Paciente)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public int cantHombres() {
		
		int count=0;
		
		for (Persona persona: misPersonas)
		{
			if (persona.getSexo()=='M' && persona instanceof Paciente)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public float enfermedadCantPacientes(Enfermedad enf) {
		
		int count=0;
		float porciento=0;
		int cantPacientes=0;
		
		for (Persona persona: misPersonas)
		{
			if (persona instanceof Paciente )
			{
				cantPacientes++;
				for (Consulta consulta: ((Paciente) persona).getHist().getMisConsultas())
				{
					if(consulta.getEnfermedad().getCodigo().equalsIgnoreCase(enf.getCodigo()))
					{
						count++;
					}
				}

			}
		}
		
		porciento=(count*100)/cantPacientes;
		
		return count;
	}
	
	public float vacunaCantPacientes(Vacuna vacuna) {
		
		int count=0;
		float porciento=0;
		int cantPacientes=0;
		
		for (Persona persona: misPersonas)
		{
			if (persona instanceof Paciente )
			{
				cantPacientes++;
				for (Vacuna vac: ((Paciente) persona).getHist().getMisVacunas())
				{
					if(vac.getCodigo().equalsIgnoreCase(vacuna.getCodigo()))
					{
						count++;
					}
				}

			}
		}
		
		porciento=(count*100)/cantPacientes;
		
		return porciento;
	}
	
}
	


