package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Consulta;
import logico.Doctor;
import logico.Enfermedad;
import logico.Historial;
import logico.Paciente;
import logico.Vacuna;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;

public class PacienteHistorial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JList<String> listHist;
	private JButton btnBuscar;
	private Historial historial = null;
	private Paciente paciente = null;
	private JTextField txtCodigo;
	private JTextField txtPaciente;
	private JList<String> listVac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PacienteHistorial dialog = new PacienteHistorial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PacienteHistorial() {
		setTitle("Historial de un Paciente");
		setBounds(100, 100, 767, 598);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("Cédula:");
			lblNewLabel.setBounds(61, 17, 56, 16);
			panel.add(lblNewLabel);

			txtCedula = new JTextField();
			txtCedula.setBounds(160, 14, 358, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			DefaultListModel<String> model = new DefaultListModel<>();
			listHist = new JList<>(model);
			listHist.setBounds(49, 101, 628, 191);
			panel.add(listHist);

			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//prueba de que funciona
					paciente = new Paciente("1", "Juan", "Gurabo", "p1", "908", 'M', "Nada");
					historial=new Historial("1");
					
					
					//historial = Clinica.getInstance().buscarHistorialByCedula(txtCedula.getText());
					DefaultListModel<String> model = new DefaultListModel<>();
					DefaultListModel<String> model1 = new DefaultListModel<>();
					if (historial != null) {
						//JOptionPane.showMessageDialog(null, "Encontré");
						txtCodigo.setText(historial.getCodigo());
						//Paciente paciente=(Paciente) Clinica.getInstance().buscarPersonaByCedula(txtCedula.getText());
						//txtPaciente.setText(paciente.getNombre);
						txtPaciente.setText("Juan Perez");

						//probando
						ArrayList<Consulta> misConsultas = obtenerMisConsultas();
						//ArrayList<Consulta> misConsultas = historial.getMisConsultas();
						ArrayList<Vacuna> misVacunas = historial.getMisVacunas();
						for (Consulta consulta : misConsultas) {
							String item = "Fecha: " + consulta.getFechaConsulta() + " - Diagnóstico: "
									+ consulta.getDiagnostico() + " - Enfermedad: "
									+ consulta.getEnfermedad().getNombre();
							model.addElement(item);
						}

						listHist.setModel(model);
						
						for (Vacuna vacuna : misVacunas) {
							String item1 = "Nombre: " + vacuna.getNombre() + " - Descripción: "
									+ vacuna.getDescripcion() + " - Enfermedad: "
									+ vacuna.getEnf().getNombre();
							model1.addElement(item1);
						}

						listVac.setModel(model1);
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró el historial");
					}
				}
			});
			btnBuscar.setBounds(541, 13, 97, 25);
			panel.add(btnBuscar);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre Paciente:");
			lblNewLabel_1.setBounds(249, 60, 122, 16);
			panel.add(lblNewLabel_1);
			
			JLabel lblCdigoHistorial = new JLabel("C\u00F3digo Historial:");
			lblCdigoHistorial.setBounds(61, 60, 97, 16);
			panel.add(lblCdigoHistorial);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(160, 57, 77, 22);
			panel.add(txtCodigo);
			
			txtPaciente = new JTextField();
			txtPaciente.setEditable(false);
			txtPaciente.setColumns(10);
			txtPaciente.setBounds(356, 57, 281, 22);
			panel.add(txtPaciente);
			
			JLabel lblVacunas = new JLabel("Vacunas:");
			lblVacunas.setBounds(61, 316, 97, 16);
			panel.add(lblVacunas);
			
			//listVac = new JList<String>((ListModel) null);
			DefaultListModel<String> model1 = new DefaultListModel<>();
			listVac = new JList<>(model1);
			listVac.setBounds(49, 356, 628, 114);
			panel.add(listVac);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	//probando

	private ArrayList<Consulta> obtenerMisConsultas() {
		ArrayList<Consulta> misConsultas = new ArrayList<>();

		Consulta consulta1 = new Consulta("C001", "Enfermedad Terminal",
				new Enfermedad("C1", "Cancer", "Contagiosa", "Fiebre Gripe"), paciente,
				new Doctor("cedula1", "Juan", "Gurabo", "p1", "908", 'M', "Cardiologo"));
		Consulta consulta2 = new Consulta("C002", "Edema Pulmonar",
				new Enfermedad("C1", "Covid", "Contagiosa", "Fiebre Gripe"), paciente,
				new Doctor("cedula1", "Juan", "Gurabo", "p1", "908", 'M', "Cardiologo"));

		misConsultas.add(consulta1);
		misConsultas.add(consulta2);

		return misConsultas;
	}
}

