package com.ed.RickAndMortyApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

   ArrayList<Episodio> listaEstados;

    ListView LVEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaEstados = new ArrayList<>();
        Intent i =getIntent();
        listaEstados= i.getParcelableArrayListExtra("episodios");
        LVEstado =findViewById(R.id.LVEstado);
        if (listaEstados!=null && listaEstados.size()>0){
            ListaAdapter adapter = new ListaAdapter(this, listaEstados);
            LVEstado.setAdapter((ListAdapter) adapter);
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this,"nada por aqui :c",Toast.LENGTH_LONG).show();
        }



    }
}
