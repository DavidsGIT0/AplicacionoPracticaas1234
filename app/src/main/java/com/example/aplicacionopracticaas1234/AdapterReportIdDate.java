package com.example.aplicacionopracticaas1234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterReportIdDate extends RecyclerView.Adapter<AdapterReportIdDate.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<ReportIdDate> reportIdDates;
    Context context;

    public AdapterReportIdDate(RecyclerViewInterface recyclerViewInterface, ArrayList<ReportIdDate> reportIdDates, Context context) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.reportIdDates = reportIdDates;
        this.context = context;
    }

    public ReportIdDate getReportIdDate(int pos) { return reportIdDates.get(pos);}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listaiddate, parent, false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarIds(reportIdDates.get(position).getId());
        holder.asignarDates(reportIdDates.get(position).getDate());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ids;
        private TextView dates;

        public ViewHolder(View view, RecyclerViewInterface recyclerViewInterface) {
            super(view);
            ids = (TextView) view.findViewById(R.id.ids);
            dates = (TextView) view.findViewById(R.id.dates);
        }
        public TextView getTextViewIds() { return ids; }
        public TextView getTextViewDates() {
            return dates;
        }

        public void asignarIds(String id) {
            this.ids.setText(id);
        }

        public void asignarDates(String dates) {
            this.dates.setText(dates);
        }
    }

    @Override
    public int getItemCount() { return reportIdDates.size(); }
}
