package com.example.a06235434.appnotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

private EditText frmNota01;
private EditText frmNota02;
private Button btCalcular;
private TextView txtResultado;
private double nota01;
private double nota02;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

frmNota01= (editText) findVi