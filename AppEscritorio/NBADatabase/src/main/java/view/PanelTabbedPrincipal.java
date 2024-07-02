package view;

import controller.EquiposController;

import javax.swing.*;

public class PanelTabbedPrincipal extends JTabbedPane {
    private JButton botonBuscarJugador;
    private JButton botonListadoEquipos;
    private EquiposController equiposController;
    private PanelListadoEquipos panelListadoEquipos;
    private PanelBusquedaJugador panelBusquedaJugador;


    public PanelTabbedPrincipal() {
        panelBusquedaJugador = new PanelBusquedaJugador();
        panelListadoEquipos = new PanelListadoEquipos();

        addTab("Buscador Jugadores", panelBusquedaJugador);
        addTab("Listado Equipos", panelListadoEquipos);






    }
}
