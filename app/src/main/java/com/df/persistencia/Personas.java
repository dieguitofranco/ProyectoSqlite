package com.df.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Personas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button btnCrear;
    private ListView listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        btnCrear = findViewById(R.id.btnCrear);
        listaPersona = findViewById(R.id.lstViewPerson);
        //listaPersona.setAdapter(adapter);
        btnCrear.setOnClickListener(this);
        listaPersona.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrear:
                //intent = new Intent(this,.class);
                //startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado la persona: ", Toast.LENGTH_SHORT).show();
    }
}