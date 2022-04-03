package com.example.aplicacionopracticaas1234;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReportsActivity extends AppCompatActivity {
    Button reportAddInfo;
    CheckBox fever, cough, shortness, fatigue, muscle, headache, newLoss, sore, congestion, nausea,
            diarrhea, closeContact;
    EditText startDate;
    TextView diagnosticCode;
    ReportInfo reportInfo ;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        reportAddInfo = (Button) findViewById(R.id.buttonAddInfo);
        diagnosticCode = (TextView) findViewById(R.id.editTextDiagnosticCode);
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

        reportInfo = new ReportInfo();
        myDatabase = new MyDatabase(this);
        diagnosticCode.setText(myDatabase.getDiagnosticCode()+"");
        reportAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(startDate.getText())){
                    startDate.setError("Es necesario introducir una fecha \n dd-mm-yyyy");
                }
                else {
                    reportInfo = new ReportInfo(
                            String.valueOf(startDate.getText()), fever.isChecked(), cough.isChecked(),
                            shortness.isChecked(), fatigue.isChecked(), muscle.isChecked(), headache.isChecked(),
                            newLoss.isChecked(), sore.isChecked(), congestion.isChecked(), nausea.isChecked(),
                            diarrhea.isChecked(), closeContact.isChecked());

                     myDatabase.InsertReport(reportInfo);

                    Toast.makeText(ReportsActivity.this, "Reporte añadido a la bases de datos", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(ReportsActivity.this, MainActivity.class));
                }
            }
        });
    }
}