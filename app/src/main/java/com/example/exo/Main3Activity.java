package com.example.exo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    String nom[] = {"Mom", "Dad", "Bestie", "Bae", "Ib","Dani","Michelle","Robert","Farhane"};
    String numero[] = {"97474743" , "66683661", "62458741", "97584214", "66584741", "64683661", "62458741", "97585814", "66584751"};
    int images[] = {R.drawable.mom, R.drawable.dad, R.drawable.bestie, R.drawable.bae, R.drawable.ib,R.drawable.dani, R.drawable.michelle, R.drawable.rob, R.drawable.farhane};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.setTitle("Liste des contacts");
        ListView listContact = findViewById(R.id.listContact);

        mescontats contact = new mescontats(this, nom, numero, images );
        listContact.setAdapter(contact);

        listContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(IntentC(nom[0],numero[0],images[0]));
                } else if (position == 1) {
                    startActivity(IntentC(nom[1],numero[1],images[1]));
                } else if (position == 2) {
                    startActivity(IntentC(nom[2],numero[2],images[2]));
                } else if (position == 3) {
                    startActivity(IntentC(nom[3],numero[3],images[3]));
                } else if (position == 4) {
                    startActivity(IntentC(nom[4],numero[4],images[4]));
                } else if (position == 5) {
                    startActivity(IntentC(nom[5],numero[5],images[5]));
                } else if (position == 6) {
                    startActivity(IntentC(nom[6],numero[6],images[6]));
                } else if (position == 7) {
                    startActivity(IntentC(nom[7],numero[7],images[7]));
                } else if (position == 8) {
                    startActivity(IntentC(nom[8],numero[8],images[8]));
                }
            }
        });
    }




    class  mescontats extends ArrayAdapter<String> {

        Context context;
        String noms[];
        String numero[];
        int Img[];

        mescontats(Context c, String n[], String num[], int img[] ){
            super(c, R.layout.rowcontact, n);
            this.context = c;
            this.noms = n;
            this.numero = num;
            this.Img = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View ligne = layoutInflater.inflate(R.layout.rowcontact, parent, false);
            ImageView images = ligne.findViewById(R.id.image);
            TextView nom = ligne.findViewById(R.id.Nom);
            TextView num = ligne.findViewById(R.id.Num);

            images.setImageResource(Img[position]);
            nom.setText(noms[position]);
            num.setText(numero[position]);

            return ligne;
        }
    }

    public  Intent IntentC(String nom, String num, int img){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        intent.putExtra("nom", nom)
                .putExtra("numero",num)
                .putExtra("img", img) ;

        return intent;
    }
}
