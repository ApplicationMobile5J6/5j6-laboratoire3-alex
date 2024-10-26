package com.example.labo3_alexsoliman;
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

public class CleDecalage extends AppCompatActivity {

    EditText et_cle;
    Button btn_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cle_decalage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_valider = findViewById(R.id.btn_valider);
        et_cle = findViewById(R.id.et_cle);
        btn_valider.setOnClickListener(v -> {
            String cleText = et_cle.getText().toString();

            try {
                int cle = Integer.parseInt(cleText);

                if (cle >= 0 && cle <= 25) {
                    Intent intent = new Intent();
                    intent.putExtra("cle", cle);
                    setResult(2, intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Clé invalide. Entrez un entier entre 0 et 25.", Toast.LENGTH_SHORT).show();
                }

            } catch (NumberFormatException e) {
                Toast.makeText(getBaseContext(), "Veuillez entrer un nombre entier valide.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("etCleText", et_cle.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        et_cle.setText(savedInstanceState.getString("etCleText"));
    }



}