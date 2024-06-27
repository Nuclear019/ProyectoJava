package view;

import model.Dtos.JugadorDetallesDto;

import javax.swing.*;
import java.awt.*;

public class PanelInfoJugador extends JPanel {
    private JLabel equipoJugador;
    private JLabel posicionJugador;
    private JLabel alturaJugador;
    private JLabel pesoJugador;
    private JLabel procedenciaJugador;
    private JLabel errorBusquedaJugador;

    public PanelInfoJugador(JugadorDetallesDto jugadorDetallesDto) {
        super();
        setLayout(new GridLayout(5, 1));
        if (jugadorDetallesDto==null    ) {
            errorBusquedaJugador = new JLabel("No se encontraron resultados");
            add(errorBusquedaJugador);
        }
        equipoJugador = new JLabel("Último equipo de la NBA: "+jugadorDetallesDto.getEquipoJugador());
        posicionJugador = new JLabel("Posicion: "+(jugadorDetallesDto.getPosicionJugador()==null?"N/D":jugadorDetallesDto.getPosicionJugador()));
        alturaJugador = new JLabel("Altura: "+jugadorDetallesDto.getAlturaJugador());
        pesoJugador = new JLabel("Peso: "+jugadorDetallesDto.getPesoJugador());
        procedenciaJugador = new JLabel("Procedencia: "+jugadorDetallesDto.getProcedenciaJugador());


        addGB(equipoJugador, 0, 0);
        addGB(posicionJugador, 0, 1);
        addGB(alturaJugador, 0, 2);
        addGB(pesoJugador, 0, 3);
        addGB(procedenciaJugador, 0, 4);


    }
    public void addGB(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        add(component, gbc);
    }
}
