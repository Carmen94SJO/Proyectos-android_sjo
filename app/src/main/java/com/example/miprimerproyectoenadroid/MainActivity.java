package com.example.miprimerproyectoenadroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private boolean cambiado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button bo = findViewById(R.id.botoncito);
        TextView t = findViewById(R.id.textecito);
        View fondo = findViewById(R.id.fondo);

        TextInputEditText inputNombre = findViewById(R.id.inputNombre);
        TextInputEditText inputEdad = findViewById(R.id.inputEdad);
        TextInputEditText inputCiudad = findViewById(R.id.inputCiudad);

        int colorOriginal = ContextCompat.getColor(this, R.color.pink);
        fondo.setBackgroundColor(colorOriginal);
        String textoOriginal = t.getText().toString();

        bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cambia texto y color al hacer clic
                if (!cambiado) {
                    t.setText(R.string.cambio);
                    fondo.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                    cambiado = true;
                } else {
                    t.setText(textoOriginal);
                    fondo.setBackgroundColor(colorOriginal);
                    cambiado = false;
                }

                // Recoge datos del formulario
                String nombre = inputNombre.getText().toString();
                String edad = inputEdad.getText().toString();
                String ciudad = inputCiudad.getText().toString();

                // Crea Intent y envía los datos
                Intent in = new Intent(MainActivity.this, formMainActivity2.class);
                in.putExtra("nombre", nombre);
                in.putExtra("edad", edad);
                in.putExtra("ciudad", ciudad);
                startActivity(in);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fondo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
