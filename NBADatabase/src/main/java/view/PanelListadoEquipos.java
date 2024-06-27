package view;

import controller.EquiposController;
import model.Classes.ButtonEditor;
import model.Classes.ButtonRenderer;
import model.Classes.EquipoTableModel;
import model.Entities.Equipo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListadoEquipos extends JPanel {

    private JTable equipoTable;
    private DefaultTableModel tableModel;
    private JButton botonInfoEquipo;

    public PanelListadoEquipos() {
        EquiposController equiposController = new EquiposController();
        setLayout(new BorderLayout());


        List<Equipo> equipos = equiposController.buscarEquipos();
        tableModel = new EquipoTableModel(equipos);
        equipoTable = new JTable(tableModel);

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre Completo");
        tableModel.addColumn("Ciudad");
        tableModel.addColumn("");


        equipoTable.setDefaultRenderer(JButton.class,new ButtonRenderer());
        equipoTable.setDefaultEditor(JButton.class, new ButtonEditor(equipoTable));


        JScrollPane scrollPane = new JScrollPane(equipoTable);

        tableModel.setRowCount(0);


        add(scrollPane, BorderLayout.CENTER);

        for (Equipo equipo : equipos) {
            Object[] rowData = {
                    equipo.getIdEquipo(),
                    equipo.getNombreCompleto(),
                    equipo.getCiudad(),
                    ""


            };
            tableModel.addRow(rowData);


        }



        setVisible(true);
    }
}
