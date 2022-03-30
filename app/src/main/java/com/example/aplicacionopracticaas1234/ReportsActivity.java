package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ReportsActivity extends AppCompatActivity {
    Button reportAddInfo;
    CheckBox fever, cough, shortness, fatigue, muscle, headache, newLoss, sore, congestion, nausea,
            diarrhea, closeContact;
    EditText diagnosticCode, startDate;
    ReportInfo reportInfo;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        reportAddInfo = (Button) findViewById(R.id.buttonAddInfo);
        diagnosticCode = (EditText) findViewById(R.id.editTextDiagnosticCode);
        startDate = (EditText) findViewById(R.id.editTextSimptomStart);
        fever = (CheckBox) findViewById(R.id.checkFever);
        cough = (CheckBox) findViewById(R.id.checkCough);
        shortness = (CheckBox) findViewById(R.id.checkShortness);
        fatigue = (CheckBox) findViewById(R.id.checkFatigue);
        muscle = (CheckBox) findViewById(R.id.checkMuscle);
        headache = (CheckBox) findViewById(R.id.checkHeadache);
        newLoss = (CheckBox) findViewById(R.id.checkLossTaste);
        sore = (CheckBox) findViewById(R.id.checkSore);
        congestion = (CheckBox) findViewById(R.id.checkCongestion);
        nausea = (CheckBox) findViewById(R.id.checkNausea);
        diarrhea = (CheckBox) findViewById(R.id.checkDiarrehea);
        closeContact = (CheckBox) findViewById(R.id.checkCloseContact);

        reportAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reportInfo = new ReportInfo((Integer) Integer.parseInt(String.valueOf(diagnosticCode.getText())) ,
                        String.valueOf(startDate.getText()), fever.isChecked(), cough.isChecked(),
                        shortness.isChecked(), fatigue.isChecked(), muscle.isChecked(), headache.isChecked(),
                        newLoss.isChecked(), sore.isChecked(), congestion.isChecked(), nausea.isChecked(),
                        diarrhea.isChecked(), closeContact.isChecked());

                myDatabase.InsertReport(reportInfo);
            }
        });
    }
}