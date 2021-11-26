package com.df.persistencia.Datos;

public class Estructuras {

    interface ColumnasCarro{
        String id = "id_car";
        String name = "name_car";
        String value = "value_car";
        String placa = "placa_car";
        String modelo = "modelo_car";
        String color = "color_car";
        String tipo = "tipo_car";
        String url = "url_car";
        String documento = "document_owner";
    }

    interface ColumnasPersona{
        String documento = "document_person";
        String name = "name_person";
        String edad = "edad_person";
        String email = "email_person";
        String telefono = "telefono_person";
    }

    interface ColumnasVendedor{
        String documentov = "documento_vendedor";
        String nombrev = "nombre_vendedor";
        String telefonov = "telefono_vendedor";
        String direccionv = "direccion_vendedor";
        String correov = "correo_vendedor";
    }

}
