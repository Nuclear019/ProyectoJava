package org.example.appdesktop.model.Entities;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "Imagen_SEQ", sequenceName = "Imagen_SEQ", allocationSize = 1)
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idImagen;
    @OneToOne
    @JoinColumn(name = "idJugador")
    private Jugador idJugador;
    private String descripcion;

    private String url;
    @Column(name = "IMAGEN",nullable = true)
    @Lob
    private byte[] imagen;

    public Imagen(long idImagen, Jugador idJugador, String descripcion, String url, byte[] imagen) {
        this.idImagen = idImagen;
        this.idJugador = idJugador;
        this.descripcion = descripcion;
        this.url = url;
        this.imagen = imagen;
    }

    public Imagen(Jugador idJugador, String descripcion, String url, byte[] imagen) {
        this.idJugador = idJugador;
        this.descripcion = descripcion;
        this.url = url;
        this.imagen = imagen;
    }

    public Imagen() {

    }

    public long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(long idImagen) {
        this.idImagen = idImagen;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
