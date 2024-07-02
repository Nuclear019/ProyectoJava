package model.Dtos;

public class PartidoInfoDto {
    private int idPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private String periodo;
    private String postemporada;
    private int puntosLocal;
    private int puntosVisitante;
    private int temporada;
    private String fecha;




    public PartidoInfoDto(int idPartido, String equipoLocal, String equipoVisitante, String periodo, String postemporada, int puntosLocal, int puntosVisitante, int temporada, String fecha) {
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.periodo = periodo;
        this.postemporada = postemporada;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.temporada = temporada;
        this.fecha = fecha;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
