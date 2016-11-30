package com.example.didier_lechat.multiplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Didier_Lechat on 22/11/2016.
 */

public class JeuActivity extends AppCompatActivity{

    // Accès à la classe Carte
    private Carte carte_1, carte_2;
    // Accès à la classe Reponse
    private  Reponse rep_1;
    // Permet d'afficher le numéro de la première carte et celle de la deuxième carte
    private int nombre_carte_1, nombre_carte_2;
    // Affichage de nombre aléatoirement des valeurs pour réponse à la multiplication
    private int int_reponse_aleatoire_1, int_reponse_aleatoire_2, int_reponse_multiplication;

    // EDIT TEXT //
    TextView reponse_1, reponse_2, reponse_3;

    // Nombre d'erreur pour affichage pendu //
    private int nb_error = -1;

    // BOOlEAN qui permet de savoir si erreur ou pas
    private boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeuactivity);

        // INITIALISATION DES TEXTVIEW//
        reponse_1 = (TextView) findViewById(R.id.rep_1);
        reponse_2 = (TextView) findViewById(R.id.rep_2);
        reponse_3 = (TextView) findViewById(R.id.rep_3);
        // FIN INITIALISATION //

        // Affichage des valeurs dans les cartes //
        createGame();

        // Debut Réaction bouton retour //
        Button previous = (Button) findViewById(R.id.home);
        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent my_intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(my_intent2);
            }
        });
        // Fin Réaction bouton retour //*/
        // DEBUT REACTION BOUTON IMAGE //
        ImageButton rep1 = (ImageButton) findViewById(R.id.answer1);
        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Vérifaication de la valeur écrite sur l'image bouton
                // corresponde au résultat de la multiplication
                if(Integer.parseInt(reponse_1.getText().toString()) == int_reponse_multiplication){
                    // Affichage d'une nouvelle multiplication
                    createGame();
                }
                else{
                    // Controle du nombre d'erreur//
                    nb_error = nb_error+1;
                    // Passage du boolean error à true
                    error = true;
                    // Affichage du pendu à chaque erreur //
                    paintPendu();
                    createGame();
                }

            }
        });
        error = false;
        ImageButton rep2 = (ImageButton) findViewById(R.id.answer2);
        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Vérifaication de la valeur écrite sur l'image bouton
                // corresponde au résultat de la multiplication
                if(Integer.parseInt(reponse_2.getText().toString()) == int_reponse_multiplication){
                    // Affichage d'une nouvelle multiplication
                    createGame();
                }
                else{
                    // Controle du nombre d'erreur//
                    nb_error = nb_error+1;
                    // Passage du boolean error à true
                    error = true;
                    paintPendu();
                    createGame();
                }

            }
        });
        error = false;
        ImageButton rep3 = (ImageButton) findViewById(R.id.answer3);
        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Vérifaication de la valeur écrite sur l'image bouton
                // corresponde au résultat de la multiplication
                if(Integer.parseInt(reponse_3.getText().toString()) == int_reponse_multiplication){
                    // Affichage d'une nouvelle multiplication
                    createGame();
                }
                else{
                    // Controle du nombre d'erreur//
                    nb_error = nb_error+1;
                    // Passage du boolean error à true
                    error = true;
                    paintPendu();
                    createGame();
                }
            }
        });
        error = false;
        // FIN REACTION BOUTON IMAGE //
    }

    public void nbAleatoire(){
        int nb_Aleatoire_rep_1 = (int) (Math.random()*3+1);
        int nb_Aleatoire_rep_2 = (int) (Math.random()*3+1);
        int nb_Aleatoire_rep_3 = 0;

        if(nb_Aleatoire_rep_1 == 1 && nb_Aleatoire_rep_2 == 2){
            nb_Aleatoire_rep_3 = 3 ;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_3.setText(String.valueOf(int_reponse_multiplication));
        }
        else if(nb_Aleatoire_rep_1 == 2 && nb_Aleatoire_rep_2 == 3){
            nb_Aleatoire_rep_3 = 1;

            reponse_1.setText(String.valueOf(int_reponse_multiplication));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_1));
        }
        else if(nb_Aleatoire_rep_1 == 3 && nb_Aleatoire_rep_2 == 1){
            nb_Aleatoire_rep_3 = 2;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_2.setText(String.valueOf(int_reponse_multiplication));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_1));
        }
        else if(nb_Aleatoire_rep_1 == 3 && nb_Aleatoire_rep_2 == 3){
            nb_Aleatoire_rep_1= 3;
            nb_Aleatoire_rep_2 = 1;
            nb_Aleatoire_rep_3 = 2;

            reponse_1.setText(String.valueOf(int_reponse_multiplication));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_2));
        }
        else if(nb_Aleatoire_rep_1 == 1 && nb_Aleatoire_rep_2 == 1){
            nb_Aleatoire_rep_1= 2;
            nb_Aleatoire_rep_2 = 3;
            nb_Aleatoire_rep_3 = 1;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_3.setText(String.valueOf(int_reponse_multiplication));
        }
        else if(nb_Aleatoire_rep_1 == 2 && nb_Aleatoire_rep_2 == 2){
            nb_Aleatoire_rep_1= 1;
            nb_Aleatoire_rep_2 = 2;
            nb_Aleatoire_rep_3 = 3;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_3.setText(String.valueOf(int_reponse_multiplication));
        }
        else if(nb_Aleatoire_rep_1 == 3 && nb_Aleatoire_rep_2 == 2){
            nb_Aleatoire_rep_3 = 1;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_2.setText(String.valueOf(int_reponse_multiplication));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_2));
        }
        else if(nb_Aleatoire_rep_1 == 2 && nb_Aleatoire_rep_2 == 1){
            nb_Aleatoire_rep_3 = 3;

            reponse_1.setText(String.valueOf(int_reponse_aleatoire_2));
            reponse_2.setText(String.valueOf(int_reponse_multiplication));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_1));
        }
        else if(nb_Aleatoire_rep_1 == 1 && nb_Aleatoire_rep_2 == 3){
            nb_Aleatoire_rep_3 = 2;

            reponse_1.setText(String.valueOf(int_reponse_multiplication));
            reponse_2.setText(String.valueOf(int_reponse_aleatoire_1));
            reponse_3.setText(String.valueOf(int_reponse_aleatoire_2));
        }

    }

    public void createGame(){
        carte_1 = new Carte();
        TextView nb_affichage_1 = (TextView) findViewById(R.id.nb1);
        nombre_carte_1= carte_1.getNbCarte();
        nb_affichage_1.setText(Integer.toString(nombre_carte_1));

        // Affichage pour la deuxième carte //
        carte_2 = new Carte();
        TextView nb_affichage_2 = (TextView) findViewById(R.id.nb2);
        nombre_carte_2 = carte_2.getNbCarte();
        nb_affichage_2.setText(Integer.toString(nombre_carte_2));

        // PARTIE REPONSE DU JEU //
        rep_1 = new Reponse();

        int_reponse_aleatoire_1 = Integer.parseInt(String.valueOf(rep_1.getNbAleatoireReponse()));
        int_reponse_aleatoire_2 = Integer.parseInt(String.valueOf(rep_1.getNbAleatoireReponse()));
        int_reponse_multiplication = Integer.parseInt(String.valueOf(rep_1.reponseMultiplication(nombre_carte_1, nombre_carte_2)));

        nbAleatoire();
    }

    public void paintPendu(){
        int NB_ERROR_MAX = 9;
        ArrayList<Integer> tab_view_pendu = new ArrayList<Integer>();
        tab_view_pendu.add(R.drawable.socle_pendu);
        tab_view_pendu.add(R.drawable.socle_mat_pendu);
        tab_view_pendu.add(R.drawable.socle_mat_haut_pendu);
        tab_view_pendu.add(R.drawable.socle_mat_haut_barre_pendu);
        tab_view_pendu.add(R.drawable.tete);
        tab_view_pendu.add(R.drawable.corps);
        tab_view_pendu.add(R.drawable.main_droite);
        tab_view_pendu.add(R.drawable.main_gauche);
        tab_view_pendu.add(R.drawable.pied_droit);
        tab_view_pendu.add(R.drawable.pied_gauche);

        if(getError()){

            ImageView pendu = (ImageView) findViewById(R.id.pendu);
            pendu.setImageResource(tab_view_pendu.get(getNb_error()));
        }
        if(nb_error == NB_ERROR_MAX){
            AlertDialog.Builder builder = new AlertDialog.Builder(JeuActivity.this);
            builder.setTitle("PERDU");
            builder.setMessage("Votre bonhomme est pendu :)");
            builder.setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent my_intent = new Intent(getApplicationContext(), JeuActivity.class);
                    startActivity(my_intent);
                }
            });
            builder.show();
        }

    }

    public boolean getError(){
        return error;
    }

    public int getNb_error(){
        return nb_error;
    }
}
