package com.example.preguntados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //  Recuperamos los nuevos datos
        String nombre = getIntent().getStringExtra("PLAYER_NAME");
        int puntos = getIntent().getIntExtra("PUNTOS", 0);
        int total = getIntent().getIntExtra("TOTAL", 0);

        TextView tvMensaje = findViewById(R.id.tvMensajeFinal);
        TextView tvIcono = findViewById(R.id.tvIcono);
        Button btnVolver = findViewById(R.id.btnVolverInicio);


        // Usamos una condición si puntos es mayor a la mitad del total
        boolean gano = puntos > (total / 2);

        if (gano) {
            tvIcono.setText("🏆");
            tvMensaje.setText(" Sos un distinto ganaste fulbito, " + nombre + "!\nAcertaste " + puntos + " de " + total + ".\n Golazo al ángulo ");
            tvMensaje.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        } else {
            tvIcono.setText("❌");
            tvMensaje.setText(" Qué lástima no ganaste fulbito, " + nombre + "!\nSolo acertaste " + puntos + " de " + total + ".\nTe sacaron tarjeta roja.");
            tvMensaje.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        }

        // 3. Botón para reiniciar (se mantiene igual)
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}