package view;

import controller.EquiposController;
import model.Dtos.EquipoInfoDto;

import javax.swing.*;
import java.awt.*;

public class DialogEquipo extends JDialog {
    private EquiposController equiposController;
    private PanelDatosEquipo panelInfoEquipo;
    private PanelHistorialPartidos tablaHistorialPartidos;

    public DialogEquipo(long idEquipo) {
        super();
        setSize(650, 300);
        setLayout(new GridLayout(2, 1));
        equiposController = new EquiposController();
        EquipoInfoDto equipo = equiposController.getEquipobyId(idEquipo);
        panelInfoEquipo = new PanelDatosEquipo(equipo);
        tablaHistorialPartidos = new PanelHistorialPartidos(equipo.getIdEquipo());

        addGB(panelInfoEquipo, 0, 0);
        addGB(tablaHistorialPartidos, 0, 1);

        setResizable(false);
    setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addGB(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        add(component, gbc);
    }
}
