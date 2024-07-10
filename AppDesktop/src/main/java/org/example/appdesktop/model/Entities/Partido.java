package org.example.appdesktop.model.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Partido implements Serializable {
    @Id
    private long idPartido;

    private int idEquipoLocal;

    private int idEquipoVisitante;

    private int periodo;
    private String postemporada;
    private int puntosLocal;
    private int puntosVisitante;
    private int temporada;

    private LocalDate fecha;
    private String estado;
    private String tiempo;

    public Partido() {
    }

    public Partido(Integer idEquipoLocal, Integer idEquipoVisitante, long idPartido, int periodo, String postemporada, int puntosLocal, int puntosVisitante, int temporada, LocalDate fecha, String estado, String tiempo) {
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.idPartido = idPartido;
        this.periodo = periodo;
        this.postemporada = postemporada;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.temporada = temporada;
        this.fecha = fecha;
        this.estado = estado;
        this.tiempo = tiempo;
    }

    public long getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(Integer idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public long getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(Integer idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long idPartido) {
        this.idPartido = idPartido;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getPostemporada() {
        return postemporada;
    }

    public void setPostemporada(String postemporada) {
        this.postemporada = postemporada;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
