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

    }

    interface ColumnasPersona{
        String documento = "document_person";
        String name = "name_person";
        String edad = "edad_person";
        String email = "email_person";
        String telefono = "telefono_person";
    }

    interface ColumnasVendedor{
        String documento = "document_vendor";
        String name = "name_vendor";
        String email = "email_vendor";
        String telefono = "telefono_vendor";
    }

}
