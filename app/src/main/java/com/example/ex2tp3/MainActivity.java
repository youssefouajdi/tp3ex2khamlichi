package com.example.ex2tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        btn = (Button)findViewById(R.id.button);
        String actions[]={"Ouvrir le navigateur","Appeler quelqu'un",
        "Composer un numéro", "Afficher la Map","Chercher dans la Map",
        "Prendre une photo","Afficher les contacts","Modifier le premier Contact"};

        ArrayAdapter adapter=new
                ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,actions);

        spinner.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch(position){
                    case 0:
                        intent= new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://google.com"));
                        break;
                    case 1:
                        intent= new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:(+212)123456789"));
                        break;
                    case 2:
                        intent= new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+212)123456789"));
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:67.453,7.1434?t=15"));
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=query"));
                        break;
                    case 5:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;

                }
                if(intent!=null){
                    startActivity(intent);
                }
            }
        });

    }
}
