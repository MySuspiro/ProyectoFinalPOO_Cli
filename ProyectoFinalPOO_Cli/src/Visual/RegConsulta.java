package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Consulta;
import logico.Doctor;
import logico.Enfermedad;
import logico.Paciente;
import logico.Persona;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedPaciente;
	private JTextField txtTel;
	private JTextField txtNom;
	private JTextField txtSeguro;
	private JTextField txtCodigoPac;
	private JTextField txtCodigoCons;
	private JTextArea txtDir;
	private JRadioButton rdbHombre;
	private JRadioButton rdbMujer;
	private JComboBox<String> cmbDoc;
	private JComboBox<String> cmbEnf;
	private JTextArea txtDiag;
	private boolean encontrado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegConsulta dialog = new RegConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		setBounds(100, 100, 580, 701);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 538, 302);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(25, 28, 44, 16);
		panel.add(lblNewLabel);
		
		txtCedPaciente = new JTextField();
		txtCedPaciente.setBounds(94, 25, 295, 22);
		panel.add(txtCedPaciente);
		txtCedPaciente.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paciente pac = null;
				pac = (Paciente)Clinica.getInstance().buscarPersonaByCedula(txtCedPaciente.getText());
				if(pac != null) {
					encontrado = true;
				}
			}
		});
		btnNewButton.setBounds(414, 24, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(47, 132, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setBounds(47, 204, 78, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(291, 64, 78, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo");
		lblNewLabel_4.setBounds(47, 64, 56, 16);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(291, 204, 196, 85);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		rdbHombre = new JRadioButton("Hombre");
		rdbHombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbHombre.setSelected(true);
				rdbMujer.setSelected(false);
			}
		});
		rdbHombre.setBounds(38, 11, 73, 25);
		panel_1.add(rdbHombre);
		
		rdbMujer = new JRadioButton("Mujer");
		rdbMujer.setBounds(38, 47, 61, 25);
		panel_1.add(rdbMujer);
		
		JLabel lblNewLabel_5 = new JLabel("Seguro");
		lblNewLabel_5.setBounds(291, 132, 56, 16);
		panel.add(lblNewLabel_5);
		
		txtTel = new JTextField();
		txtTel.setBounds(291, 97, 196, 22);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(47, 165, 196, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtDir = new JTextArea();
		txtDir.setBounds(47, 224, 196, 65);
		panel.add(txtDir);
		
		txtSeguro = new JTextField();
		txtSeguro.setBounds(291, 165, 196, 22);
		panel.add(txtSeguro);
		txtSeguro.setColumns(10);
		
		txtCodigoPac = new JTextField();
		txtCodigoPac.setEditable(false);
		txtCodigoPac.setBounds(47, 97, 196, 22);
		panel.add(txtCodigoPac);
		txtCodigoPac.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 328, 538, 278);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo:");
		lblNewLabel_6.setBounds(50, 32, 56, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor:");
		lblNewLabel_7.setBounds(292, 69, 56, 16);
		panel_2.add(lblNewLabel_7);
		
		cmbDoc = new JComboBox<>();
		cmbDoc.setBounds(292, 98, 196, 22);
		panel_2.add(cmbDoc);
		cmbDoc.addItem("<Seleccione>");
		for (Persona aux : Clinica.getInstance().getMisPersonas()) {
			if(aux != null) {
				if(aux instanceof Doctor) {
					cmbDoc.addItem(aux.getNombre());
				}
			}
		}
		
		txtCodigoCons = new JTextField();
		txtCodigoCons.setEditable(false);
		txtCodigoCons.setColumns(10);
		txtCodigoCons.setBounds(118, 29, 370, 22);
		panel_2.add(txtCodigoCons);
		
		cmbEnf = new JComboBox<>();
		cmbEnf.setBounds(50, 98, 196, 22);
		panel_2.add(cmbEnf);
		cmbEnf.addItem("<Seleccione>");
		for (Enfermedad aux : Clinica.getInstance().getMisEnfermedades()) {
			if(aux != null) {
				cmbEnf.addItem(aux.getNombre());
			}	
		}
		
		
		JLabel lblNewLabel_8 = new JLabel("Enfermedades");
		lblNewLabel_8.setBounds(50, 69, 120, 16);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Diagnostico:");
		lblNewLabel_9.setBounds(50, 133, 120, 16);
		panel_2.add(lblNewLabel_9);
		
		txtDiag = new JTextArea();
		txtDiag.setBounds(50, 162, 438, 83);
		panel_2.add(txtDiag);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Doctor doc = null;
						Enfermedad enf = null;
						Paciente pac = null;
						doc = (Doctor)Clinica.getInstance().buscarPersonaByCedula(cmbDoc.getSelectedItem().toString());
						pac = (Paciente)Clinica.getInstance().buscarPersonaByCedula(txtCedPaciente.getText());
						enf = (Enfermedad)Clinica.getInstance().buscarEnfermedadByCode(cmbEnf.getSelectedItem().toString());
						if(!encontrado) {
							Clinica.getInstance().agregarPersona(pac);
						}
						if(doc != null && enf != null && pac != null) {
							Consulta cons = new Consulta(txtCodigoCons.getText(), txtDiag.getText(), enf, pac, doc);
							Clinica.getInstance().agregarConsulta(cons);
							JOptionPane.showMessageDialog(null, "Consulta Registrada Exitosamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);
							Clean();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void Clean() {
		txtCedPaciente.setText("");
		txtCodigoCons.setText("");
		txtCodigoPac.setText("");
		txtDiag.setText("");
		txtDir.setText("");
		txtNom.setText("");
		txtSeguro.setText("");
		txtTel.setText("");
		rdbHombre.setSelected(false);
		rdbMujer.setSelected(false);
		cmbDoc.setSelectedIndex(0);
		cmbEnf.setSelectedIndex(0);
		
	}
}
