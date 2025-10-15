package com.example.miprimerproyectoenadroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Referencias a los campos
        TextInputEditText inputNombre = findViewById(R.id.inputNombre);
        TextInputEditText inputEdad = findViewById(R.id.inputEdad);
        TextInputEditText inputCiudad = findViewById(R.id.inputCiudad);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        // Acción del botón
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Recoger los valores introducidos
                String nombre = inputNombre.getText().toString();
                String edad = inputEdad.getText().toString();
                String ciudad = inputCiudad.getText().toString();

                // Crear Intent para ir a la segunda actividad
                Intent intent = new Intent(MainActivity.this, formMainActivity2.class);

                // Enviar datos
                intent.putExtra("nombre", nombre);
                intent.putExtra("edad", edad);
                intent.putExtra("ciudad", ciudad);

                // Iniciar la segunda Activity
                startActivity(intent);
            }
        });
    }
}
