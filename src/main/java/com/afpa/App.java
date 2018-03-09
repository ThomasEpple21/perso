package com.afpa;

public class App
{
    public static void main( String[] args )
    {
        /*Compte c=new Compte();
        c.depot(new BigDecimal("1000.10"));
        c.afficherSolde();
        c.retrait(new BigDecimal("500"));
        c.afficherSolde();
        Compte c1=new Compte();
        c.virer(new BigDecimal("500"),c1);
        c.afficherSolde();
        c1.afficherSolde();*/

        /*Client cl1=new Client("Jean");
        cl1.ajouterCompte();
        cl1.compte[0].depot(new BigDecimal("200"));
        cl1.ajouterCompte();
        cl1.afficherSolde(0);
        cl1.compte[1].depot(new BigDecimal("300"));
        cl1.afficherSolde(1);
        System.out.println(cl1.getSolde());

        BanqueInteractive b1=new BanqueInteractive();
        b1.ajouterClients("David");
        b1.clients[0].ajouterCompte();
        b1.clients[0].compte[0].depot(new BigDecimal("100"));
        b1.ajouterClients("Jean");
        b1.clients[1].ajouterCompte();
        b1.clients[1].ajouterCompte();
        b1.clients[1].compte[0].depot(new BigDecimal("200"));
        b1.clients[1].compte[1].depot(new BigDecimal("300"));
        b1.bilanClient(0);
        b1.afficherBilan();*/


        BanqueInteractive bi=new BanqueInteractive();
        bi.interaction();


    }
}
