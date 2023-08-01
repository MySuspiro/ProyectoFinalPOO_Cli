package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

import logico.Clinica;
import logico.Consulta;
import logico.Doctor;
import logico.Enfermedad;
import logico.Historial;
import logico.Paciente;
import logico.Persona;
import logico.Vacuna;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class RegConsulta2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedPaciente;
	private JTextField txtTel;
	private JTextField txtNom;
	private JTextField txtSeguro;
	private JTextField txtEmail;
	private JTextField txtCodigoCons;
	private JTextArea txtDir;
	private JRadioButton rdbHombre;
	private JRadioButton rdbMujer;
	private JComboBox<String> cmbDoc;
	private JComboBox<String> cmbEnf;
	private JTextArea txtDiag;
	private boolean encontrado = false;
	Paciente pac = null;
	private JRadioButton rdbVacuna;
	private JPanel panelVac;
	private JComboBox<String> cmbVac;
	private JRadioButton rdbEnf;
	private JRadioButton rdbSano;
	private JPanel PanEnf;
	private JButton btnHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegConsulta2 dialog = new RegConsulta2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta2() {
		setBounds(100, 100, 580, 701);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("editar.png"));
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
		txtCedPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
	            	e.consume();
	            }
			}
		});
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pac = null;
				try {
					pac = (Paciente)Clinica.getInstance().buscarPersonaByCedula(txtCedPaciente.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(pac != null) {
					encontrado = true;
					JOptionPane.showMessageDialog(null, "Paciente encontrado", "Pacientes", JOptionPane.INFORMATION_MESSAGE);
					loadPaciente(pac);
					btnHistorial.setEnabled(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Paciente no encontrado", "Pacientes", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(414, 24, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(47, 64, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setBounds(47, 204, 78, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(291, 64, 78, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(47, 132, 56, 16);
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
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
			    if (!Character.isDigit(c) && c != '-' && c != '(' && c != ')') {
	            	e.consume();
	            }
			}
		});
		txtTel.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(47, 97, 196, 22);
		panel.add(txtNom);
		txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
	            if (!Character.isLetter(c)&& c != ' ') {
	            	e.consume();
	            }
			}
		});
		txtNom.setColumns(10);
		
		txtDir = new JTextArea();
		txtDir.setBounds(47, 224, 196, 65);
		panel.add(txtDir);
		
		txtSeguro = new JTextField();
		txtSeguro.setBounds(291, 165, 196, 22);
		panel.add(txtSeguro);
		txtSeguro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
	            	e.consume();
	            }
			}
		});
		txtSeguro.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(47, 165, 196, 22);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 328, 538, 278);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		PanEnf = new JPanel();
		PanEnf.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enfermo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		PanEnf.setBounds(36, 89, 226, 74);
		panel_2.add(PanEnf);
		PanEnf.setLayout(null);
		PanEnf.setVisible(false);
		
		cmbEnf = new JComboBox<>();
		cmbEnf.setBounds(14, 27, 196, 22);
		PanEnf.add(cmbEnf);
		cmbEnf.addItem("<Seleccione>");
		
		JLabel lblNewLabel_6 = new JLabel("Codigo:");
		lblNewLabel_6.setBounds(50, 17, 56, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor:");
		lblNewLabel_7.setBounds(292, 17, 56, 16);
		panel_2.add(lblNewLabel_7);
		
		cmbDoc = new JComboBox<>();
		cmbDoc.setBounds(292, 50, 196, 22);
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
		txtCodigoCons.setBounds(50, 50, 196, 22);
		panel_2.add(txtCodigoCons);
		txtCodigoCons.setText("C-"+Clinica.getInstance().getcodCons());
		
		JLabel lblNewLabel_9 = new JLabel("Diagnostico:");
		lblNewLabel_9.setBounds(50, 165, 120, 16);
		panel_2.add(lblNewLabel_9);
		
		txtDiag = new JTextArea();
		txtDiag.setBounds(50, 194, 438, 64);
		panel_2.add(txtDiag);
		
		panelVac = new JPanel();
		panelVac.setBorder(new TitledBorder(null, "Vacuna", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelVac.setBounds(274, 89, 226, 74);
		panel_2.add(panelVac);
		panelVac.setLayout(null);
		panelVac.setVisible(false);
		
		cmbVac = new JComboBox<>();
		cmbVac.setBounds(18, 27, 196, 22);
		panelVac.add(cmbVac);
		cmbVac.addItem("<Selected>");
		for (Vacuna aux : Clinica.getInstance().getMisVacunas()) {
			if(aux != null) {
				cmbVac.addItem(aux.getNombre());
			}	
		}
		
		rdbVacuna = new JRadioButton("Vacunado");
		rdbVacuna.setBounds(292, 121, 196, 25);
		panel_2.add(rdbVacuna);
		
		rdbEnf = new JRadioButton("Esta Enfermo");
		rdbEnf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbSano.setVisible(false);
				rdbEnf.setVisible(false);
				PanEnf.setVisible(true);
				cmbEnf.removeAllItems();
				cmbVac.setSelectedIndex(0);
				cmbEnf.addItem("<Selected>");
				for (Enfermedad aux : Clinica.getInstance().getMisEnfermedades()) {
					if(aux != null) {
						cmbEnf.addItem(aux.getNombre());
					}	
				}
			}
		});
		rdbEnf.setBounds(50, 85, 127, 25);
		panel_2.add(rdbEnf);
		
		rdbSano = new JRadioButton("Esta Sano");
		rdbSano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbSano.setVisible(false);
				rdbEnf.setVisible(false);
				PanEnf.setVisible(true);
				pac = (Paciente)Clinica.getInstance().buscarPersonaByCodigo(txtCedPaciente.getText());
				cmbEnf.removeAllItems();
				cmbVac.setSelectedIndex(0);
				cmbEnf.addItem("<Selected>");
				for (Enfermedad aux : pac.getHist().getMisEnfermedades()){
					if(aux != null) {
						cmbEnf.addItem(aux.getNombre());
					}
				}
			}
		});
		rdbSano.setBounds(50, 121, 127, 25);
		panel_2.add(rdbSano);
		rdbVacuna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelVac.setVisible(true);
				rdbVacuna.setVisible(false);
				cmbVac.setSelectedIndex(0);
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String cedula = txtCedPaciente.getText();
				        Paciente paciente = searchOrCreatePatient(cedula);

				        if (paciente != null) {
				            // If patient exists, update their information
				            registerConsulta(paciente);

				        } else {
				            JOptionPane.showMessageDialog(null, "Consulta No Pudo Ser Registrada", "Consulta Fallida", JOptionPane.INFORMATION_MESSAGE);
				        }
				    }
				});
				
				btnHistorial = new JButton("Ver Historial");
				btnHistorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PacienteHistorial ph= new PacienteHistorial(pac);
						ph.setModal(true);
						ph.setVisible(true);
					}
				});
				btnHistorial.setEnabled(false);
				buttonPane.add(btnHistorial);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void PacUpdate() {
		pac.setNombre(txtNom.getText());
		pac.setDir(txtDir.getText());
		pac.setTelefono(txtTel.getText());
		pac.setCorreoElectronico(txtEmail.getText());
		pac.setSeguro(txtSeguro.getText());
		if(rdbHombre.isSelected()) {
			pac.setSexo('H');
		} else {
			pac.setSexo('M');
		}
		Clinica.getInstance().modificarPersona(pac);
	}
	
	

	protected void loadPaciente(Paciente pac) {
		txtCedPaciente.setText(pac.getCedula());
		txtEmail.setText(pac.getCorreoElectronico());
		txtDir.setText(pac.getDir());
		txtNom.setText(pac.getNombre());
		txtTel.setText(pac.getTelefono());
		if(pac.getSeguro() != null) {
			txtSeguro.setText(pac.getSeguro());
		}
		if(pac.getSexo() == 'H') {
			rdbHombre.setSelected(true);
			rdbMujer.setSelected(false);
		} else {
			rdbHombre.setSelected(false);
			rdbMujer.setSelected(true);
		}
		
	}
	private Paciente searchOrCreatePatient(String cedula) {
	    Paciente paciente = (Paciente) Clinica.getInstance().buscarPersonaByCedula(cedula);

	    if (paciente == null) {
	        char sex = rdbHombre.isSelected() ? 'H' : 'M';
	        paciente = new Paciente(cedula, txtNom.getText(), txtDir.getText(), "P-" + Clinica.getInstance().getcodPers(), txtTel.getText(), sex, txtEmail.getText(), txtSeguro.getText());
	        Clinica.getInstance().agregarPersona(paciente);
	    }

	    return paciente;
	}

	private void updatePatient(Paciente paciente, Vacuna vac, Enfermedad enf, String status) {
	    paciente.setNombre(txtNom.getText());
	    paciente.setDir(txtDir.getText());
	    paciente.setTelefono(txtTel.getText());
	    paciente.setCorreoElectronico(txtEmail.getText());
	    paciente.setSeguro(txtSeguro.getText());
	    paciente.setSexo(rdbHombre.isSelected() ? 'H' : 'M');
	    if(vac != null) {
	    	try {
				paciente.getHist().addMisVacunas(vac);
			} catch (Exception e) {
				// TODO: handle exception
			}

	    }
	    if(enf != null) {
	    	try {
		    	if(status.equalsIgnoreCase("Enfermo")) {
					paciente.getHist().addMisEnfermedades(enf);
		    	} else if (status.equalsIgnoreCase("Sano")) {
					paciente.getHist().eliminarMisEnfermedades(enf);
		    	}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }
	    Clinica.getInstance().modificarPersona(paciente);
	    
	}


	private void registerConsulta(Paciente paciente) {
	    Doctor doctor = null;
	    doctor = (Doctor)Clinica.getInstance().buscarPersonaByNom(cmbDoc.getSelectedItem().toString());
	    Enfermedad enfermedad = null;
	    Vacuna vacuna = null;
	    if(encontrado || !verificarCedulaRepetida(txtCedPaciente.getText())) {
	    	if (rdbEnf.isSelected() || rdbSano.isSelected()) {
		        enfermedad = Clinica.getInstance().buscarEnfermedadByNom(cmbEnf.getSelectedItem().toString());
		    }

		    if (rdbVacuna.isSelected()) {
		        vacuna = Clinica.getInstance().buscarVacunaByNom(cmbVac.getSelectedItem().toString());
		    }

		    String status = "Investigando";

		    if (enfermedad != null) {
		        if (rdbEnf.isSelected()) {
		            status = "Enfermo";
		            paciente.getHist().addMisEnfermedades(enfermedad);
		        } else if (rdbSano.isSelected()) {
		            status = "Sano";
		            paciente.getHist().eliminarMisEnfermedades(enfermedad);
		        }
		    }

		    Consulta consulta = new Consulta(txtCodigoCons.getText(), txtDiag.getText(), enfermedad, paciente, doctor, status, vacuna);

		    int option = JOptionPane.showConfirmDialog(null, "Desea agregar la consulta al historial del paciente?", "Confirmaci�n", JOptionPane.OK_CANCEL_OPTION);
		    if (option == JOptionPane.OK_OPTION) {
		        paciente.getHist().addMisConsultas(consulta);
		    }

	        updatePatient(paciente, vacuna, enfermedad, status);
		    Clinica.getInstance().agregarConsulta(consulta);

		    JOptionPane.showMessageDialog(null, "Consulta Registrada Exitosamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);

		    Clean();

	    }else {
		    JOptionPane.showMessageDialog(null, "Consulta Registrada Exitosamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);
	    }
	    	}
	
	private void Clean() {
		txtCedPaciente.setText("");
		txtCodigoCons.setText("C-"+Clinica.getInstance().getcodCons());
		txtEmail.setText("");
		txtDiag.setText("");
		txtDir.setText("");
		txtNom.setText("");
		txtSeguro.setText("");
		txtTel.setText("");
		rdbHombre.setSelected(false);
		rdbMujer.setSelected(false);
		cmbDoc.setSelectedIndex(0);
		cmbEnf.setSelectedIndex(0);
		rdbSano.setVisible(true);
		rdbSano.setSelected(false);
		rdbEnf.setVisible(true);
		rdbEnf.setSelected(false);
		rdbVacuna.setVisible(true);
		rdbVacuna.setSelected(false);
		panelVac.setVisible(false);
		PanEnf.setVisible(false);
		btnHistorial.setEnabled(false);
		pac = null;
		
	}
	
	public boolean verificarCedulaRepetida(String cedula) {
	    for (Persona persona : Clinica.getInstance().getMisPersonas()) {
	        if (persona.getCedula().equals(txtCedPaciente.getText())) {
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	    return true; // The cedula is not repeated.
	}
}
