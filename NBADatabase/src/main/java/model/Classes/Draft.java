package model.Classes;

import java.io.Serializable;

public class Draft implements Serializable {
    private String anoDraft;
    private String rondaDraft;
    private String numeroDraft;

    public Draft() {
    }

    public Draft(String anoDraft, String ronda, String numeroDraft) {
        this.anoDraft = anoDraft;
        this.rondaDraft = ronda;
        this.numeroDraft = numeroDraft;
    }

    public String getAnoDraft() {
        return anoDraft;
    }

    public void setAnoDraft(String anoDraft) {
        this.anoDraft = anoDraft;
    }

    public String getRonda() {
        return rondaDraft;
    }

    public void setRonda(String ronda) {
        this.rondaDraft = ronda;
    }

    public String getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(String numeroDraft) {
        this.numeroDraft = numeroDraft;
    }

    @Override
    public String toString() {
        return "Draft: " + anoDraft + ", " + rondaDraft + "ª ronda, " + numeroDraft + " pick.";
    }
}
