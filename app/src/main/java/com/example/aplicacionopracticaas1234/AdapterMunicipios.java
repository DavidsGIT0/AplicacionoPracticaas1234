package com.example.aplicacionopracticaas1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class AdapterMunicipios extends
        RecyclerView.Adapter<AdapterMunicipios.ViewHolder> {
    private ArrayList<Municipio> municipios;
    Context context;

    public AdapterMunicipios(Context c, ArrayList<Municipio> municipios){
        this.municipios = municipios;
        context = c;
        Init();
    }
    public void Init() {
        municipios=new ArrayList<Municipio>();
        InputStream is = context.getResources().openRawResource(R.raw.coviddata);
        Writer writer = new StringWriter();

        JSONObject json;
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);}
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                String jsonS = new String(buffer);
                //json = new JSONObject(jsonS);

                System.out.println("AAAAAAAAAAAA"+jsonS);
                //System.out.println(json.getJSONObject("records").getString("Municipi"));
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //The String writer.toString() must be parsed in the municipalities ArrayList by
        //using JSONArray and JSONObject
    }

    @Override
    public int getItemCount() {
        return municipios.size();
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listamunicipiosview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //holder.getTextViewMunicipi().setText(String.valueOf(municipios.get(position).getMunicipi()));
        holder.asignarMunicipio(municipios.get(position).getMunicipi());
       //holder.asignarCasos(municipios.get(position).getCasosPCR());

    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView municipi;
        private TextView casos;

        public ViewHolder(View view) {
            super(view);
            municipi = (TextView) view.findViewById(R.id.municipi);
            casos = (TextView) view.findViewById(R.id.casos);
        }
        public TextView getTextViewMunicipi() {
            return municipi;
        }
        public TextView getTextViewCasos() {
            return casos;
        }

        public void asignarMunicipio(String municipi) {
            this.municipi.setText(municipi);
        }

        public void asignarCasos(Integer casosPCR) {
            this.casos.setText(casosPCR);
        }
    }
}
