package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<Municipio> municipios;
    RecyclerView recyclerView;
    AdapterMunicipios adapterMunicipios;
    FloatingActionButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterMunicipios = new AdapterMunicipios(this, this);

        recyclerView.setAdapter(adapterMunicipios);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReportsActivity.class));
            }
        });
    }


    @Override
    public void onItemClick(int position) {
        Intent sendIntent = new Intent(MainActivity.this, FullInformation.class);
        Municipio mun = adapterMunicipios.getMunicipio(position);
        sendIntent.putExtra("Municipio", mun);
        startActivity(sendIntent);
    }
}