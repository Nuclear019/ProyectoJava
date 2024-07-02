package view;

import controller.EquiposController;
import model.Dtos.EquipoInfoDto;
import model.Entities.Equipo;

import javax.swing.*;
import java.awt.*;

public class PanelDatosEquipo extends JPanel {
    private JLabel labelNombreEquipo;
    private JLabel labelNombreCorto;
    private JLabel labelCiudad;
    private JLabel labelConferecia;
    private JLabel labelDivision;

    public PanelDatosEquipo(EquipoInfoDto equipo) {
        setLayout(new GridLayout(5,1));
        labelNombreEquipo = new JLabel(equipo.getNombreCompleto()+"("+equipo.getAbreviatura()+")");
        labelNombreCorto = new JLabel(equipo.getNombre());
        labelCiudad = new JLabel("Ciudad: "+equipo.getCiudad());
        labelConferecia = new JLabel("Conferencia: "+equipo.getConferencia());
        labelDivision = new JLabel("División: "+equipo.getDivision());



        labelNombreEquipo.setFont(new Font("Arial", Font.BOLD, 30));
        labelNombreCorto.setFont(new Font("Arial", Font.ITALIC, 14));



        addGB(labelNombreEquipo, 0, 0);
        addGB(labelNombreCorto, 0, 1);
        addGB(labelCiudad, 0, 2);
        addGB(labelConferecia, 0, 3);
        addGB(labelDivision, 0, 4);


    }

    public void addGB(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        add(component, gbc);
    }
}
