package com.ed.RickAndMortyApp;

import android.os.Parcel;
import android.os.Parcelable;


public class Episodio implements Parcelable {

    private int id;


    private String Nombre;

    private String air_date;

    private String episodio;

    private String created;


    public Episodio(int id, String Nombre, String air_date, String episodio, String created) {
        this.id = id;
        this.Nombre = Nombre;
        this.air_date = air_date;
        this.episodio = episodio;
        this.created = created;
    }

    protected Episodio(Parcel in)
    {
        id =in.readInt();
        Nombre = in.readString();
        air_date = in.readString();
        episodio = in.readString();
        created = in.readString();

    }

    public static final Creator<Episodio> CREATOR = new Creator<Episodio>() {
        @Override
        public Episodio createFromParcel(Parcel in) {
            return new Episodio(in);
        }

        @Override
        public Episodio[] newArray(int size) {
            return new Episodio[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisodio() {
        return episodio;
    }

    public void setEpisodio(String episodio) {
        this.episodio = episodio;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString(){
        return "Episodio{"+
                "id= "+ id + '\'' +
                "name= "+ Nombre + '\'' +
                "air_date= "+ air_date + '\'' +
                "episode= "+ episodio + '\'' +
                "created= "+ created + '\'' +
                '}';

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(Nombre);
        dest.writeString(air_date);
        dest.writeString(episodio);
        dest.writeString(created);
    }


}
