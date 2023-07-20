package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Control;
import logico.Doctor;
import logico.Persona;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class RegDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextArea txtDireccion;
	private JComboBox<String> cbSexo;
	private JTextField txtCedula;
	private Doctor miDoctor=null;
	private JTextField txtTelefono;
	private JTextField txtEspecialidad;
	private JTextField txtUsername;
	private JTextField txtContrasena;
	private JTextField txtConfirm;
	private JTextField txtCorreoE;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegDoctor(Doctor doctor) {
		miDoctor=doctor;
		setResizable(false);
		if (miDoctor!=null) 
		{
			setTitle("Modificar Doctor");
			
		}else 
		{
			setTitle("Registrar Doctor");
		}
		setBounds(100, 100, 664, 653);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblUsuario.setBounds(23, 398, 97, 16);
				panel.add(lblUsuario);
			}
			{
				JLabel lblNewLabel = new JLabel("Info. General");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setBounds(26, 3, 97, 16);
				panel.add(lblNewLabel);
			}
			{
				JLabel label = new JLabel("C\u00F3digo:");
				label.setBounds(40, 28, 56, 16);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setText("D-"+Clinica.getInstance().codigoPersona);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(40, 58, 267, 22);
				panel.add(txtCodigo);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(40, 93, 56, 16);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						 // Obtener la tecla presionada
		                char c = e.getKeyChar();
		                // Verificar si la tecla es una letra
		                if (!Character.isLetter(c)&& c != ' ') {
		                    // Consumir el evento para evitar que se escriba el carácter no válido
		                    e.consume();
		                }
					}
				});
				txtNombre.setColumns(10);
				txtNombre.setBounds(40, 123, 267, 22);
				panel.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(40, 291, 70, 16);
				panel.add(label);
			}
			{
				txtDireccion = new JTextArea();
				txtDireccion.setBounds(40, 320, 561, 53);
				panel.add(txtDireccion);
			}
			{
				JLabel lblSexo = new JLabel("Sexo");
				lblSexo.setBounds(334, 96, 97, 16);
				panel.add(lblSexo);
			}
			{
				cbSexo = new JComboBox<String>();
				cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Femenino", "Masculino"}));
				cbSexo.setSelectedIndex(-1);
				cbSexo.setMaximumRowCount(2);
				cbSexo.setToolTipText("");
				cbSexo.setBounds(334, 123, 107, 22);
				panel.add(cbSexo);
			}
			{
				JLabel lblCdula = new JLabel("C\u00E9dula:");
				lblCdula.setBounds(334, 28, 56, 16);
				panel.add(lblCdula);
			}
			{
				txtCedula = new JTextField();
				txtCedula.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						 // Obtener la tecla presionada
		                char c = e.getKeyChar();
		                // Verificar si la tecla es un número
		                if (!Character.isDigit(c)) {
		                    // Consumir el evento para evitar que se escriba el carácter no válido
		                    e.consume();
		                }
					}
				});
				txtCedula.setColumns(10);
				txtCedula.setBounds(334, 58, 267, 22);
				panel.add(txtCedula);
			}
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(40, 162, 56, 16);
			panel.add(lblTelfono);
			
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				    char c = e.getKeyChar();
				    
				    // Verificar si la tecla es un número o el carácter '-'
				    if (!Character.isDigit(c) && c != '-') {
				        e.consume(); 
				    }
				}
			});
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(40, 192, 267, 22);
			panel.add(txtTelefono);
			
			JLabel lblLmiteDeCrdito = new JLabel("Especialidad:");
			lblLmiteDeCrdito.setBounds(334, 162, 129, 16);
			panel.add(lblLmiteDeCrdito);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					 // Obtener la tecla presionada
	                char c = e.getKeyChar();
	                // Verificar si la tecla es una letra
	                if (!Character.isLetter(c)&& c != ' ') {
	                    // Consumir el evento para evitar que se escriba el carácter no válido
	                    e.consume();
	                }
				}
			});
			txtEspecialidad.setColumns(10);
			txtEspecialidad.setBounds(334, 192, 267, 22);
			panel.add(txtEspecialidad);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(12, 13, 613, 383);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico:");
					lblCorreoElectrnico.setBounds(27, 213, 192, 16);
					panel_1.add(lblCorreoElectrnico);
				}
				{
					txtCorreoE = new JTextField();
					txtCorreoE.setColumns(10);
					txtCorreoE.setBounds(27, 243, 560, 22);
					panel_1.add(txtCorreoE);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(12, 409, 613, 146);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario:");
					lblNewLabel_1.setBounds(29, 13, 154, 16);
					panel_1.add(lblNewLabel_1);
				}
				{
					txtUsername = new JTextField();
					txtUsername.setColumns(10);
					txtUsername.setBounds(29, 42, 276, 22);
					panel_1.add(txtUsername);
				}
				{
					JLabel lblContrase = new JLabel("Contrase\u00F1a:");
					lblContrase.setBounds(29, 82, 154, 16);
					panel_1.add(lblContrase);
				}
				{
					txtContrasena = new JTextField();
					txtContrasena.setColumns(10);
					txtContrasena.setBounds(29, 111, 276, 22);
					panel_1.add(txtContrasena);
				}
				{
					JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
					lblConfirmarContrasea.setBounds(334, 82, 154, 16);
					panel_1.add(lblConfirmarContrasea);
				}
				{
					txtConfirm = new JTextField();
					txtConfirm.setColumns(10);
					txtConfirm.setBounds(334, 111, 267, 22);
					panel_1.add(txtConfirm);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				if (miDoctor!=null) {

					okButton.setText("Modificar");
				}

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if(verificarCedulaRepetida()==true) {
						//
						
						if (miDoctor==null)
						{
							if (checkFields()==true){
								
								if(verificarCedulaRepetida()==true && verificarUserRepetido()==true && verificarContrasena()==true) {
							
						
						
									char sexo;
									String sexoSeleccionado = (String) cbSexo.getSelectedItem();
									if (sexoSeleccionado.equals("Femenino"))
									{
										sexo='F';
									}
									else 
									{
									sexo='M';
									}
									
									Persona persona = new Doctor(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(),txtCodigo.getText(),txtTelefono.getText(),sexo,txtCorreoE.getText(),txtEspecialidad.getText());
									Clinica.getInstance().agregarPersona(persona);
									
				
									User user = new User("Doctor",txtUsername.getText(),txtContrasena.getText(),persona);
								    Control.getInstance().regUser(user);
									

									
									JOptionPane.showMessageDialog(null,"Operación satisfactoria","Registro", JOptionPane.INFORMATION_MESSAGE);
									//dispose();
								    clean();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Ha ocurrido un error, verifique cedula no repetida, username y claves");
								}
							    
							}
							else
							{
								 JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenos");
							}
					    
						
						}else
						{
							miDoctor.setDir(txtDireccion.getText());
							miDoctor.setNombre(txtNombre.getText());
							miDoctor.setCedula(txtCedula.getText());
							miDoctor.setEspecialidad(txtEspecialidad.getText());
							miDoctor.setTelefono(txtTelefono.getText());
							miDoctor.setCorreoElectronico(txtCorreoE.getText());
							char sexo;
							String sexoSeleccionado = (String) cbSexo.getSelectedItem();
							if (sexoSeleccionado.equals("Femenino"))
							{
								sexo='F';
							}
							else 
							{
							sexo='M';
							}
							miDoctor.setSexo(sexo);
							if (checkFields()==true)
							{
							Clinica.getInstance().modificarPersona(miDoctor);
							dispose();
							ListarDoctor.loadDoctores();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenos");
								
							}
						}
						
					//}
						/*else
						{
							JOptionPane.showMessageDialog(null,"Existe una Persona con esa Cédula");
						}*/
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
		loadDoctor();
	}
	
	private void loadDoctor() {
		if (miDoctor!=null) {
			txtCodigo.setText(miDoctor.getCodigo());
			txtCedula.setText(miDoctor.getCedula());
			txtNombre.setText(miDoctor.getNombre());
			txtTelefono.setText(miDoctor.getTelefono());
			txtEspecialidad.setText(miDoctor.getEspecialidad());
			txtCorreoE.setText(miDoctor.getCorreoElectronico());
			char sexo=miDoctor.getSexo();
			if (sexo=='F')
			{
				cbSexo.setSelectedIndex(0);
			}
			else {
				cbSexo.setSelectedIndex(1);
			}
			txtDireccion.setText(miDoctor.getDir());
			
			
		}
		
	}

	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEspecialidad.setText("");
		txtCorreoE.setText("");
		cbSexo.setSelectedIndex(-1);
		txtCodigo.setText("D-"+Clinica.getInstance().codigoPersona);
		txtUsername.setText("");
		txtContrasena.setText("");
		txtConfirm.setText("");
		
	}
	
	private boolean checkFields() {
		
		if (txtNombre.getText().equals("") || txtCedula.getText().equals("") || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") || txtEspecialidad.getText().equals("") || txtCorreoE.getText().equals("") || txtUsername.getText().equals("") ||txtContrasena.getText().equals("") ||txtConfirm.getText().equals("") ||cbSexo.getSelectedIndex()==-1)
		{
			return false;
			
		}
		else 
		{
			return true;
		}

	}
	
	public boolean verificarCedulaRepetida() {
		
	    for (Persona persona : Clinica.getInstance().getMisPersonas()) {
	        if (persona.getCedula().equals(txtCedula.getText())) {
	            return false;//se repite 
	        }
	    }
	    return true; //no se repite
	}
	
	public boolean verificarUserRepetido() {
		
	    for (User user : Clinica.getInstance().getMisUsers()) {
	        if (user.getUserName().equals(txtUsername.getText())) {
	            return false;//se repite 
	        }
	    }
	    return true; //no se repite
	}
	
	public boolean verificarContrasena() {
		if (txtContrasena.getText().equals(txtConfirm.getText()))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
