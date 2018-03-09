package com.afpa;


import java.math.BigDecimal;

public class CompteCourant implements Compte{

   private int numero;
   private BigDecimal solde;

    public CompteCourant()
    {
        numero=0;
        solde= new BigDecimal("0"); //f indique un float par défaut 0 est double
    }

    public void depot(BigDecimal valeur)
    {
        solde=solde.add(valeur); //incremente le solde de la valeur
    }

    public void retrait(BigDecimal valeur)
    {
        solde=solde.subtract(valeur); //decremente le solde de la valeur
    }





    public void afficherSolde()
    {
        System.out.println(solde.setScale(2)); //on affiche avec un précision de 2 chiffres après la virgule
    }

    public void virer(BigDecimal valeur,Compte destinataire)
    {
        /* on utilise les méthodes de retrait et de dépot*/
        this.retrait(valeur);
        destinataire.depot(valeur);
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSolde()
    {
        return solde;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}
