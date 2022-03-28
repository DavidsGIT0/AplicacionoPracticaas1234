package com.example.aplicacionopracticaas1234;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "SymptomsReport.db";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Report";
    private static final String COLUMN_DIAGNOSTIC_CODE = "diagnostic_code";
    private static final String COLUMN_SYMPTOM_START = "symptom_start";
    private static final String COLUMN_SYMPTOM_FEVER = "symptom_fever";
    private static final String COLUMN_SYMPTOM_COUGH= "symptom_cough";
    private static final String COLUMN_SYMPTOM_SHORTNESS = "symptom_shortness";
    private static final String COLUMN_SYMPTOM_FATIGUE = "symptom_fatige";
    private static final String COLUMN_SYMPTOM_MUSCLE = "symptom_muscle";
    private static final String COLUMN_SYMPTOM_HEADACHE = "symptom_headache";
    private static final String COLUMN_SYMPTOM_LOSS_TASTE = "symptom_lost_taste";
    private static final String COLUMN_SYMPTOM_SORE = "symptom_sore";
    private static final String COLUMN_SYMPTOM_CONGESTION = "symptom_congestion";
    private static final String COLUMN_SYMPTOM_NAUSEA = "symptom_nausea";
    private static final String COLUMN_SYMPTOM_DIARRHEA = "symptom_diarrhea";
    private static final String COLUMN_CLOSE_CONTACT = "close_contact";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_DIAGNOSTIC_CODE + " integer primary key autoincrement,"+
                        COLUMN_SYMPTOM_START + "  text," +
                        COLUMN_SYMPTOM_FEVER + " integer," +
                        COLUMN_CLOSE_CONTACT + " integer,"+
                        COLUMN_SYMPTOM_COUGH + " integer," +
                        COLUMN_SYMPTOM_SHORTNESS + " integer," +
                        COLUMN_SYMPTOM_FATIGUE +  " integer," +
                        COLUMN_SYMPTOM_MUSCLE + " integer," +
                        COLUMN_SYMPTOM_HEADACHE + " integer," +
                        COLUMN_SYMPTOM_LOSS_TASTE + " integer," +
                        COLUMN_SYMPTOM_SORE + " integer," +
                        COLUMN_SYMPTOM_CONGESTION + " integer," +
                        COLUMN_SYMPTOM_NAUSEA + " integer," +
                        COLUMN_SYMPTOM_DIARRHEA + " integer," +
                        COLUMN_CLOSE_CONTACT +  " integer);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
