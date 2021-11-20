package com.df.persistencia.Views.Activities.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;

public class CrearCarro extends AppCompatActivity implements View.OnClickListener{
    TextView nameCar;
    TextView valor;
    TextView placa;
    TextView modelo;
    TextView color;
    TextView tipoCarro;
    TextView urlImagen;
    TextView propietario;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);
        DisplayMetrics medidas =  new DisplayMetrics();//Describe información general sobre una pantalla
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
        getWindow().setLayout((int) (ancho*0.8), (int)(alto*0.80));

        nameCar = findViewById(R.id.campo_name_car);
        valor = findViewById(R.id.campo_value);
        placa = findViewById(R.id.campo_placa_car);
        modelo = findViewById(R.id.campo_modelo_car);
        color = findViewById(R.id.campo_color_car);
        tipoCarro = findViewById(R.id.campo_tipo_car);
        urlImagen = findViewById(R.id.campo_url_car);
        propietario = findViewById(R.id.campo_owner_car);
        btnAgregar = findViewById(R.id.boton_aceptar);
        btnAgregar.setOnClickListener(this);
        //propietario pdte el spinner
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.boton_aceptar){
            Carro car = new Carro();

            car.setName(nameCar.getText().toString());
            car.setValue(valor.getText().toString());
            car.setPlaca(placa.getText().toString());
            car.setModelo(Integer.parseInt(modelo.getText().toString()));
            car.setColor(color.getText().toString());
            car.setTipo(tipoCarro.getText().toString());
            car.setUrl(urlImagen.getText().toString());
            car.setDocumento(propietario.getText().toString());
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbcar = new dbCarros(db);
            dbcar.insertCar(car);
            Toast.makeText(this, "Ha Carro agregado :  "+
                    car.getDocumento() + car.getName(), Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}