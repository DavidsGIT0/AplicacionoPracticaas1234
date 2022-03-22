package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FullInformation extends AppCompatActivity {

    private ImageButton buttonMain;
    private TextView fMunicipi;
    private TextView fId;
    private TextView fDefuncions;
    private TextView fTaxaDefuncions;
    private TextView fAcumulada;
    private TextView fCasos14;
    private TextView fAcumulada14;
    private TextView fCasos;
    private TextView fCodMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_information);

        fMunicipi = findViewById(R.id.fMunicipi);
        fId = findViewById(R.id.fId);
        fDefuncions = findViewById(R.id.fDefuncions);
        fTaxaDefuncions = findViewById(R.id.fTaxaDefuncions);
        fAcumulada = findViewById(R.id.fAcumulada);
        fCasos14 = findViewById(R.id.fCasos14);
        fAcumulada14 = findViewById(R.id.fAcumulada14);
        fCasos = findViewById(R.id.fCasos);
        fCodMunicipio = findViewById(R.id.fCodMunicipio);

        buttonMain = (ImageButton) findViewById(R.id.imageButton);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FullInformation.this, MainActivity.class));
            }
        });

        Intent i = getIntent();
        Municipio municipio = (Municipio) i.getSerializableExtra("Municipio");

        System.out.println("Mun "+municipio.getMunicipi());

        fMunicipi.setText(municipio.getMunicipi());
        fId.setText("" + municipio.getId());
        fDefuncions.setText(""+municipio.getDefuncions());
        fTaxaDefuncions.setText(municipio.getTaxa_defuncio());
        fAcumulada.setText(municipio.getIncidencia_acumulada());
        fCasos14.setText(""+municipio.getCasosPCR_14());
        fAcumulada14.setText(municipio.getIncidencia_acumulada_14());
        fCasos.setText(""+municipio.getCasosPCR());
        fCodMunicipio.setText(""+municipio.getCodMuncipio());


    }
}