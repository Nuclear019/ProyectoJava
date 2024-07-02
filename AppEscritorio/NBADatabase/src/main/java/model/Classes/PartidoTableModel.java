
package model.Classes;

import jakarta.persistence.EntityManager;
import model.Daos.EquipoDao;
import model.Dtos.PartidoInfoDto;
import model.EMF;
import model.Entities.Equipo;
import model.Entities.Partido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PartidoTableModel extends DefaultTableModel {
    List<PartidoInfoDto> partidoList;
    EquipoDao   equipoDao;
    public PartidoTableModel(List<PartidoInfoDto> partidoList) {
        super();
        this.partidoList = partidoList;

    }

    @Override
    public boolean isCellEditable(int row, int column) {

        return false;
    }




    public void setCellEditable(int row, int col, boolean value) {

    }

    @Override
    public Object getValueAt(int row, int column) {
        PartidoInfoDto partido = partidoList.get(row);

        Object value;
        switch (column) {
            case 0:
                value = String.valueOf(partido.getEquipoLocal());
                break;
            case 1:
                value = String.valueOf(partido.getPuntosLocal());
                break;
            case 2:
                value = String.valueOf(partido.getEquipoVisitante());
                break;
            case 3:
                value = String.valueOf(partido.getPuntosVisitante());
                break;
            case 4:
                value = String.valueOf(partido.getFecha());
                break;
            case 5:
                value ="Temporada"+ partido.getTemporada();
                break;
            default:
                throw new AssertionError();
        }
        return value;
    }
    public Class<?> getColumnClass(int columnIndex) {
        Class clase = super.getColumnClass(columnIndex);

        return clase;
    }


}