package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import logico.CitaMedica;
import logico.Clinica;

import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class ListarCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private Object[] row;
	private CitaMedica selected = null;
	private JButton btnDel;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCita dialog = new ListarCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCita() {
		setBounds(100, 100, 692, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index >= 0) {
							btnDel.setEnabled(true);
							btnDel.setEnabled(true);
							selected = Clinica.getInstance().buscarCitaByCode(table.getValueAt(index, 0).toString());
						}
					}
				});
				scrollPane.setViewportView(table);
				
				String[] headers = {"Codigo", "Fecha", "Hora", "Cedula del Paciente", "Nombre del Paciente"};
				modelo.setColumnIdentifiers(headers);
				
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						RegCita regCita = new RegCita(selected);
						regCita.setModal(true);
						regCita.setVisible(true);
						
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				btnDel = new JButton("Eliminar");
				btnDel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Clinica.getInstance().eliminarCitas(selected);;
						loadCitas();
						btnDel.setEnabled(false);
						btnUpdate.setEnabled(false);
					}
				});
				buttonPane.add(btnDel);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	protected void loadCitas() {
		if(Clinica.getInstance().getMisCitas() != null) {
			modelo.setRowCount(0);
			row = new Object[table.getColumnCount()];
			
			for(CitaMedica aux: Clinica.getInstance().getMisCitas()) {
				row[0] = aux.getCodigo();
				row[1] = aux.getFecha();
				row[2] = aux.getHora();
				row[3] = aux.getCedPaciente();
				row[4] = aux.getNomPaciente();
				modelo.addRow(row);
			}
		}
	}

}
