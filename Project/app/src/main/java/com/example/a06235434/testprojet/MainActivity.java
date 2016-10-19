package com.example.a06235434.testprojet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void chamaTelaLongin(View v){
        setContentView(R.layout.login_main);
    }
    public void chamaTelaPrincipal(View v){
        setContentView(R.layout.activity_main);
    }
    public void chamaTelaAgenda(View v){
        setContentView(R.layout.agenda_main);
    }
    public void chamaTelaArquivos(View v){
        setContentView(R.layout.arquivos_main);
    }

    public void chamaTelaCalculadora(View v){
        setContentView(R.layout.calculador_main);
    }
    public void chamaTelaUsuario(View v){
        setContentView(R.layout.usuario_main);
    }
    public void chamaTelaLembrete(View v){
        setContentView(R.layout.lembrete_main);
    }

    public void chamaTelaCalendario(View v){
        setContentView(R.layout.calendario_main);
    }
}

