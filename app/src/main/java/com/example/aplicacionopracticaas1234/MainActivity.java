package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Municipio> municipios;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        /*
        municipios = new ArrayList<Municipio>();
        Municipio municipio = new Municipio();
        municipio.setMunicipi("HomeSweetAlacama");
        municipio.setCasosPCR(12);
        //for(){}
        municipios.add(municipio);

        municipio.setMunicipi("HomeSaltyAlacama");
        municipio.setCasosPCR(2);
        municipios.add(municipio);
        */

        AdapterMunicipios adapterMunicipios = new AdapterMunicipios(this);

        recyclerView.setAdapter(adapterMunicipios);
    }
}