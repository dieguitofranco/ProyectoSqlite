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
        String vendedor = "vendedor";
    }

    interface ColumnasPersona{
        String documento = "document_person";
        String name = "name_person";
        String edad = "edad_person";
        String email = "email_person";
        String telefono = "telefono_person";
    }

    interface ColumnasVendedor{
        String documento = "document_vendedor";
        String nombre = "name_vendedor";
        String oficina = "oficina_vendedor";
        String telefono = "telefono_vendedor";
    }

}
