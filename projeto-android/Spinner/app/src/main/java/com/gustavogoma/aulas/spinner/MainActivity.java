package com.gustavogoma.aulas.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Usuario> list = new ArrayList<>();
        list.add(new Usuario(1, "Gustavo"));
        list.add(new Usuario(2, "Elias"));
        list.add(new Usuario(3, "Vinicius"));
        list.add(new Usuario(4, "Felipe"));

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Adapter adapter = new Adapter(this, list);
        spinner.setAdapter(adapter);
    }
}
