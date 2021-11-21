package com.df.persistencia.Model;

public class Vendedor {
    private String documento;
    private String nombre;
    private String oficina;
    private String telefono;

    public Vendedor(String documento, String nombre, String oficina, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.oficina = oficina;
        this.telefono = telefono;
    }

    public Vendedor() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
