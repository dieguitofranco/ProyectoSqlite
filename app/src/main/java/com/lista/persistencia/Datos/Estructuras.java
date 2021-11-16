package com.lista.persistencia.Datos;

public class Estructuras {
    interface ColumnasCarro{
        String id = "id_car";
        String name = "name_car";
        String value = "value_car";
        String placa = "placa_car";
        String modelo = "modelo_car";
        String color = "color_car";
        String url = "url_car";
        String tipo = "tipo_car";

        String documento = "document_car";

    }

    interface  ColumnasPersona{
        String documento = "documento_persona";
        String name = "name_persona";
        String edad = "edad_persona";
        String email = "email_persona";
        String telefono = "telefono_persona";
    }
}
