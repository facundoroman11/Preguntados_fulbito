package com.example.preguntados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        EditText etNombre = findViewById(R.id.etNombre);
        Button btnJugar = findViewById(R.id.btnJugar);


        btnJugar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();

            if (!nombre.isEmpty()) {

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("PLAYER_NAME", nombre);
                startActivity(intent);
            } else {

                Toast.makeText(this, " Pone tu nombre", Toast.LENGTH_SHORT).show();
            }
        });
    }
}