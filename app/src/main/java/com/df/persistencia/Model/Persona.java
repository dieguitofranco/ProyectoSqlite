package com.df.persistencia.Model;

public class Persona {
    private String documento;
    private String name;
    private int edad;
    private String email;
    private String telefono;

    public Persona(String documento, String name, int edad, String email, String telefono) {

        this.documento = documento;
        this.name = name;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona() {

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
