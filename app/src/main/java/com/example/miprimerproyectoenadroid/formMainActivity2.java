package com.example.miprimerproyectoenadroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class formMainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_main2);

        // Referencias a los elementos
        TextView textResumen = findViewById(R.id.textResumen);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Obtener los datos enviados desde MainActivity
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String edad = intent.getStringExtra("edad");
        String ciudad = intent.getStringExtra("ciudad");

        // Crear el mensaje
        String mensaje = "Hola, " + nombre + ". Tienes " + edad +
                " años y eres de " + ciudad + ", encantado de conocerte.";

        // Mostrarlo en el TextView
        textResumen.setText(mensaje);

        // Botón para volver al formulario
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta Activity y regresa a MainActivity
            }
        });
    }
}
