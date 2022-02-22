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

import java.util.ArrayList;

public class AdapterMunicipios extends
        RecyclerView.Adapter<AdapterMunicipios.ViewHolder> {
    private ArrayList<Municipio> municipios;
    Context context;
    public AdapterMunicipios(){}
    public AdapterMunicipios(Context c)
    {
        context=c;
        Init();
    }
    public void Init() {
        // We read the JSON file and fill the “municipios” ArrayList
    }
    @Override
    public int getItemCount() {
        return municipios.size();
    }
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
        public TextView getTextView() {
            return textView;
        }
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

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(String.valueOf(municipios.get(position).getMunicipi()));
    }
}
