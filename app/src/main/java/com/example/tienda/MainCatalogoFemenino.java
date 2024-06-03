package com.example.tienda;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainCatalogoFemenino extends AppCompatActivity {
    Button homen;
    Button btnuser;
    Button btnNavegacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_catalogo_femenino);
        btnNavegacion= findViewById(R.id.btnSpinner);
        btnuser = findViewById(R.id.btnuser);
        homen = findViewById(R.id.btnHomen);
        homen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAHome();}
        });
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irACuenta();
            }
        });
        btnNavegacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iraNavegacion();}
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.scrollView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void irACuenta() {
        Intent intent = new Intent(this, CuentaActivity.class);
        startActivity(intent);
    }
    public void iraNavegacion(){
        Intent intent = new Intent(this, ActivityNavegacion.class);
        startActivity(intent);
    }
    public void irAHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}