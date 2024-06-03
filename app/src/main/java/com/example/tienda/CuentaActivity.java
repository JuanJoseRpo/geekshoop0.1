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

public class CuentaActivity extends AppCompatActivity {
    Button homen;
    Button btnResgistrarse, btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuenta);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        homen= findViewById(R.id.btnRegresar);
        btnResgistrarse = findViewById(R.id.btnRegistrarse);

        btnResgistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAFormularioRegistro();}
        });
        homen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAHome();}
        });
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAformulairoInicioSesion();}
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void irAHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void irAFormularioRegistro() {
        Intent intent = new Intent(this, ActivityFormularioRegistro.class);
        startActivity(intent);
    }
    public void irAformulairoInicioSesion() {
            Intent intent = new Intent(this, DasboardInicioSesion.class);
            startActivity(intent);}
}