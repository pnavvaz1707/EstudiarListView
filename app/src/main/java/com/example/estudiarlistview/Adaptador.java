package com.example.estudiarlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {

    private Activity activity;
    private ArrayList<Persona> personas;

    public Adaptador(Activity activity, ArrayList<Persona> personas) {
        super(activity, R.layout.lista_personas, personas);
        this.activity = activity;
        this.personas = personas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.lista_personas, null);

        TextView tvName = (TextView) item.findViewById(R.id.name_txt);
        tvName.setText(personas.get(position).getNombre());

        TextView tvTel = (TextView) item.findViewById(R.id.tel_txt);
        tvTel.setText(personas.get(position).getTelefono());

        TextView tvAge = (TextView) item.findViewById(R.id.age_txt);
        tvAge.setText(String.valueOf(personas.get(position).getEdad()));

        return (item);
    }
}
