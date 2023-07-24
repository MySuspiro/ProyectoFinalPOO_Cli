package Visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logico.Doctor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class AgendaSemanal2 extends JDialog {
    private Doctor doctor;
    private JTable table;
    private Calendar calendar;

    public AgendaSemanal2(Doctor doctor) {
        this.doctor = doctor;
        calendar = Calendar.getInstance();

        
        setTitle("Agenda Semanal");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setModal(true); 

        
        table = new JTable(10, 6);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        String[] diasSemana = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        model.setColumnIdentifiers(diasSemana);

        String[] horas = {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        for (int i = 0; i < horas.length; i++) {
            model.setValueAt(horas[i], i, 0);
        }

        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar botones para cambiar de semana
        JButton btnSemanaAnterior = new JButton("Semana Anterior");
        JButton btnSemanaSiguiente = new JButton("Semana Siguiente");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSemanaAnterior);
        buttonPanel.add(btnSemanaSiguiente);
        add(buttonPanel, BorderLayout.SOUTH);

       
        btnSemanaAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.WEEK_OF_YEAR, -1); // Restar una semana
                actualizarAgenda();
            }
        });

        btnSemanaSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.WEEK_OF_YEAR, 1); // Sumar una semana
                actualizarAgenda();
            }
        });

        
        actualizarAgenda();
    }

 
    private void actualizarAgenda() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int numeroSemana = calendar.get(Calendar.WEEK_OF_YEAR);
        int ano = calendar.get(Calendar.YEAR);
        setTitle("Agenda Semanal - Semana del " + obtenerFechaInicioSemana(numeroSemana, ano) + " al " + obtenerFechaFinSemana(numeroSemana, ano));
    }

    
    private String obtenerFechaInicioSemana(int numeroSemana, int ano) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, numeroSemana);
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
    }

    // Método para obtener la fecha de fin de la semana
    private String obtenerFechaFinSemana(int numeroSemana, int ano) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, numeroSemana);
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
        return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
    }

    
    public void showDialog() {
        setVisible(true);
    }
}
