package com.example.tienda;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class ActivityFormularioRegistro extends AppCompatActivity {

    Button btnVolver, btnregistro;
    EditText inputNombre, inputApellido, inputTel, inputCorreo,inputContrasena;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_registro);



        inputNombre = findViewById(R.id.input_nombre);
        inputApellido = findViewById(R.id.input_apellido);
        inputTel = findViewById(R.id.input_telefono);
        inputCorreo = findViewById(R.id.input_correo);
        inputContrasena = findViewById(R.id.input_pasword);
        btnregistro = findViewById(R.id.btnregistrar);


        btnVolver =findViewById(R.id.btnRegresar);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();}
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAHome();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void registrar() {
        String contrasena = inputContrasena.getText().toString();
        DatabaseReference nuevoUsuario = reference.child(String.valueOf(contrasena));

        String nombre = inputNombre.getText().toString();
        nuevoUsuario.child("nombre").setValue(nombre);
        String apellido = inputApellido.getText().toString();
        nuevoUsuario.child("apellido").setValue(apellido);
        String telefono = inputTel.getText().toString();
        nuevoUsuario.child("telefono").setValue(telefono);
        String correo = inputCorreo.getText().toString();
        nuevoUsuario.child("correo").setValue(correo);
        String contrasenausuario = inputContrasena.getText().toString();
        nuevoUsuario.child("contrasena").setValue(contrasenausuario);

        Toast.makeText(getApplicationContext(),"el usuario se a creado automaticamente", Toast.LENGTH_LONG).show();

    }
    public void irAHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}