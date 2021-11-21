package com.df.persistencia.Model;

public class Vendedor {

    private String documentoV;
    private String nameV;
    private String emailV;
    private String telefonoV;

    public Vendedor(String documentoV, String nameV, String emailV, String telefonoV) {
        this.documentoV = documentoV;
        this.nameV = nameV;
        this.emailV = emailV;
        this.telefonoV = telefonoV;
    }

    public Vendedor() {

    }

    public String getDocumentoV() {
        return documentoV;
    }

    public void setDocumentoV(String documentoV) {
        this.documentoV = documentoV;
    }

    public String getNameV() {
        return nameV;
    }

    public void setNameV(String nameV) {
        this.nameV = nameV;
    }

    public String getEmailV() {
        return emailV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public String getTelefonoV() {
        return telefonoV;
    }

    public void setTelefonoV(String telefonoV) {
        this.telefonoV = telefonoV;
    }
}
