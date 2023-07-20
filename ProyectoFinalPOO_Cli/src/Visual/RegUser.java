package Visual;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Control;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class RegUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JTextField txtContrasena;
	private JTextField txtConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUser dialog = new RegUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUser() {
		setTitle("Crear Administrador");
		setBounds(100, 100, 450, 247);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(30, 24, 97, 14);
		contentPanel.add(lblNombreUsuario);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(28, 53, 174, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(26, 113, 176, 20);
		contentPanel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 86, 97, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setBounds(228, 90, 167, 14);
		contentPanel.add(lblConfirmarPassword);
		
		txtConfirm = new JTextField();
		txtConfirm.setColumns(10);
		txtConfirm.setBounds(228, 113, 176, 20);
		contentPanel.add(txtConfirm);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (checkFields()==true)
						{
							if (verificarUserRepetido()==true)
							{
								if(verificarContrasena()==true)
								{
									User user = new User("Administrador",txtUsername.getText(),txtContrasena.getText(),null);
								    Control.getInstance().regUser(user);
								    JOptionPane.showMessageDialog(null,"Operaci�n satisfactoria","Registro", JOptionPane.INFORMATION_MESSAGE);
								    clean();
									
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Los Passwords no coinciden");
									
								}
		
							}
							else
							{	
								JOptionPane.showMessageDialog(null,"Ya existe un Usuario con ese nombre");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Todos los Campos deben estar llenos");
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
	private boolean checkFields() {
		
		if (txtUsername.getText().equals("") ||txtContrasena.getText().equals("") ||txtConfirm.getText().equals(""))
		{
			return false;
			
		}
		else 
		{
			return true;
		}

	}
	private void clean() {
		txtUsername.setText("");
		txtContrasena.setText("");
		txtConfirm.setText("");
		
	}
}