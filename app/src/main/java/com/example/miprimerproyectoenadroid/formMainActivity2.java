package com.example.miprimerproyectoenadroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class formMainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_main2);

        TextView resumen = findViewById(R.id.textoResumen);
        Button volver = findViewById(R.id.btnVolver);

        // Recupera los datos del Intent
        String nombre = getIntent().getStringExtra("nombre");
        String edad = getIntent().getStringExtra("edad");
        String ciudad = getIntent().getStringExtra("ciudad");

        // Muestra mensaje personalizado
        resumen.setText("Hola, " + nombre + ". Tienes " + edad + " años y eres de " + ciudad + ". Encantado de conocerte.");

        // Botón para volver al formulario
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverIntent = new Intent(formMainActivity2.this, MainActivity.class);
                startActivity(volverIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
