package com.example.labo3_alexsoliman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        btn_valider = findViewById(R.id.btn_valider);
        et_cle = findViewById(R.id.et_cle);
        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            int cle = Integer.parseInt(et_cle.getText().toString());
            if (cle >= 0 && cle <= 25 ) {
                Intent intent = new Intent();
                intent.putExtra("cle", cle);
                setResult(2, intent);
            }
            else {
                Toast.makeText(getBaseContext(), "Cle Invalide", Toast.LENGTH_SHORT).show();
            }
            }
        });

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cle_decalage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



}