package com.ed.RickAndMortyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "https://rickandmortyapi.com/api/episode/"/*"https://devru-latitude-longitude-find-v1.p.rapidapi.com/latlon.php?location=New%20York"*/;
    TextView tvLista;
    Button btCargar, btListar;
    ArrayList<Episodio> listaEstados= new ArrayList<Episodio>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLista = findViewById(R.id.tvLista);
        btCargar = findViewById(R.id.btCargar);
        btListar = findViewById(R.id.btListar);
tvLista.setMovementMethod(new ScrollingMovementMethod());
        btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService();
            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaEstados != null) {
                    Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                    i.putParcelableArrayListExtra("episodios", listaEstados);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "no ha cargado el servicio web", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void cargarWebService() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                parserJson(response)

                ;/*tvLista.setText(response.toString());*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error de conexion", Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(jsonObjectRequest);
    }


    public void parserJson(JSONObject response) {
        try {
            String cadena = "";
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject com = results.getJSONObject(i);
                int id = com.getInt("id");
                String nombre = com.getString("name");
                String air_date = com.getString("air_date");
                String episodio = com.getString("episode");
                String created = com.getString("created");
                cadena = cadena + id + "," + nombre + "," + air_date + "," + episodio + "," + created + "\n";
                Episodio co = new Episodio(id, nombre, air_date, episodio, created);
                listaEstados.add(co);
            }

            tvLista.setText(cadena);
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }







    }
}
