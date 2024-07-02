package view;

import controller.EquiposController;
import controller.PartidoController;
import model.Classes.EquipoTableModel;
import model.Classes.PartidoTableModel;
import model.Daos.EquipoDao;
import model.Daos.PartidoDao;
import model.Dtos.PartidoInfoDto;
import model.EMF;
import model.Entities.Equipo;
import model.Entities.Partido;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelHistorialPartidos extends JPanel {
    private EquiposController equiposController;
    private PartidoController partidoController;
    private PartidoTableModel tableModel;
    private JTable partidoTable;
    public PanelHistorialPartidos(long idEquipo) {
        super();
        equiposController = new EquiposController();
        partidoController = new PartidoController();
        List<PartidoInfoDto> partidos = partidoController.buscarPartidos(idEquipo);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Historial de partidos");

        tableModel = new PartidoTableModel(partidos);
        partidoTable = new JTable(tableModel);

        tableModel.addColumn("Equipo Local");
        tableModel.addColumn("Puntos Local");
        tableModel.addColumn("Equipo Visitante");
        tableModel.addColumn("Puntos Visitante");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Temporada");



        for (PartidoInfoDto partido : partidos) {
            EquipoDao equipoDao = new EquipoDao(EMF.get().createEntityManager());


            Object[] rowData = {
                    partido.getEquipoLocal(),
                    partido.getPuntosLocal(),
                    partido.getEquipoVisitante(),
                    partido.getPuntosVisitante(),
                    partido.getFecha(),
                    partido.getTemporada(),

            };
            tableModel.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(partidoTable);


        scrollPane.setPreferredSize(new Dimension(400, 550));

        add(label);
        add(scrollPane);

    }
}
