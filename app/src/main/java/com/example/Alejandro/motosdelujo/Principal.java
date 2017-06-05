package com.example.Alejandro.motosdelujo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.Alejandro.motosdejujo.R;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorMoto.OnApartamentoClickListener{
    private Intent i;
    private RecyclerView listado;
    private ArrayList<Moto> motos;
    private AdaptadorMoto adapter;
    private LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();
            }
        });

        listado=(RecyclerView)findViewById(R.id.lstOpciones);

        motos = DatosMotos.traerApartamentos(getApplicationContext());
        adapter=new AdaptadorMoto(motos,this,getResources().getStringArray(R.array.titulos));

        llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
    }

    private void agregar(){
        finish();
        i= new Intent(Principal.this,RegistrosMotos.class);
        startActivity(i);
    }

    @Override
    public void onApartamentoClick(Moto a) {
        i=new Intent(Principal.this, DetalleMoto.class);
        Bundle b=new Bundle();
        b.putString("foto",a.getFoto());
        b.putString("nom",a.getNomenclatura());
        b.putString("piso",a.getPiso());
        b.putString("metros",a.getMetros());
        b.putString("precio",a.getPrecio());
        b.putString("balcon",a.getBalcon());
        b.putString("sombra",a.getSombra());
        i.putExtra("datos",b);
        startActivity(i);
    }
}
