package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

import logico.CitaMedica;
import logico.Clinica;
import logico.Doctor;
import logico.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod;
	private JFormattedTextField txtFech;
	private JFormattedTextField txtHora;
	private JComboBox<String> cbxDoc;
	private JTextField txtNomPac;
	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    DateFormatter df = new DateFormatter(format);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita jdialog = new RegCita();
			jdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			jdialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita() {
		setBounds(100, 100, 375, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(12, 21, 56, 16);
		contentPanel.add(lblNewLabel);
		{
			txtCod = new JTextField();
			txtCod.setEditable(false);
			txtCod.setBounds(62, 18, 261, 22);
			contentPanel.add(txtCod);
			txtCod.setColumns(10);
			txtCod.setText("CM-" + Clinica.citCod);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Fecha:");
			lblNewLabel_1.setBounds(50, 58, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre del Paciente:");
			lblNewLabel_2.setBounds(179, 58, 128, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Hora:");
			lblNewLabel_3.setBounds(50, 138, 56, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Doctor:");
			lblNewLabel_4.setBounds(179, 138, 56, 16);
			contentPanel.add(lblNewLabel_4);
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
						Doctor doc = null;
						Date fech = null;
						try {
							fech = format.parse(txtFech.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						CitaMedica cita = new CitaMedica(txtCod.getText(), txtNomPac.getText(), doc, txtHora.getText(), fech);
						Clinica.getInstance().agregarCita(cita);
						JOptionPane.showMessageDialog(null, "Cita Agendada Exitosamente", "Agenda", JOptionPane.INFORMATION_MESSAGE);
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
			{
			MaskFormatter mask = null;
	        try {
	            // Create a MaskFormatter for accepting phone number, the # symbol accept
	            // only a number. We can also set the empty value with a place holder
	            // character.
	            mask = new MaskFormatter("## : ##");
	            mask.setPlaceholderCharacter('_');
	        } catch (java.text.ParseException e) {
	            e.printStackTrace();
	        }

	        // Create a formatted text field that accept a valid phone number.
	        txtHora = new JFormattedTextField(mask);
	        txtHora.setText("");
	        txtHora.setBounds(50, 175, 44, 22);

	        // Here we create a formatted text field that accept a date value. We
	        // create an instance of SimpleDateFormat and use it to create a
	        // DateFormatter instance which will be passed to the JFormattedTextField.
	        
	        txtFech = new JFormattedTextField(df);
	        txtFech.setBounds(50, 95, 75, 22);
	        txtFech.setValue(new Date());
	        contentPanel.add(txtHora);
	        contentPanel.add(txtFech);
			}
		}

		
		cbxDoc = new JComboBox<String>();
		cbxDoc.setBounds(179, 175, 128, 22);
		contentPanel.add(cbxDoc);
		{
			txtNomPac = new JTextField();
			txtNomPac.setBounds(179, 95, 128, 22);
			contentPanel.add(txtNomPac);
			txtNomPac.setColumns(10);
		}
		cbxDoc.addItem("<Seleccione>");
		for (Persona aux : Clinica.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				cbxDoc.addItem(aux.getNombre());
			}	
		}
		

        
	}
	
	private void Clean() {
		txtCod.setText("CM-" + Clinica.citCod);
		txtFech.setValue(new Date());
		txtHora.setText("00:00");
		txtNomPac.setText("");
		cbxDoc.setSelectedIndex(0);
	}
}
