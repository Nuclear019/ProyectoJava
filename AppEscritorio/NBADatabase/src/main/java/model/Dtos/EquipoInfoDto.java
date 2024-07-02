package model.Dtos;

import model.Entities.Partido;

import java.util.List;

public class EquipoInfoDto {
    private long idEquipo;
    private String nombreCompleto;
    private String abreviatura;
    private String nombre;
    private String ciudad;
    private String conferencia;
    private String division;
    private List<Partido> partidos;

    public EquipoInfoDto(long idEquipo, String nombreCompleto, String abreviatura, String nombre, String ciudad, String conferencia, String division, List<Partido> partidos) {
        this.idEquipo = idEquipo;
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.partidos = partidos;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
