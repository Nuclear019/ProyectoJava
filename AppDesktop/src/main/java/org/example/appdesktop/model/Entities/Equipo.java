package org.example.appdesktop.model.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Equipo implements Serializable {
    @Id
    private Long idEquipo;
    private String abreviatura;
    private String ciudad;
    private String conferencia;
    @JoinColumn(name = "división")
    private String division;
    private String nombreCompleto;
    private String nombre;

    public Equipo() {
    }

    public Equipo(long id, String abbreviation, String city, String conference, String division, String full_name, String name) {
        this.idEquipo = id;
        this.abreviatura = abbreviation;
        this.ciudad = city;
        this.conferencia = conference; // Fix: Assign the 'conference' parameter to the 'conferencia' field
        this.division = division;
        this.nombreCompleto = full_name;
        this.nombre = name;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombreCompleto+"("+abreviatura+"): "+ciudad+"\n";
    }
}
