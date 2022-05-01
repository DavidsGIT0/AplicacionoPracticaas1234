package com.example.aplicacionopracticaas1234;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "SymptomsReport.db";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Report";
    private static final String COLUMN_DIAGNOSTIC_ID= "_id";
    private static final String COLUMN_DIAGNOSTIC_CODE = "diagnostic_code";
    private static final String COLUMN_SYMPTOM_START = "symptom_start";
    private static final String COLUMN_SYMPTOM_FEVER = "symptom_fever";
    private static final String COLUMN_SYMPTOM_COUGH = "symptom_cough";
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
    private static final String COLUMN_MUNICIPIO = "municipio";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_DIAGNOSTIC_ID + " integer primary key autoincrement,"+
                        COLUMN_DIAGNOSTIC_CODE + " integer,"+
                        COLUMN_SYMPTOM_START + "  text," +
                        COLUMN_SYMPTOM_FEVER + " integer," +
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
                        COLUMN_CLOSE_CONTACT +  " integer,"+
                        COLUMN_MUNICIPIO + " integer);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void InsertReport(ReportInfo reportInfo){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DIAGNOSTIC_CODE, this.getId());
        contentValues.put(COLUMN_SYMPTOM_START, reportInfo.getStartDate());
        contentValues.put(COLUMN_SYMPTOM_FEVER, reportInfo.getFever() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_COUGH, reportInfo.getCough() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_SHORTNESS, reportInfo.getSore() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_FATIGUE, reportInfo.getFatigue() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_MUSCLE, reportInfo.getMuscle() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_HEADACHE, reportInfo.getHeadache() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_LOSS_TASTE, reportInfo.getNewLoss() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_SORE, reportInfo.getSore() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_CONGESTION, reportInfo.getCongestion() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_NAUSEA, reportInfo.getNausea() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_DIARRHEA, reportInfo.getDiarrhea() ? 1 : 0);
        contentValues.put(COLUMN_CLOSE_CONTACT, reportInfo.getCloseContact() ? 1 : 0);
        contentValues.put(COLUMN_MUNICIPIO, reportInfo.getMunicipio());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }
    private int getId(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("Select MAX(_id) from " + TABLE_NAME, null);
        c.moveToFirst();
        int maxId = c.getInt(0) +1;
        return maxId;
    }
    public int getDiagnosticCode(){
        return  this.getId();
    }

    public void UpdateReport(ReportInfo reportInfo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SYMPTOM_START, reportInfo.getStartDate());
        contentValues.put(COLUMN_SYMPTOM_FEVER, reportInfo.getFever() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_COUGH, reportInfo.getCough() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_SHORTNESS, reportInfo.getSore() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_FATIGUE, reportInfo.getFatigue() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_MUSCLE, reportInfo.getMuscle() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_HEADACHE, reportInfo.getHeadache() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_LOSS_TASTE, reportInfo.getNewLoss() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_SORE, reportInfo.getSore() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_CONGESTION, reportInfo.getCongestion() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_NAUSEA, reportInfo.getNausea() ? 1 : 0);
        contentValues.put(COLUMN_SYMPTOM_DIARRHEA, reportInfo.getDiarrhea() ? 1 : 0);
        contentValues.put(COLUMN_CLOSE_CONTACT, reportInfo.getCloseContact() ? 1 : 0);
        String [] args = new String []{String.valueOf(reportInfo.getDiagnosticCode())};
        sqLiteDatabase.update(TABLE_NAME,contentValues,"diagnostic_code=?", args);
        sqLiteDatabase.close();
    }

    public void DeleteReport(ReportInfo reportInfo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String [] args = new String []{String.valueOf(reportInfo.getDiagnosticCode())};
        sqLiteDatabase.delete(TABLE_NAME,"diagnostic_code=?", args);
        sqLiteDatabase.close();

    }

    public ArrayList<ReportIdDate> FindReportsByMunicipality(String mun){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String[] parametros = {mun};
        String[] campos={COLUMN_DIAGNOSTIC_ID, COLUMN_SYMPTOM_START};
        Cursor c = sqLiteDatabase.query(TABLE_NAME, campos, COLUMN_MUNICIPIO+"=?", parametros, null,null,null);
        ReportIdDate report = new ReportIdDate();
        ArrayList<ReportIdDate> reportList = new ArrayList<>();

        c.moveToFirst();
        while (!c.isAfterLast()) {
            report.setId(c.getString(0));
            System.out.println("ID = " + c.getString(0));
            report.setDate(c.getString(1));
            System.out.println("DATE = " + c.getString(1));
            reportList.add(report);
            report = new ReportIdDate();
            c.moveToNext();
        }
        return reportList;
    }
}
