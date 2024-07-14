package org.example.appdesktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.example.appdesktop.model.Daos.JugadorDao;
import org.example.appdesktop.model.EMF;
import org.example.appdesktop.model.Entities.Jugador;

import jakarta.persistence.EntityManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetalleJugadorController implements Initializable {

    @FXML
    private ImageView jugadorFoto;

    @FXML
    private Text jugadorNombre;

    @FXML
    private Text jugadorApellido;

    @FXML
    private Text jugadorPosicion;

    @FXML
    private Text jugadorAltura;

    @FXML
    private Text jugadorPeso;

    @FXML
    private Text jugadorAnoDraft;

    @FXML
    private Text jugadorRondaDraft;

    @FXML
    private Text jugadorNumeroDraft;

    @FXML
    private TextField jugadorNombreField;

    @FXML
    private TextField jugadorApellidoField;

    @FXML
    private TextField jugadorPosicionField;

    @FXML
    private TextField jugadorAlturaField;

    @FXML
    private TextField jugadorPesoField;

    @FXML
    private Button editImageButton;

    @FXML
    private Button confirmButton;

    @FXML
    private Button editJugadorButton;

    @FXML
    private Button editAnoDraftButton;

    @FXML
    private Button editRondaDraftButton;

    @FXML
    private Button editNumeroDraftButton;

    private Jugador jugador;

    private JugadorDao jugadorDao = new JugadorDao(EMF.get().createEntityManager());

    private String originalNombre;
    private String originalApellido;
    private String originalPosicion;
    private String originalAltura;
    private String originalPeso;
    private byte[] originalFoto;
    private String originalAnoDraft;
    private String originalRondaDraft;
    private String originalNumeroDraft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editJugadorButton.setOnAction(event -> toggleEditMode());
        editImageButton.setOnAction(event -> editarImagen());
        editAnoDraftButton.setOnAction(event -> toggleEditMode());
        editRondaDraftButton.setOnAction(event -> toggleEditMode());
        editNumeroDraftButton.setOnAction(event -> toggleEditMode());
        confirmButton.setOnAction(event -> guardarCambios());
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
        actualizarDetallesJugador();
    }

    private void actualizarDetallesJugador() {
        if (jugador.getFoto() != null) {
            Image image = new Image(new ByteArrayInputStream(jugador.getFoto()));
            jugadorFoto.setImage(image);
        } else {
            Image defaultImage = new Image(getClass().getResourceAsStream("/img/default.png"));
            jugadorFoto.setImage(defaultImage);
        }
        jugadorNombre.setText(jugador.getNombre());
        jugadorApellido.setText(jugador.getApellido());
        jugadorPosicion.setText(jugador.getPosicion());
        jugadorAltura.setText(jugador.getAltura());
        jugadorPeso.setText(jugador.getPeso());
        jugadorAnoDraft.setText(jugador.getDraft().getAnoDraft());
        jugadorRondaDraft.setText(jugador.getDraft().getRonda());
        jugadorNumeroDraft.setText(jugador.getDraft().getNumeroDraft());

        // Mostrar los campos de texto en modo de edición
        jugadorNombreField.setText(jugador.getNombre());
        jugadorApellidoField.setText(jugador.getApellido());
        jugadorPosicionField.setText(jugador.getPosicion());
        jugadorAlturaField.setText(jugador.getAltura());
        jugadorPesoField.setText(jugador.getPeso());
        jugadorAnoDraft.setText(jugador.getDraft().getAnoDraft());
        jugadorRondaDraft.setText(jugador.getDraft().getRonda());
        jugadorNumeroDraft.setText(jugador.getDraft().getNumeroDraft());
    }

    private void editarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(jugadorFoto.getScene().getWindow());
        if (selectedFile != null) {
            try (FileInputStream fis = new FileInputStream(selectedFile)) {
                byte[] imageBytes = fis.readAllBytes();
                jugador.setFoto(imageBytes);
                actualizarDetallesJugador();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void toggleEditMode() {
        boolean editing = !confirmButton.isVisible();
        editImageButton.setVisible(editing);
        editJugadorButton.setText(editing ? "Cancelar" : "Editar Jugador");
        confirmButton.setVisible(editing);

        // Mostrar u ocultar los campos de texto según el modo de edición
        jugadorNombre.setVisible(!editing);
        jugadorApellido.setVisible(!editing);
        jugadorPosicion.setVisible(!editing);
        jugadorAltura.setVisible(!editing);
        jugadorPeso.setVisible(!editing);
        jugadorAnoDraft.setVisible(!editing);
        jugadorRondaDraft.setVisible(!editing);
        jugadorNumeroDraft.setVisible(!editing);

        jugadorNombreField.setVisible(editing);
        jugadorApellidoField.setVisible(editing);
        jugadorPosicionField.setVisible(editing);
        jugadorAlturaField.setVisible(editing);
        jugadorPesoField.setVisible(editing);
        jugadorAnoDraft.setVisible(editing);
        jugadorRondaDraft.setVisible(editing);
        jugadorNumeroDraft.setVisible(editing);

        if (editing) {
            saveOriginalValues();
        } else {
            restoreOriginalValues();
        }
    }

    private void saveOriginalValues() {
        originalNombre = jugador.getNombre();
        originalApellido = jugador.getApellido();
        originalPosicion = jugador.getPosicion();
        originalAltura = jugador.getAltura();
        originalPeso = jugador.getPeso();
        originalFoto = jugador.getFoto();
        originalAnoDraft = jugador.getDraft().getAnoDraft();
        originalRondaDraft = jugador.getDraft().getRonda();
        originalNumeroDraft = jugador.getDraft().getNumeroDraft();
    }

    private void restoreOriginalValues() {
        jugador.setNombre(originalNombre);
        jugador.setApellido(originalApellido);
        jugador.setPosicion(originalPosicion);
        jugador.setAltura(originalAltura);
        jugador.setPeso(originalPeso);
        jugador.setFoto(originalFoto);
        jugador.getDraft().setAnoDraft(originalAnoDraft);
        jugador.getDraft().setRonda(originalRondaDraft);
        jugador.getDraft().setNumeroDraft(originalNumeroDraft);
        actualizarDetallesJugador();
    }

    private void guardarCambios() {
        jugador.setFoto(jugadorFoto.getImage().getUrl().getBytes());
        jugador.setNombre(jugadorNombreField.getText());
        jugador.setApellido(jugadorApellidoField.getText());
        jugador.setPosicion(jugadorPosicionField.getText());
        jugador.setAltura(jugadorAlturaField.getText());
        jugador.setPeso(jugadorPesoField.getText());
        jugador.getDraft().setAnoDraft(jugadorAnoDraft.getText());
        jugador.getDraft().setRonda(jugadorRondaDraft.getText());
        jugador.getDraft().setNumeroDraft(jugadorNumeroDraft.getText());


            jugadorDao.update(jugador);


        toggleEditMode();
    }
}
