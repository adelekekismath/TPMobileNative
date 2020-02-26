package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle(R.string.page_calculator);
    }

    String signe = "";
    public void Cliquer(View view) {
        Button btn = (Button) view;
        String value = (String) btn.getText();
        TextView vue;
        vue =  findViewById(R.id.txt_screen) ;
        String val = vue.getText().toString();

        if (isNumeric(value)){
            if(val.equals("0")){
                vue.setText(value);
            }else {
            vue.setText(vue.getText()+value);}
        }else {
            switch (value){
                case "AC":
                    vue.setText("0");
                    this.signe = "";
                    break;
                case "+":
                    this.AddSymbol(value,vue);
                break;
                case ".":
                    if (!val.contains(".")){
                    vue.setText(vue.getText()+ ".");}
                    break;
                case "-":
                    this.AddSymbol(value,vue);
                    break;
                case "*":
                    this.AddSymbol(value,vue);
                    break;
                case "/":
                    this.AddSymbol(value,vue);
                    break;
                case "+/-":

                    break;
                case "=":
                    this.Calcul(val,vue);
                    break;
                case "%":
                    this.AddSymbol(value,vue);
                    break;
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static String[] stringtoarray (String str, String signe){
       return str.split(Pattern.quote(signe));
    }

    public  void AddSymbol ( String signe, TextView vue){
        if (this.signe.equals("")){
            this.signe = signe;
            vue.setText(vue.getText()+ signe);
        }else if(this.signe.equals(signe)){
            String val = vue.getText().toString();
            String last =  val.substring(val.length()-1, val.length() );
            Log.i("kis",last);
            if (isNumeric(last)){
                vue.setText(vue.getText()+ signe);
            }
        }

    }
    public void Calcul(String val, TextView vue){
        String[] tabplus= stringtoarray(val,"+");
        String[] tabmoins= stringtoarray(val,"-");
        String[] tabfois= stringtoarray(val,"*");
        String[] tabdiv= stringtoarray(val,"/");
        String[] tabmod= stringtoarray(val,"%");
        int i=0;
        double result=0;
        boolean NoZero = true;
        if(tabplus.length > 1){
            for (String str : tabplus){
                result+=Double.parseDouble(str.trim());
            }
            vue.setText(String.valueOf(result));

        }else if(tabmoins.length > 1){

            for (i = 0; i<tabmoins.length; i++){
                if (i==0){
                    result=Double.parseDouble(tabmoins[i].trim());
                }else {
                    result-=Double.parseDouble(tabmoins[i].trim());
                }
            }
            vue.setText(String.valueOf(result));

        }else if (tabfois.length > 1){

            result = 1;
            for (String str : tabfois){
                result*=Double.parseDouble(str.trim());
            }
            vue.setText(String.valueOf(result));


        }else if (tabdiv.length > 1){

            for (i = 0; i< tabdiv.length; i++){
                if (i==0){
                    result=Double.parseDouble(tabdiv[i].trim());
                }else {
                    if (tabdiv[i].trim().equals("0")){
                        Log.i("kis",tabdiv[i].trim());
                        NoZero = false;
                        break;
                    }else{
                        result/=Double.parseDouble(tabdiv[i].trim());
                    }
                    }

            }if(NoZero){
            vue.setText(String.valueOf(result));}
            else {
                Toast.makeText(getApplicationContext(), "La division par zero est impossible", Toast.LENGTH_LONG).show();
            }


        }else if (tabmod.length > 1){

            for (i = 0; i< tabmod.length; i++){
                if (i==0){
                    result=Double.parseDouble(tabmod[i].trim());
                }else {
                    if (tabmod[i].trim().equals("0")){
                        Log.i("kis",tabmod[i].trim());
                        NoZero = false;
                        break;
                    }else{
                        result%=Double.parseDouble(tabmod[i].trim());
                    }
                }

            }if(NoZero){
                vue.setText(String.valueOf(result));}
            else {
                Toast.makeText(getApplicationContext(), "La division par zero est impossible", Toast.LENGTH_LONG).show();
            }
        }
        this.signe = "";
    }
}
