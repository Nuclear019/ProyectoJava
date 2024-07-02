package view;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {
    PanelTabbedPrincipal panelBotones;
    public FramePrincipal() {
        setTitle("NBA App");
        panelBotones = new PanelTabbedPrincipal();


        add(panelBotones);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        pack();
    }

}
