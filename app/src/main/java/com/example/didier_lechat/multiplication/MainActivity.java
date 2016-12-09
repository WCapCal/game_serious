package com.example.didier_lechat.multiplication;

import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton enter = (ImageButton) findViewById(R.id.enter_play);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(getApplicationContext(), JeuActivity.class);
                startActivity(my_intent);
            }
        });

        ImageButton info = (ImageButton) findViewById(R.id.information);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("INFORMATION");
                builder.setMessage("Jeu réalisé par Didier WALBRECQUE \n"+
                        " Pour le projet dans le module Développement web et mobile");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent my_intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(my_intent);
                    }
                });
                builder.show();
            }
        });
    }


}
