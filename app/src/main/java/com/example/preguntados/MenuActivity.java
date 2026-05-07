package com.example.preguntados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvBienvenida = findViewById(R.id.tvBienvenida);
        Button btnClubes = findViewById(R.id.btnClubes);
        Button btnSeleccion = findViewById(R.id.btnSeleccion);


        String nombreUsuario = getIntent().getStringExtra("PLAYER_NAME");
        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            tvBienvenida.setText(" Hola, " + nombreUsuario);
        }


        btnClubes.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, QuestionActivity.class);
            intent.putExtra("PLAYER_NAME", nombreUsuario);
            intent.putExtra("CATEGORIA", "CLUBES");
            startActivity(intent);
        });

        btnSeleccion.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, QuestionActivity.class);
            intent.putExtra("PLAYER_NAME", nombreUsuario);
            intent.putExtra("CATEGORIA", "SELECCION");
            startActivity(intent);
        });
    }
}