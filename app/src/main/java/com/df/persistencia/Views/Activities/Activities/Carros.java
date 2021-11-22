package com.df.persistencia.Views.Activities.Activities;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.df.persistencia.Datos.BaseDatosCarros;
        import com.df.persistencia.Datos.dbCarros;
        import com.df.persistencia.Model.Carro;
        import com.df.persistencia.R;
        //import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;
        import com.df.persistencia.Views.Activities.Adapters.CarroAdaptador;

        import java.util.ArrayList;

public class Carros extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCrear;
    private ListView listaCarro;
    dbCarros dbc;
    ArrayList<Carro> carros;
    CarroAdaptador carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        btnCrear = findViewById(R.id.btnCrearI);
        listaCarro = findViewById(R.id.lstViewCarI);
        btnCrear.setOnClickListener(this);
        listaCarro.setOnItemClickListener(this);
        listaCarro.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElements();
    }

    public void updateElements(){
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbc = new dbCarros(db);
        carros =dbc.obtenerCarros();
        carAdapter = new CarroAdaptador(this,carros);
        listaCarro.setAdapter(carAdapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrearI:
                intent = new Intent(this, FormularioAuto.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el carro: ", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbc.deleteCarro(carros.get(position).getDocumento());
        updateElements();
        return false;
    }
}