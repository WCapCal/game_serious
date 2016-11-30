package com.example.didier_lechat.multiplication;

/**
 * Created by Didier_Lechat on 25/11/2016.
 */

import java.util.ArrayList;
import java.util.Random;

public class Reponse {



    private int reponse_multiplication;
    private int reponse_aleatoire;
    ArrayList<Integer> int_reponse;

    public Reponse(){

    }

    private int nbAleatoireReponse(){
        int nb_Aleatoire_rep;
        int min = 1;
        int max = 100;
        nb_Aleatoire_rep = (int) (Math.random()*max+min);
        return nb_Aleatoire_rep;
    }

    private int nbAleatoireInReponse(){

        int reponse_1, reponse_2, reponse_3;
        int_reponse = new ArrayList<Integer>();


        reponse_1 = this.getNbAleatoireReponse();

        reponse_2 = this.getNbAleatoireReponse();

        reponse_3 = this.getReponse_multiplication();


        int_reponse.add(reponse_1);
        int_reponse.add(reponse_2);
        int_reponse.add(reponse_3);


        Random rand = new Random();
        int nb_aleatoire = rand.nextInt(int_reponse.size());
        int reponse_aleatoire = int_reponse.get(nb_aleatoire);

        return reponse_aleatoire;
    }

    public int getNbAleatoireReponse(){
        return this.nbAleatoireReponse();
    }
    public int getNbAleatoireInReponse(){
        return this.nbAleatoireInReponse();
    }

    public int reponseMultiplication(int nombre1, int nombre2){
        int somme;
        somme = nombre1 * nombre2;
        return somme;
    }

    public int getReponse_multiplication() {
        return reponse_multiplication;
    }

    public int getReponseAleatoire(){
        return reponse_aleatoire;
    }

    public ArrayList<Integer> getArrayList(){
        return int_reponse;
    }

    public String affichage(){
        String result_affichage ="";
        int i=0;
        while(i<this.getArrayList().size()){
            if(i==0){
                result_affichage += "Reponse 5 "+this.getArrayList().get(i).toString()+"\n";
            }else if (i==1){
                result_affichage += "Reponse 6 "+this.getArrayList().get(i).toString()+"\n";
            }
            else {
                result_affichage += "Reponse 7 "+this.getArrayList().get(i).toString()+"\n";
            }

            i++;
        }
        return result_affichage;
    }

}

