package model.Entities;

import model.Classes.Draft;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Jugador implements Serializable {
    @Id
    private Long idJugador;
    private String nombre;
    private String apellido;
    private String posicion;
    private String altura;
    private String peso;
    @ManyToOne
    @JoinColumn(name="idEquipo")
    private Equipo idEquipo;

    private byte[] foto;
    private Integer numero;
    private String colegio;
    private String pais;
    @Embedded
    private Draft draft;


    public Jugador() {
    }

    public Jugador(long idJugador, String nombre, String apellido, String posicion, String altura, String peso, Equipo idEquipo, byte[] foto, Integer numero, String colegio, String pais, Draft draft ) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.altura = altura;
        this.peso = peso;
        this.idEquipo = idEquipo;
        this.foto = foto;
        this.numero = numero;
        this.colegio = colegio;
        this.pais = pais;
        this.draft = draft;
    }

    public long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Draft getDraft() {
        return draft;
    }

    public void setDraft(Draft draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return  nombre +" "+ apellido + "("+ numero+"): '" +
                ", position='" + posicion + '\'' +
                ", equipo=" + idEquipo +
                ", country='" + pais + '\'' +
                ", draft=" + draft +
                "\n";
    }


}
