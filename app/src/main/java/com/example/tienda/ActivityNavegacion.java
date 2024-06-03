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

public class ActivityNavegacion extends AppCompatActivity {
    Button btnuser2;
    Button homen;
    Button btnCatalogoMujer;
    Button btnCatalogoHombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navegacion);

        btnuser2 = findViewById(R.id.btnuser);
        homen= findViewById(R.id.btnHomen);
        btnCatalogoMujer = findViewById(R.id.BtnMenuMujer);
        btnCatalogoHombre = findViewById(R.id.btnMenuHombre);

        btnCatalogoMujer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                irCatalogoMujer();}
        });
        btnCatalogoHombre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                irCatalogoHombre();}
        });
        btnuser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irACuenta();}
        });

        homen.setOnClickListener((v) -> {irAHome();});


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
    public void irAHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void irCatalogoMujer() {
        Intent intent = new Intent(this, MainCatalogoFemenino.class);
        startActivity(intent);
    }
    public void irCatalogoHombre() {
        Intent intent = new Intent(this, MainCatalogoUnisex.class);
        startActivity(intent);
    }

}