package com.example.tienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DasboardInicioSesion extends AppCompatActivity {
    EditText inputNombre, inputContrasena;
    Button btnIniciarSesion;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("usuario");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_inicio_sesion);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNombre = findViewById(R.id.Etxt_ingresarNombre);
        inputContrasena = findViewById(R.id.Etxt_ingresarClave);
        btnIniciarSesion = findViewById(R.id.Btn_Ingresar);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }




    public void iniciarSesion() {
        String nombre = inputNombre.getText().toString();
        String contrasena = inputContrasena.getText().toString();

        reference.orderByChild("nombre").equalTo(nombre).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot usuarioSnapshot : dataSnapshot.getChildren()) {
                        String contrasenaDB = usuarioSnapshot.child("contrasena").getValue(String.class);
                        if (contrasenaDB.equals(contrasena)) {
                            boolean esAdmin = usuarioSnapshot.child("admin").getValue(Boolean.class);
                            if (esAdmin) {
                                irADashboardAdmin();
                            } else {
                                irAHome();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "nombre no incorrecto", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error en la base de datos", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void irAHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void irADashboardAdmin() {
        Intent intent = new Intent(this, ActivityDasboarAdin.class);
        startActivity(intent);
    }
}