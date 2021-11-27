package com.df.persistencia.Model;

public class Vendedor {

    private String documentov;
    private String nombrev;
    private String telefonov;
    private String direccionv;
    private String correov;

    public Vendedor(String documentov, String nombrev, String telefonov, String direccionv, String correov) {
        this.documentov = documentov;
        this.nombrev = nombrev;
        this.telefonov = telefonov;
        this.direccionv = direccionv;
        this.correov = correov;
    }

    public Vendedor() {

    }

    public String getDocumentov() {
        return documentov;
    }

    public void setDocumentov(String documentov) {
        this.documentov = documentov;
    }

    public String getNombrev() {
        return nombrev;
    }

    public void setNombrev(String nombrev) {
        this.nombrev = nombrev;
    }

    public String getTelefonov() {
        return telefonov;
    }

    public void setTelefonov(String telefonov) {
        this.telefonov = telefonov;
    }

    public String getDireccionv() {
        return direccionv;
    }

    public void setDireccionv(String direccionv) {
        this.direccionv = direccionv;
    }

    public String getCorreov() {
        return correov;
    }

    public void setCorreov(String correov) {
        this.correov = correov;
    }
}

