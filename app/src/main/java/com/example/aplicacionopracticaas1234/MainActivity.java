package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {


    ArrayList<Municipio> municipios;
    RecyclerView recyclerView;
    AdapterMunicipios adapterMunicipios;
    FloatingActionButton addButton;
    HTTPConnector httpConnector;
    Municipio municipi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpConnector = new HTTPConnector();
        try {

            municipios=new ArrayList<Municipio>();
            String response = httpConnector.execute().get();
            JSONArray jsonArray = new JSONObject(response.toString()).getJSONObject("result").getJSONArray("records");
            for(int i = 0; i < jsonArray.length(); i++){
                municipi = new Municipio();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                municipi.setId(Long.parseLong(jsonObject.getString("_id")));
                municipi.setCodMuncipio(Long.parseLong(jsonObject.getString("CodMunicipio")));
                municipi.setMunicipi(jsonObject.getString("Municipi"));
                municipi.setCasosPCR(Integer.parseInt(jsonObject.getString("Casos PCR+")));
                municipi.setIncidencia_acumulada(jsonObject.getString("Incidència acumulada PCR+"));
                municipi.setCasosPCR_14(Integer.parseInt(jsonObject.getString("Casos PCR+ 14 dies")));
                municipi.setIncidencia_acumulada_14(jsonObject.getString("Incidència acumulada PCR+14"));
                municipi.setDefuncions(Long.parseLong(jsonObject.getString("Defuncions")));
                municipi.setTaxa_defuncio(jsonObject.getString("Taxa de defunció"));
                municipios.add(municipi);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterMunicipios = new AdapterMunicipios(this, this,municipios);
        recyclerView.setAdapter(adapterMunicipios);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
                intent.putExtra("cod_municipio", "");
                startActivity(intent);
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
