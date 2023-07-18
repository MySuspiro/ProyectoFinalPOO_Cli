package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import logico.CitaMedica;
import logico.Clinica;
import logico.Enfermedad;

import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class RegEnf extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JRadioButton rdbVig;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEnf dialog = new RegEnf();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEnf() {
		setBounds(100, 100, 450, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(42, 13, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(242, 14, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Descripcion:");
			lblNewLabel_2.setBounds(42, 124, 156, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(242, 80, 149, 60);
			contentPanel.add(panel);
			{
				rdbVig = new JRadioButton("Bajo Vigilancia");
				panel.add(rdbVig);
			}
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(42, 44, 156, 22);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			txtCodigo.setText("E-"+Clinica.enfCod);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(242, 44, 149, 22);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtDescripcion = new JTextArea();
			txtDescripcion.setBounds(42, 154, 349, 60);
			contentPanel.add(txtDescripcion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String status;
						if(rdbVig.isSelected() == true) {
							status = "vigilancia";
						}else {
							status = "Normal";
						}
						Enfermedad enf = new Enfermedad(txtCodigo.getText(), txtNombre.getText(), status, txtDescripcion.getText());
						Clinica.getInstance().agregarEnfermedad(enf);
						JOptionPane.showMessageDialog(null, "Enfermedad registrada correcta", "Enfermedad", JOptionPane.INFORMATION_MESSAGE);
						Clean();
						
					}
				});
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
	private void Clean() {
		txtCodigo.setText("E-" + Clinica.enfCod);
		txtDescripcion.setText("");
		txtNombre.setText("");
		rdbVig.setSelected(false);
		
	}
	

}
