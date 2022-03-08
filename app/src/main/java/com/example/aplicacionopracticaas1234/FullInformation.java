package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FullInformation extends AppCompatActivity {

    private ImageButton buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_information);

        buttonMain = (ImageButton) findViewById(R.id.imageButton);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FullInformation.this, MainActivity.class));
            }
        });
    }
}