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

import org.json.JSONArray;
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

public class AdapterMunicipios extends RecyclerView.Adapter<AdapterMunicipios.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<Municipio> municipios;
    Context context;
    private View.OnClickListener mOnItemClickListener;

    public AdapterMunicipios(Context c, RecyclerViewInterface recyclerViewInterface){
        context = c;
        this.recyclerViewInterface = recyclerViewInterface;
        Init();
    }

    public Municipio getMunicipio(int pos){
        return municipios.get(pos);
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
                Municipio municipi;
                JSONArray jsonArray = new JSONObject(writer.toString()).getJSONObject("result").getJSONArray("records");
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

                    //System.out.println(jsonObject.getString("Municipi"));
                    municipios.add(municipi);
                }
                is.close();
            } catch (IOException | JSONException e) {
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
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //holder.getTextViewMunicipi().setText(String.valueOf(municipios.get(position).getMunicipi()));
        holder.asignarMunicipio(municipios.get(position).getMunicipi());
        holder.asignarCasos(municipios.get(position).getCasosPCR());

    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView municipi;
        private TextView casos;

        public ViewHolder(View view, RecyclerViewInterface recyclerViewInterface) {
            super(view);
            municipi = (TextView) view.findViewById(R.id.municipi);
            casos = (TextView) view.findViewById(R.id.casos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
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
            this.casos.setText(casosPCR.toString());
        }
    }

}
