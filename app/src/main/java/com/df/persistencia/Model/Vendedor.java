package com.df.persistencia.Model;

public class Vendedor {
    private String id;
    private String id_carro;
    private String documento;

    public Vendedor(String id, String id_carro, String documento) {
        this.id = id;
        this.id_carro = id_carro;
        this.documento = documento;
    }

    public Vendedor() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_carro() {
        return id_carro;
    }

    public void setId_carro(String id_carro) {
        this.id_carro = id_carro;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
