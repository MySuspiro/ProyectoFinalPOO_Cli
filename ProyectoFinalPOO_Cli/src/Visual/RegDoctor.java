package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Doctor;
import logico.Persona;

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
		setBounds(100, 100, 474, 528);
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
				JLabel label = new JLabel("C\u00F3digo:");
				label.setBounds(12, 14, 56, 16);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setText("D-"+Clinica.getInstance().codigoPersona);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(12, 44, 267, 22);
				panel.add(txtCodigo);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(12, 146, 56, 16);
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
		                    // Consumir el evento para evitar que se escriba el car�cter no v�lido
		                    e.consume();
		                }
					}
				});
				txtNombre.setColumns(10);
				txtNombre.setBounds(12, 176, 267, 22);
				panel.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(12, 344, 70, 16);
				panel.add(label);
			}
			{
				txtDireccion = new JTextArea();
				txtDireccion.setBounds(12, 374, 430, 53);
				panel.add(txtDireccion);
			}
			{
				JLabel lblSexo = new JLabel("Sexo");
				lblSexo.setBounds(306, 149, 97, 16);
				panel.add(lblSexo);
			}
			{
				cbSexo = new JComboBox<String>();
				cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Femenino", "Masculino"}));
				cbSexo.setSelectedIndex(-1);
				cbSexo.setMaximumRowCount(2);
				cbSexo.setToolTipText("");
				cbSexo.setBounds(306, 176, 107, 22);
				panel.add(cbSexo);
			}
			{
				JLabel lblCdula = new JLabel("C\u00E9dula:");
				lblCdula.setBounds(12, 80, 56, 16);
				panel.add(lblCdula);
			}
			{
				txtCedula = new JTextField();
				txtCedula.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						 // Obtener la tecla presionada
		                char c = e.getKeyChar();
		                // Verificar si la tecla es un n�mero
		                if (!Character.isDigit(c)) {
		                    // Consumir el evento para evitar que se escriba el car�cter no v�lido
		                    e.consume();
		                }
					}
				});
				txtCedula.setColumns(10);
				txtCedula.setBounds(12, 110, 267, 22);
				panel.add(txtCedula);
			}
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(12, 212, 56, 16);
			panel.add(lblTelfono);
			
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				    char c = e.getKeyChar();
				    
				    // Verificar si la tecla es un n�mero o el car�cter '-'
				    if (!Character.isDigit(c) && c != '-') {
				        e.consume(); 
				    }
				}
			});
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(12, 242, 267, 22);
			panel.add(txtTelefono);
			
			JLabel lblLmiteDeCrdito = new JLabel("Especialidad:");
			lblLmiteDeCrdito.setBounds(12, 278, 129, 16);
			panel.add(lblLmiteDeCrdito);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					 // Obtener la tecla presionada
	                char c = e.getKeyChar();
	                // Verificar si la tecla es una letra
	                if (!Character.isLetter(c)&& c != ' ') {
	                    // Consumir el evento para evitar que se escriba el car�cter no v�lido
	                    e.consume();
	                }
				}
			});
			txtEspecialidad.setColumns(10);
			txtEspecialidad.setBounds(12, 308, 267, 22);
			panel.add(txtEspecialidad);
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
						if(verificarCedulaRepetida()==true) {
						//
						
						if (miDoctor==null)
						{
							if (checkFields()==true){
							
						
						
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
						
						Persona persona = new Doctor(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(),txtCodigo.getText(),txtTelefono.getText(),sexo,txtEspecialidad.getText());
						Clinica.getInstance().agregarPersona(persona);
						
						JOptionPane.showMessageDialog(null,"Operaci�n satisfactoria","Registro", JOptionPane.INFORMATION_MESSAGE);
						//dispose();
					    clean();
					    
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
							//Clinica.getInstance().modificarPersona(miDoctor);
							dispose();
							//ListarDoctor.loadDoctores();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenos");
								
							}
						}
						
					}
						else
						{
							JOptionPane.showMessageDialog(null,"Existe una Persona con esa C�dula");
						}
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
		cbSexo.setSelectedIndex(-1);
		txtCodigo.setText("D-"+Clinica.getInstance().codigoPersona);
		
	}
	
	private boolean checkFields() {
		
		if (txtNombre.getText().equals("") || txtCedula.getText().equals("") || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") || txtEspecialidad.getText().equals("") ||  cbSexo.getSelectedIndex()==-1)
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
}
