package com.example.labo3_alexsoliman;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String fichier = "monFichier.txt";
    EditText et_origin, et_recevoir;
    Button btn_crypter, btn_decrypter;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar tb_action = (Toolbar) findViewById(R.id.tb_action);
        et_origin = findViewById(R.id.et_original);
        et_recevoir = findViewById(R.id.et_recevoir);
        setSupportActionBar(tb_action);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.mnu_ouvrir){

            try {
                FileInputStream fichierALire = openFileInput(fichier);

                int c;

                String temp = "";

                while ((c = fichierALire.read()) != -1) {
                    temp = temp + Character.toString((char) c);
                }

                et_origin.setText(temp);
                Toast.makeText(getBaseContext(), "fichier lu", Toast.LENGTH_SHORT).show();
                fichierALire.close();
            } catch (FileNotFoundException e ) {
            e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (item.getItemId() == R.id.mnu_save){
            data = et_recevoir.getText().toString();

            try{
                FileOutputStream fichierOut = openFileOutput(fichier, MODE_PRIVATE);
                fichierOut.write(data.getBytes());
                fichierOut.close();
                Toast.makeText(getBaseContext(), "fichier sauvegarde", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }

        } else if (item.getItemId() == R.id.mnu_cle){

        } else if (item.getItemId() == R.id.mnu_quit){

        }



        return true;

    }



}