package com.ed.RickAndMortyApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListaAdapter extends ArrayAdapter<Episodio> {



    public ListaAdapter(@NonNull Context context, @NonNull ArrayList<Episodio>  episodios) {
        super(context, 0, episodios);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Episodio epi = getItem(position);
        if(convertView== null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);

        }
        TextView id = (TextView) convertView.findViewById(R.id.tvAppId);
        TextView nombre = (TextView) convertView.findViewById(R.id.tvNombre);
        TextView episodio = (TextView) convertView.findViewById(R.id.tvEPISODIO);
        TextView air = (TextView) convertView.findViewById(R.id.tAair_date);
        TextView creador = (TextView) convertView.findViewById(R.id.tvCREADOR);

        id.setText(""+epi.getId());
        nombre.setText(epi.getNombre());
        episodio.setText(epi.getEpisodio());
        air.setText(epi.getAir_date());
        creador.setText(epi.getCreated());
        return convertView;
    }





}
