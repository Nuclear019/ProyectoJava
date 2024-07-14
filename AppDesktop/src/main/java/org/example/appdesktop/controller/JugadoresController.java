package org.example.appdesktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.appdesktop.HelloApplication;
import org.example.appdesktop.model.Daos.JugadorDao;
import org.example.appdesktop.model.EMF;
import org.example.appdesktop.model.Entities.Jugador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class JugadoresController implements Initializable {

    @FXML
    private ComboBox<String> filterSelect;

    @FXML
    private TextField searchInput;

    @FXML
    private VBox rootVBox;

    @FXML
    private GridPane jugadoresContainer;

    @FXML
    private Pagination pagination;

    private JugadorDao jugadoresDao = new JugadorDao(EMF.get().createEntityManager());

    private List<Jugador> jugadores;
    private List<Jugador> filteredJugadores;
    private int itemsPerPage = 12;
    private int currentPageIndex = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Establecer el tamaño uniforme para todas las tarjetas
        jugadoresContainer.setHgap(10);
        jugadoresContainer.setVgap(10);

        // Inicializa el ComboBox con opciones
        filterSelect.getItems().addAll("Nombre", "Equipo");
        filterSelect.getSelectionModel().selectFirst();

        // Listener para el campo de búsqueda
        searchInput.textProperty().addListener((observable, oldValue, newValue) -> buscarJugadores());

        // Cargar jugadores y mostrar la primera página
        jugadores = cargarJugadores();
        filteredJugadores = jugadores;

        // Configurar la paginación
        pagination.setPageCount((int) Math.ceil((double) filteredJugadores.size() / itemsPerPage));

        // Listener para cambiar de página
        pagination.currentPageIndexProperty().addListener((obs, oldValue, newValue) -> {
            currentPageIndex = newValue.intValue();
            actualizarJugadores();
        });

        actualizarJugadores();
    }

    // Método para cargar jugadores (simulación de carga de datos)
    private List<Jugador> cargarJugadores() {
        return jugadoresDao.getAll();
    }

    // Método para realizar la búsqueda de jugadores
    private void buscarJugadores() {
        String criterio = filterSelect.getValue();
        String filtro = searchInput.getText().toLowerCase();

        filteredJugadores = jugadores.stream()
                .filter(jugador -> {
                    if (criterio.equals("Nombre")) {
                        String nombreCompleto = (jugador.getNombre() + " " + jugador.getApellido()).toLowerCase();
                        return nombreCompleto.contains(filtro);
                    } else if (criterio.equals("Equipo")) {
                        return jugador.getIdEquipo().getNombre().toLowerCase().contains(filtro);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        // Actualizar la paginación
        pagination.setPageCount((int) Math.ceil((double) filteredJugadores.size() / itemsPerPage));
        pagination.setCurrentPageIndex(0);
        currentPageIndex = 0;

        actualizarJugadores();
    }

    // Método para actualizar la visualización de los jugadores según la página actual
    private void actualizarJugadores() {
        jugadoresContainer.getChildren().clear(); // Limpiar el GridPane antes de actualizar

        int startIndex = currentPageIndex * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, filteredJugadores.size());

        int colIndex = 0;
        int rowIndex = 0;

        for (int i = startIndex; i < endIndex; i++) {
            Jugador jugador = filteredJugadores.get(i);
            HBox card = createJugadorCard(jugador);

            // Añadir la tarjeta al GridPane en la posición correspondiente
            jugadoresContainer.add(card, colIndex, rowIndex);

            // Actualizar índices para la siguiente tarjeta
            colIndex++;
            if (colIndex == 3) { // 3 tarjetas por fila (ajusta según tus necesidades)
                colIndex = 0;
                rowIndex++;
            }
        }
    }

    // Método para crear una tarjeta de jugador (HBox)
    private HBox createJugadorCard(Jugador jugador) {
        HBox card = new HBox();
        card.getStyleClass().add("card");
        card.setSpacing(10);

        // Imagen del jugador
        ImageView imageView = new ImageView();
        if (jugador.getFoto() != null) {
            Image image = new Image(new ByteArrayInputStream(jugador.getFoto()));
            imageView.setImage(image);
        } else {
            // Si no hay imagen, mostrar una imagen por defecto
            Image defaultImage = new Image(getClass().getResourceAsStream("/img/default.png"));
            imageView.setImage(defaultImage);
        }
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        // Nombre y Apellido
        VBox nombreBox = new VBox();
        nombreBox.setFillWidth(true);
        Text nombreApellido = new Text(jugador.getNombre() + " " + jugador.getApellido());
        nombreApellido.getStyleClass().add("card-title");
        nombreBox.getChildren().add(nombreApellido);

        // Nombre del equipo
        Text nombreEquipo = new Text(jugador.getIdEquipo().getNombre());
        nombreEquipo.getStyleClass().add("card-text");
        nombreBox.getChildren().add(nombreEquipo);

        // Alinear el nombre del equipo al centro
        VBox.setVgrow(nombreBox, Priority.ALWAYS);
        nombreBox.setAlignment(Pos.CENTER_LEFT);

        // Agregar elementos a la tarjeta
        card.getChildren().addAll(imageView, nombreBox);

        // Establecer tamaño fijo para la tarjeta
        card.setMinWidth(200); // Ancho fijo
        card.setPrefHeight(100); // Alto fijo

        // Añadir manejador de eventos para hacer clic en la tarjeta
        card.setOnMouseClicked(event -> {
            try {
                mostrarDetallesJugador(jugador);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return card;
    }

    // Método para mostrar los detalles del jugador
    private void mostrarDetallesJugador(Jugador jugador) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("jugadores/DetalleJugador.fxml"));
        Parent root = loader.load();

        // Obtener el controlador de la vista de detalles y pasarle el jugador
        DetalleJugadorController controller = loader.getController();
        controller.setJugador(jugador);

        // Crear una nueva escena y mostrarla en una nueva ventana
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Detalles del Jugador");
        stage.show();
    }
}
