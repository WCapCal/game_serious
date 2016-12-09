package com.example.didier_lechat.multiplication;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Didier_Lechat on 23/11/2016.
 */
public class Carte {

    private int nb_carte;
    private String name_carte;
    private int reponse;

    /* Construction de la carte */
    public Carte(){
        this.nb_carte = this.nbAleatoire();
        this.name_carte = this.formeAleatoire();
    }

    /* Tirage aléatoirement de nombre entre 1 et 10 */
    private int nbAleatoire(){
        int nb_Aleatoire;
        int min = 1;
        int max = 10;
        nb_Aleatoire = (int) (Math.random()*max+min);
        return nb_Aleatoire;
    }

    /* Affichage de la forme aléatoirement */
    private String formeAleatoire(){

        String forme_1, forme_2, forme_3, forme_4;
        ArrayList<String> forme_carte = new ArrayList<String>();
        String forme_aleatoire;

        forme_1 = "trefle";
        forme_2 = "coeur";
        forme_3 = "carreau";
        forme_4 = "pique";

        forme_carte.add(forme_1);
        forme_carte.add(forme_2);
        forme_carte.add(forme_3);
        forme_carte.add(forme_4);

        Random rand = new Random();
        int nb_forme_aleatoire = rand.nextInt(forme_carte.size());
        forme_aleatoire = forme_carte.get(nb_forme_aleatoire);

        return forme_aleatoire;
    }

    /* Méthode qui réalise la multiplication des deux nombre des cartes */
    public int multiplication(int nb){
        int somme;
        somme = this.getNbCarte() * nb;
        return somme;
    }
    /* Renvoie le nombre qui est a été aléatoirement tiré */
    public int getNbCarte(){
        return nb_carte;
    }
    /* Renvoie le nom qui est a été aléatoirement tiré */
    public String getNameCarte(){
        return name_carte;
    }

    public String toString(){
        String affichage_carte;
        affichage_carte= "La carte générer est : \n Numéro : "+this.nb_carte+
                "\n Name : "+this.name_carte;
        return affichage_carte;
    }

    public int getReponse(){

        return reponse;
    }
}
