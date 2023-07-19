package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;

import logico.Control;

import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JMenu mnAdministracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//NUEVO CAROLINA PROBANDO
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("clinica.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Control.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setResizable(false);
		setTitle("Cl\u00EDnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim=getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_6 = new JMenu("Cliente");
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Registrar");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PROBANDO CAROLINA
				RegUser users = new RegUser();
				users.setModal(true);
				users.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_2 = new JMenu("Paciente");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPaciente listPaciente= new ListarPaciente();
				listPaciente.setModal(true);
				listPaciente.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Historial");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteHistorial paH= new PacienteHistorial();
				paH.setModal(true);
				paH.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Registrar(prueba)");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPaciente rp= new RegPaciente(null);
				rp.setModal(true);
				rp.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu = new JMenu("Doctor");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Agenda Citas");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Consulta");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegConsulta regConsul= new RegConsulta();
			regConsul.setModal(true);
			regConsul.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ListarFactura2 listarFactura= new ListarFactura2();
				listarFactura.setModal(true);
				listarFactura.setVisible(true);*/
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Cita");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registrar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita regCita= new RegCita();
				regCita.setModal(true);
				regCita.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_4 = new JMenu("Enfermedad");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listar");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnf listEnf= new ListarEnf();
				listEnf.setModal(true);
				listEnf.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_5 = new JMenu("Vacuna");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Registrar");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Listar");
		mnNewMenu_5.add(mntmNewMenuItem_12);
		
		mnAdministracion = new JMenu("Administraci\u00F3n");
		
		if(!Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
			mnAdministracion.setEnabled(false);
		}
		menuBar.add(mnAdministracion);
		
		JMenu mnNewMenu_8 = new JMenu("Enfermedad");
		mnAdministracion.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Registrar");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnf regEnf= new RegEnf(null);
				regEnf.setModal(true);
				regEnf.setVisible(true);	
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Listar");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnf listEnf= new ListarEnf();
				listEnf.setModal(true);
				listEnf.setVisible(true);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_16);
		
		JMenu mnNewMenu_9 = new JMenu("Vacuna");
		mnAdministracion.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Registrar");
		mnNewMenu_9.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Listar");
		mnNewMenu_9.add(mntmNewMenuItem_18);
		
		JMenu mnNewMenu_10 = new JMenu("Doctor");
		mnAdministracion.add(mnNewMenu_10);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Registrar");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDoctor regDoc= new RegDoctor(null);
				regDoc.setModal(true);
				regDoc.setVisible(true);
			}
		});
		mnNewMenu_10.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Listar");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctor listDoc= new ListarDoctor();
				listDoc.setModal(true);
				listDoc.setVisible(true);
			}
		});
		mnNewMenu_10.add(mntmNewMenuItem_20);
		
		JMenu mnNewMenu_7 = new JMenu("Empleado");
		mnAdministracion.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpleado regEmp= new RegEmpleado(null);
				regEmp.setModal(true);
				regEmp.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Listar");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmp listEmp= new ListarEmp();
				listEmp.setModal(true);
				listEmp.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_21);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}
}

