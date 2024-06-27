package model.Classes;

import model.Entities.Equipo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EquipoTableModel extends DefaultTableModel {
    List<Equipo> equipoList;
    public EquipoTableModel(List<Equipo> equipoList) {
        super();
        this.equipoList = equipoList;

    }

    @Override
    public boolean isCellEditable(int row, int column) {

        return column == 3;
    }




    public void setCellEditable(int row, int col, boolean value) {

    }

    // Implementar el método setValueAt
    @Override
    public Object getValueAt(int row, int column) {
        Equipo equipo = equipoList.get(row);

        Object value;
        switch (column) {
            case 0:
                value = String.valueOf(equipo.getIdEquipo());
                break;
            case 1:
                value = String.valueOf(equipo.getNombreCompleto());
                break;
            case 2:
                value = String.valueOf(equipo.getCiudad());
                break;
            case 3:
                value = "Más Info";
                break;

            default:
                throw new AssertionError();
        }
        return value;
    }
    public Class<?> getColumnClass(int columnIndex) {
        Class clase;
        if (columnIndex == 3) {
            clase = JButton.class;
        }
        else {
            clase = super.getColumnClass(columnIndex);
        }
        return clase;
    }


}