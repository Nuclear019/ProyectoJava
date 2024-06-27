package view;

import controller.ImagenController;
import model.Classes.Draft;
import model.Dtos.JugadorDetallesDto;
import model.Dtos.JugadorDto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class PanelDetallesJugador extends JPanel {
    private JLabel nombreJugador;
    private JLabel labelImagenJugador;
    private JLabel labelNotFoundImagen;
    private JPanel panelDatosJugador;
    private JPanel panelDraftJugador;
    private JButton botonAñadirImagen;
    private JButton botonEditarImagen;
    ImagenController imagenController;


    public PanelDetallesJugador(JugadorDto jugadorDto) {
        setLayout(new GridLayout(3,2));
        imagenController = new ImagenController();
        JugadorDetallesDto jugadorDetallesDto = new JugadorDetallesDto(jugadorDto.getNombreEquipo(), jugadorDto.getPosicion(), jugadorDto.getAltura(), jugadorDto.getPeso(), jugadorDto.getProcedencia());
        panelDatosJugador = new PanelInfoJugador(jugadorDetallesDto);
        panelDraftJugador = new PanelInfoDraft(new Draft(jugadorDto.getFechaDraft(), jugadorDto.getRondaDraft(), jugadorDto.getNumeroDraft()));
        botonAñadirImagen = new JButton("Añadir imagen");
        labelNotFoundImagen = new JLabel("Imagen no encontrada");
        botonEditarImagen = new JButton("Editar imagen");
        botonAñadirImagen = new JButton("Añadir imagen");
        if (jugadorDto.getImagen() != null) {
            InputStream inputStream = new ByteArrayInputStream(jugadorDto.getImagen());
            try {
                BufferedImage imagen = ImageIO.read(inputStream);
                ImageIcon icono = new ImageIcon(imagen);
                Image image = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(image);
                labelImagenJugador = new JLabel(iconoEscalado);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar la imagen");
            }
        }
        else {


        }

        nombreJugador = new JLabel(jugadorDto.getNombreCompleto());
        nombreJugador.setFont(new Font("Arial", Font.BOLD, 20));


        botonAñadirImagen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File archivo = fileChooser.getSelectedFile();
            if (archivo != null) {
                try {
                    BufferedImage imagen = ImageIO.read(archivo);
                    if (imagen == null) {
                        JOptionPane.showMessageDialog(null, "Debes añadir una imagen JPG o PNG");
                        return;
                    }
                    else {
                        ImageIcon icono = new ImageIcon(imagen.toString());
                        imagenController.addImagenJugador(jugadorDto.getNombreCompleto(), convertirFileABytes(archivo));
                        botonAñadirImagen.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Reinicia la app o pulse de nuevo en buscar para que se cargue la imagen.");

                    }

                } catch (IOException ex) {
                    labelImagenJugador.setText("Error al cargar la imagen");
                }
            }
        });
        botonEditarImagen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File archivo = fileChooser.getSelectedFile();
            if (archivo != null) {
                try {
                    BufferedImage imagen = ImageIO.read(archivo);
                    if (imagen == null) {
                        JOptionPane.showMessageDialog(null, "Debes añadir una imagen JPG o PNG");
                        return;
                    }
                    else {
                        imagenController.replaceImagenJugador(jugadorDto.getNombreCompleto(), convertirFileABytes(archivo));
                        botonEditarImagen.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Reinicia la app o pulse de nuevo en buscar para que se cargue la imagen.");

                    }

                } catch (IOException ex) {
                    labelImagenJugador.setText("Error al cargar la imagen");
                }
            }
        });

        if (jugadorDto.getImagen() != null) {
            addGB(labelImagenJugador,0,0);
            addGB(nombreJugador, 1, 0);
            addGB(panelDatosJugador, 0, 1);
            addGB(panelDraftJugador, 1, 1);
            addGB(botonEditarImagen, 2, 0);
        }
        else {
            addGB(labelNotFoundImagen, 0, 0);
            addGB(nombreJugador, 1, 0);
            addGB(panelDatosJugador, 0, 1);
            addGB(panelDraftJugador, 1, 1);
            addGB(botonAñadirImagen, 2, 0);
        }
        setBounds(20, 20, 400, 400);

    }
    public void addGB(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        add(component, gbc);
    }
    public byte[] getImagenJugador(Byte[] imagen) {
        byte[] bytesConMinuscula = new byte[imagen.length];
        for (int i = 0; i < imagen.length; i++) {
            bytesConMinuscula[i] = imagen[i];
        }
        return bytesConMinuscula;
    }

    public static byte[] convertirFileABytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Leer el contenido del archivo y escribirlo en el ByteArrayOutputStream
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            // Obtener el arreglo de bytes resultante
            return bos.toByteArray();
        }
    }
}
