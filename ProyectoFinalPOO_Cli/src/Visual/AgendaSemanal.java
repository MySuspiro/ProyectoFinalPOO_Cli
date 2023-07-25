package Visual;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logico.CitaMedica;
import logico.Clinica;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaSemanal extends JFrame {

	//no sirve xd
    private Map<String, String> appointments;
    private List<CitaMedica> citasMedicas; // Lista para almacenar las citas médicas
    private JTable table;

    public AgendaSemanal() {
        this.appointments = new HashMap<>();
        this.citasMedicas = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Agenda Semanal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 732);
        setLocationRelativeTo(null);

        String[] daysOfWeek = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] hoursOfDay = {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};

        DefaultTableModel tableModel = new DefaultTableModel(hoursOfDay.length + 1, daysOfWeek.length);
        table = new JTable(tableModel);
        table.setRowHeight(60);

        for (int i = 0; i < daysOfWeek.length; i++) {
            table.setValueAt(daysOfWeek[i], 0, i); // Mostrar nombres de días de la semana en la primera fila
        }

        for (int i = 0; i < hoursOfDay.length; i++) {
            table.setValueAt(hoursOfDay[i], i + 1, 0); // Mostrar horas en la primera columna
            for (int j = 1; j < daysOfWeek.length; j++) {
                String key = hoursOfDay[i] + "_" + (j - 1);
                JTextField appointmentField = new JTextField();
                appointmentField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                appointmentField.setEditable(false);
                appointments.put(key, ""); // Inicialmente sin citas
                tableModel.setValueAt("", i + 1, j); // Valor vacío para mostrar correctamente el editor
            }
        }
        
       for (CitaMedica cita : Clinica.getInstance().getMisCitas()) {
            Date fechaCita = cita.getFecha();
            String horaCita = new SimpleDateFormat("HH:mm").format(fechaCita);
            String diaCita = getDiaCita(fechaCita);

            int row = getHoraRow(horaCita);
            int column = getDiaColumn(diaCita);

            if (row != -1 && column != -1) {
                String citaDetails = cita.getNomPaciente();
                //appointments.put(horaCita + "_" + column, citaDetails);
                tableModel.setValueAt("Hola", row, column); // Mostrar los detalles directamente en la celda
            }
        }
        
        //tableModel.setValueAt("Hola", 3, 3);



        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

   

    // Método para obtener el día de la semana de una fecha
    private String getDiaCita(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(fecha);
    }

    // Método para obtener la fila correspondiente en la tabla según la hora
    private int getHoraRow(String hora) {
        String[] hoursOfDay = {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        for (int i = 0; i < hoursOfDay.length; i++) {
            if (hoursOfDay[i].equals(hora)) {
                return i + 1;
            }
        }
        return -1; // Hora no encontrada
    }

    // Método para obtener la columna correspondiente en la tabla según el día de la cita
    private int getDiaColumn(String dia) {
        String[] daysOfWeek = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equals(dia)) {
                return i;
            }
        }
        return -1; // Día no encontrado
    }


}
