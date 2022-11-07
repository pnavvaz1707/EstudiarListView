package com.example.estudiarlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout datos;
    private ListView registerList;
    private final ArrayList<Persona> personasRegistradas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);

        datos = (LinearLayout) findViewById(R.id.datos_layout);

        registerList = (ListView) findViewById(R.id.register_list);

        Button btnAnadir = (Button) findViewById(R.id.btn_anadir);
        btnAnadir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText nombre = (EditText) ((LinearLayout) datos.getChildAt(0)).getChildAt(1);
        EditText telefono = (EditText) ((LinearLayout) datos.getChildAt(1)).getChildAt(1);
        EditText edad = (EditText) ((LinearLayout) datos.getChildAt(2)).getChildAt(1);
        System.out.println("Esta aki " + nombre.getText().toString() + " || " + telefono.getText().toString() + " || " + edad.getText().toString());
        if (!(nombre.getText().toString().equals("") || telefono.getText().toString().equals("") || edad.getText().toString().equals(""))) {
            personasRegistradas.add(new Persona(nombre.getText().toString(), telefono.getText().toString(), Integer.parseInt(edad.getText().toString())));
            System.out.println("Ha entrado" + nombre.getText().toString() + " || " + telefono.getText().toString() + " || " + edad.getText().toString());
            Adaptador adaptador = new Adaptador(this, personasRegistradas);
            registerList.setAdapter(adaptador);
        }else {
            Toast.makeText(this, "Debes introducir todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}
