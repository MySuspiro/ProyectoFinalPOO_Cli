package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Doctor;
import logico.Empleado;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListarEmp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] row;
	private JButton btnUpdate;
	private JButton btnEliminar;
	private Empleado selected=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarDoctor dialog = new ListarDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEmp() {
		setResizable(false);
		setTitle("Listado Empleados");
		setBounds(100, 100, 685, 458);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index=table.getSelectedRow();
						if (index>=0) {
							btnEliminar.setEnabled(true);
							btnUpdate.setEnabled(true);
							selected = (Empleado) Clinica.getInstance().buscarPersonaByCodigo(table.getValueAt(index,0).toString());
							
						}
					}
				});
				modelo= new DefaultTableModel();
				String[] headers = {"Codigo", "Nombre","Tel�fono","Puesto Laboral"};
				modelo.setColumnIdentifiers(headers);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnUpdate = new JButton("Actualizar");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							RegEmpleado update= new RegEmpleado(selected);
							update.setModal(true);
							update.setVisible(true);
							//nuevo
							btnEliminar.setEnabled(false);
							btnUpdate.setEnabled(false);


					}
				});
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Est� seguro(a) que desea eliminar el Empleado con c�digo: "+ selected.getCodigo(), "Confirmaci�n", JOptionPane.OK_CANCEL_OPTION);
							if (option== JOptionPane.OK_OPTION  ) {

									Clinica.getInstance().eliminarPersona(selected);
									btnEliminar.setEnabled(false);
									btnUpdate.setEnabled(false);
									loadEmps();

							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
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
		loadEmps();
	}

	public static void loadEmps() {
		modelo.setRowCount(0);
		row= new Object[table.getColumnCount()];
		
		for (Persona persona: Clinica.getInstance().getMisPersonas()) {
			if(persona instanceof Empleado)
			{
				row[0]=persona.getCodigo();
				row[1]=persona.getNombre();
				row[2]=persona.getTelefono();
				row[3]=((Empleado) persona).getPuestoLaboral();
				modelo.addRow(row);	
				
			}
		}	
		
	}


}
