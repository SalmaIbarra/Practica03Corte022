package com.example.practica03corte02;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MiAdaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app = (Aplicacion) getApplication();
        recyclerView = findViewById(R.id.recId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        miAdaptador = app.getAdaptador();
        recyclerView.setAdapter(miAdaptador);

        miAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicion = recyclerView.getChildAdapterPosition(v);
                Alumno alumno = miAdaptador.getItem(posicion);
                String nombre = alumno.getNombre();
                Toast.makeText(MainActivity.this, "Se hizo clic en " + nombre, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchview, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                miAdaptador.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }
}