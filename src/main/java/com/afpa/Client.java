package com.afpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Client {
    private int numeroclient; //Ajout du numero de client
    private Map<Integer,Compte> compte; //un client possède plusieurs comptes
    private String nom;
    //plus de nombres de comptes car donné par compte.size()

    public Client(String nom_du_client) {
        compte = new TreeMap<>(); //instanciation sous forme d'un treempa
        // dans le construteur tableau de 100 cases max
        nom = nom_du_client; //on affecte l'argument à l'attribut nom
        numeroclient=0;


    }

    public void ajouterCompte() {
        Compte c = new CompteCourant(); //on doir créer un nouveau compte
        c.setNumero(compte.size()+1); //set +autoincrement
        compte.put(c.getNumero(),c); // map=>put

        System.out.println("Le compte " + c.getNumero() + " a été ajouté");


    }


    public String getNom() {
        return nom;
    }

    public BigDecimal getSolde() {
        BigDecimal somme = new BigDecimal("0"); //permet de stocker localement la somme

        //on parcours les comptes
        for (Compte c : compte.values()) { //compte.values permet de recuperer les valeurs sous forme d'une collection iterable
            somme = somme.add(c.getSolde()); //on incrémente la somme du solde du compte
        }
        return somme;
    }

    public void afficherSolde(int numero) //modification ajout d'un parametre d'indice
    {
        compte.get(numero).afficherSolde();//affiche le solde à l'indice donné
        //attention à utiliser la méthode existante
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public Map<Integer,Compte> getCompte() {
        return compte;
    }

    public int getNumeroclient() {
        return numeroclient;
    }

    public void setNumeroclient(int numeroclient) {
        this.numeroclient = numeroclient;
    }
}
