package com.example.cambioestilos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ConstraintLayout mainLayout;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        List<String> modos = Arrays.asList("", "Claro", "Oscuro", "Default");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void cambiar(View view) {
        String opc = spinner.getSelectedItem().toString();

        if (opc.isEmpty()) {
            Toast.makeText(this, "Selecciona un modo de la lista desplegable!", Toast.LENGTH_LONG).show();
            return;
        }

        switch (opc) {
            case "Claro":
                mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(20);
                textView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                button.setBackgroundColor(Color.LTGRAY);
                button.setTextColor(Color.BLACK);
                break;

            case "Oscuro":
                mainLayout.setBackgroundColor(Color.parseColor("#2D2D2D"));
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(22);
                textView.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.WHITE);
                break;

            case "Default":
                mainLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(18);
                textView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                button.setBackgroundColor(Color.BLUE);
                button.setTextColor(Color.WHITE);
                break;
        }
    }
}
