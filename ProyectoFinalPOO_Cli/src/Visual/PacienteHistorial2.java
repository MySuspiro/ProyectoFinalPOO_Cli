package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Consulta;
import logico.Historial;
import logico.Paciente;
import logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class PacienteHistorial2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCedula;
	private Object[] row;
	private DefaultTableModel modelo;
	private Object[] row2;
	private DefaultTableModel modelo2;
	private JButton btnBuscar;
	private Historial historial = null;
	private Paciente paciente = null;
	private JTextField txtCodigo;
	private JTextField txtPaciente;
	private JTable tablevac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PacienteHistorial2 dialog = new PacienteHistorial2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PacienteHistorial2() {
		setTitle("Historial de un Paciente");
		setResizable(false);
		setBounds(100, 100, 686, 697);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelTabla = new JPanel();
				panelTabla.setBounds(12, 108, 650, 310);
				panel.add(panelTabla);
				panelTabla.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panelTabla.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						modelo= new DefaultTableModel();
						String[] headers = {"Fecha", "Diagnostico", "Enfermedad"};
						modelo.setColumnIdentifiers(headers);
						table.setModel(modelo);
						scrollPane.setViewportView(table);
					}
				}
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(139, 27, 400, 22);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("Escriba la C\u00E9dula:");
				lblNewLabel.setBounds(22, 30, 159, 16);
				panel.add(lblNewLabel);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!txtCedula.getText().isEmpty())
						{
							String nombreBuscado = txtCedula.getText();
							System.out.println("cedula: " + txtCedula.getText());
							loadConsultas(nombreBuscado);	
						}
						
					}
				});
				btnBuscar.setBounds(556, 26, 97, 25);
				panel.add(btnBuscar);
			}
			{
				JLabel label = new JLabel("C\u00F3digo Historial:");
				label.setBounds(19, 66, 97, 16);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(135, 63, 77, 22);
				panel.add(txtCodigo);
			}
			{
				JLabel label = new JLabel("Nombre Paciente:");
				label.setBounds(231, 66, 122, 16);
				panel.add(label);
			}
			{
				txtPaciente = new JTextField();
				txtPaciente.setEditable(false);
				txtPaciente.setColumns(10);
				txtPaciente.setBounds(372, 63, 281, 22);
				panel.add(txtPaciente);
			}
			{
				JLabel lblVacunas = new JLabel("Vacunas:");
				lblVacunas.setBounds(12, 431, 97, 16);
				panel.add(lblVacunas);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 460, 650, 129);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			tablevac = new JTable();
			modelo2= new DefaultTableModel();
			String[] headers2 = {"Nombre", "Descripción", "Enfermedad"};
			modelo2.setColumnIdentifiers(headers2);
			tablevac.setModel(modelo2);
			scrollPane.setViewportView(tablevac);
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
	
	private void loadConsultas(String clienteBuscado) {
		modelo.setRowCount(0);
		row= new Object[table.getColumnCount()];
		modelo2.setRowCount(0);
		row2= new Object[table.getColumnCount()];
		historial = Clinica.getInstance().buscarHistorialByCedula(txtCedula.getText());
		historial = Clinica.getInstance().buscarHistorialByCedula(txtCedula.getText());
		//System.out.println("Valor de historial: " + historial.getCodigo());
		JOptionPane.showMessageDialog(null, "Llegue aqui", "Error", JOptionPane.ERROR_MESSAGE);
		
		if (historial!=null) 
		{
			JOptionPane.showMessageDialog(null, "Encontre Historial", "Error", JOptionPane.ERROR_MESSAGE);
			 boolean coincidencia=false;
			 ArrayList<Consulta> misConsultas = historial.getMisConsultas();
			 ArrayList<Vacuna> misVacunas = historial.getMisVacunas();
			 paciente=(Paciente) Clinica.getInstance().buscarPersonaByCedula(txtCedula.getText());
		     txtPaciente.setText(paciente.getNombre());
		     txtCodigo.setText(historial.getCodigo());

			 for (Consulta consulta : misConsultas) {
			        if (consulta.getPaciente().getCedula().equals(paciente.getCedula())) {
						row[0]=consulta.getFechaConsulta();
						row[1]=consulta.getDiagnostico();
						row[2]=consulta.getEnfermedad().getNombre();
			            modelo.addRow(row);
			            coincidencia=true;
			        }
			    }
			 
			 for (Vacuna vacuna : misVacunas) {
						row2[0]=vacuna.getNombre();
						row2[1]=vacuna.getDescripcion();
						row2[2]=vacuna.getEnf().getNombre();
			            modelo2.addRow(row2);
			            coincidencia=true;
			        
			        }
			    
			    if(!coincidencia)
			    {
			    	 JOptionPane.showMessageDialog(null, "No existe Historial", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    
			
		}
     else {
        JOptionPane.showMessageDialog(null, "No existe Historial", "Error", JOptionPane.ERROR_MESSAGE);
    }
			
	}
}