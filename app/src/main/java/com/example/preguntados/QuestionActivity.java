package com.example.preguntados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    // Variables
    private int indicePregunta = 0;
    private int correctas = 0;
    private String nombreUsuario;
    private String categoria;


    private TextView tvPregunta;
    private Button btn1, btn2, btnVolver;

  //preguntas y respuetas
    private String[][] preguntasClubes = {
            {"¿A qué equipo le dicen 'Gallina'?", "Boca", "River", "2"},
            {"¿Cuál es el estadio de Boca?", "La Bombonera", "El Monumental", "1"},
            {"¿Quién tiene más Libertadores?", "Independiente", "Racing", "1"}
    };

    //preguntas y respuetas
    private String[][] preguntasSeleccion = {

            {"¿Dónde juega Leandro Paredes?", "Roma", "Boca", "2"},
            {"¿Quién es el DT de la selección?", "Scaloni", "Gareca", "1"},
            {"¿Cuántas estrellas tiene Argentina?", "2", "3", "2"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        nombreUsuario = getIntent().getStringExtra("PLAYER_NAME");
        categoria = getIntent().getStringExtra("CATEGORIA");

        tvPregunta = findViewById(R.id.tvPregunta);
        btn1 = findViewById(R.id.btnOpcion1);
        btn2 = findViewById(R.id.btnOpcion2);
        btnVolver = findViewById(R.id.btnAtras);

        cargarPregunta();

        btnVolver.setOnClickListener(v -> finish());
    }

    private void cargarPregunta() {
        String[][] pool = "CLUBES".equals(categoria) ? preguntasClubes : preguntasSeleccion;

        if (indicePregunta < pool.length) {
            // Mostrar la pregunta actual
            tvPregunta.setText(pool[indicePregunta][0]);
            btn1.setText(pool[indicePregunta][1]);
            btn2.setText(pool[indicePregunta][2]);

            int correcta = Integer.parseInt(pool[indicePregunta][3]);

            btn1.setOnClickListener(v -> validarRespuesta(1, correcta));
            btn2.setOnClickListener(v -> validarRespuesta(2, correcta));
        } else {
            // Si no hay más preguntas vamos al resultado
            irAResultado();
        }
    }

    private void validarRespuesta(int elegida, int correcta) {
        if (elegida == correcta) {
            correctas++;
        }
        indicePregunta++;
        cargarPregunta();
    }

    private void irAResultado() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("PLAYER_NAME", nombreUsuario);
        intent.putExtra("PUNTOS", correctas);
        intent.putExtra("TOTAL", 3);
        startActivity(intent);
        finish();
    }
}