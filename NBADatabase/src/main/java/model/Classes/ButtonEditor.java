package model.Classes;

import view.DialogEquipo;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private JTable table;
    private DialogEquipo frameEquipo;
    public ButtonEditor(JTable table) {
        this.table = table;
        button = new JButton("Haz clic aquí");

        // Agrega un ActionListener al botón para manejar el clic
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRow = table.getValueAt(table.getSelectedRow(), 0).toString();
                if (frameEquipo != null) {
                    frameEquipo.dispose();
                }
                frameEquipo = new DialogEquipo(Integer.parseInt(selectedRow));
                // Notifica al editor que se ha finalizado la edición
                fireEditingStopped();
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        // Este método no se usa realmente, puedes devolver cualquier cosa aquí
        return button.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        return button;
    }

}