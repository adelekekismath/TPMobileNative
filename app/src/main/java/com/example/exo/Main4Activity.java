package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
     String nom;
     String numero;
     int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        nom = intent.getStringExtra("nom");
        numero = intent.getStringExtra("numero");
        TextView num = findViewById(R.id.Num_C);
        num.setText(numero);
        img = intent.getIntExtra("img", 0);
        getSupportActionBar().setTitle(nom);

         ImageView img = findViewById(R.id.image_C);
         switch (nom){
             case "Mom":
                 img.setImageResource(R.drawable.mom);
             break;
             case "Dani":
                 img.setImageResource(R.drawable.dani);
                 break;
             case "Michelle":
                 img.setImageResource(R.drawable.michelle);
                 break;
             case "Robert":
                 img.setImageResource(R.drawable.rob);
                 break;
             case "Farhane":
                 img.setImageResource(R.drawable.farhane);
                 break;
             case "Dad":
                 img.setImageResource(R.drawable.dad);
                 break;
             case "Bestie":
                 img.setImageResource(R.drawable.bestie);
                 break;
             case "Bae":
                 img.setImageResource(R.drawable.bae);
                 break;
             case "Ib":
                 img.setImageResource(R.drawable.ib);
                 break;
         }


        TextView text = findViewById(R.id.Nom_C);
        text.setText(nom);

       ImageButton btn_appel = findViewById(R.id.call);
       btn_appel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

    }
}
