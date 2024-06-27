package model.Dtos;

public class JugadorDetallesDto {
    private String equipoJugador;
    private String posicionJugador;
    private String alturaJugador;
    private String pesoJugador;
    private String procedenciaJugador;


    public JugadorDetallesDto(String equipoJugador, String posicionJugador, String alturaJugador, String pesoJugador, String procedenciaJugador) {
        this.equipoJugador = equipoJugador;
        this.posicionJugador = posicionJugador;
        this.alturaJugador = alturaJugador;
        this.pesoJugador = pesoJugador;
        this.procedenciaJugador = procedenciaJugador;
    }

    public String getEquipoJugador() {
        return equipoJugador;
    }

    public void setEquipoJugador(String equipoJugador) {
        this.equipoJugador = equipoJugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public String getAlturaJugador() {
        return alturaJugador;
    }

    public void setAlturaJugador(String alturaJugador) {
        this.alturaJugador = alturaJugador;
    }

    public String getPesoJugador() {
        return pesoJugador;
    }

    public void setPesoJugador(String pesoJugador) {
        this.pesoJugador = pesoJugador;
    }

    public String getProcedenciaJugador() {
        return procedenciaJugador;
    }

    public void setProcedenciaJugador(String procedenciaJugador) {
        this.procedenciaJugador = procedenciaJugador;
    }
}
