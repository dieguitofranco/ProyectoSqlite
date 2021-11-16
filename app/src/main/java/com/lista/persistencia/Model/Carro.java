package com.lista.persistencia.Model;

public class Carro {
    private String id;
    private String name;
    private String value;
    private String placa;
    private int modelo;
    private String color;
    private String tipo;
    private String url = "";
    private String documento;




    public Carro(String id, String name, String value, String placa, int modelo, String color, String tipo, String url, String documento) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.url = url;
        this.documento = documento;
    }

    public Carro() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}