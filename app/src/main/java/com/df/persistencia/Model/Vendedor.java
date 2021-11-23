package com.df.persistencia.Model;

public class Vendedor {

    private String documento;
    private String name;
    private String telefono;

    public Vendedor(String documento, String name, String telefono) {
        this.documento = documento;
        this.name = name;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Vendedor() {

    }
}
