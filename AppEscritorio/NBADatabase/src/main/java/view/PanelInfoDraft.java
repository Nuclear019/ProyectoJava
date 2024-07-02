package view;

import model.Classes.Draft;

import javax.swing.*;
import java.awt.*;

public class PanelInfoDraft extends JPanel {
    private JLabel tituloGrid;
    private JLabel fechaDraft;
    private JLabel rondaDraft;
    private JLabel numeroDraft;
    public PanelInfoDraft(Draft draft) {
        super();
        setLayout(new GridLayout(4, 1));

        tituloGrid = new JLabel("Información del Draft:");
        fechaDraft = new JLabel("Año: " + draft.getAnoDraft());
        rondaDraft = new JLabel(draft.getRonda()+"ª ronda");
        numeroDraft = new JLabel("Pick nº " + draft.getNumeroDraft());

        tituloGrid.setFont(new Font("Arial", Font.BOLD, 15));
        addGB(tituloGrid, 0, 0);
        addGB(fechaDraft, 0, 1);
        addGB(rondaDraft, 0, 2);
        addGB(numeroDraft, 0, 3);


    }
    public void addGB(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(component, gbc);
    }
}
