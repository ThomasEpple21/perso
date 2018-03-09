package com.afpa;


import com.afpa.utils.Saisie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BanqueInteractive {

    private Map<Integer,Client> clients; //une banque plusieurs clients



    public BanqueInteractive()
    {
        clients=new TreeMap<>(); //instanciation en TreeMap


    }

    public void ajouterClients(String nom_du_client)
    {
        Client c=new Client(nom_du_client);
        c.setNumeroclient(nom_du_client.hashCode()+clients.size());
        clients.put(c.getNumeroclient(),c); //on ajoute à la case suivante un nouveau client

        System.out.println("Le client "+nom_du_client+" a été créé");
    }

    public void bilanClient(int numeroclient)
    {
        System.out.println("le solde de l'ensemble des comptes du client "+numeroclient+
                " est de "+clients.get(numeroclient).getSolde().setScale(2)+" euros"); //attention get sur la clé de la map
    } //recupere le client à l'indice numeroclient->recupere le solde

    public void afficherBilan()
    {
        System.out.println("********************Bilan général de la banque***********************************");
        clients.entrySet().stream().forEach(e->this.bilanClient(e.getKey()));
        //conversion de la map en set<Entry> puis en stream pour chaque entry appel du bilanclient avec parametre la clé de l'entry
        //code alternatif
        //clients.keySet().stream().forEach(key->this.bilanClient(key));
    }


    public void interaction()
    {
        System.out.println("Quelle opération voulez-vous effectuer");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une opération sur un client");
        System.out.println("3) Afficher un bilan général");
        int saisie= Saisie.saisirEntier();
        if(saisie==1)
        {
            this.ajouterClients(this.saisirNom()); //imbriquation des méthodes
                                                   //moins de lignes de codes
                                                   //code modulaire
        }
        else
            if(saisie==2)
            {
            this.MenuOperation(this.choixClient()); //appel menu operation même principe imbriquation des m"éthodes
            }
            else
                if(saisie==3)
                {
                    this.afficherBilan(); //affiche le bilan de la banque
                }
                this.interaction(); //le retrour au menu principal est assuré par un appel à la méthode interaction
                                    //c'est la recursivité
    }

    public void MenuOperation(int numeroclient) //le numero client correspond à l'indice dans le tableau
    {
        System.out.println("Quelle opération Voulez-vous effectuez sur le client "+clients.get(numeroclient).getNom());
        System.out.println("1 ) Afficher un bilan");
        System.out.println("2 ) Faire un retrait");
        System.out.println("3 ) Faire un dépôt");
        System.out.println("4 ) Faire un virement");
        System.out.println("5 ) Ajouter un compte");
        int saisie=Saisie.saisirEntier();
        /*pour l'ensemble des traitements numeroclient représente la clé mais pas l'indice*/
        if(saisie==1)
        {
         this.bilanClient(numeroclient);
        }else
            if(saisie==2)
            {
            clients.get(numeroclient).getCompte().get(this.choixCompte(clients.get(numeroclient))).retrait(this.choixMontant());
            // objet client qui possède le numeroclient=>compte correspondant au choix compte=> retrait du montant choisi
            }
            else
                if(saisie==3)
                {
                    clients.get(numeroclient).getCompte().get(this.choixCompte(clients.get(numeroclient))).depot(this.choixMontant());
                }
                else
                    if(saisie==4)
                    {
                        System.out.println("Quel client destinataire?");
                        Client destinataire=clients.get(this.choixClient()); //choix du client destinataire

                        clients.get(numeroclient).getCompte().get(this.choixCompte(clients.get(numeroclient)))
                                .virer(this.choixMontant(),destinataire.getCompte().get(this.choixCompte(destinataire)));
                        //objet client à l'indice numéro de client=>compte correspondant auu choix compte source=>
                        //appel méthode virer parametre (choix du montant par méthode,choix du compte destinataire
                        //par appel de méthode
                    }
                    else
                        if(saisie==5)
                        {
                            clients.get(numeroclient).ajouterCompte();
                        }
    }

    private String saisirNom()
    {
      System.out.println("Entrez le nom du client");
      return Saisie.saisirChaine();
    }

    private int choixClient() //renvoi le numero du client dans le tableau
    {
       if(clients.size()>0) //on test si il y a bien des clients dans la banque
       {
           clients.entrySet().stream().forEach(e->System.out.println(e.getKey()+")"+" "+e.getValue().getNom()));
       }
       else //autrement pas de clients
       {
           System.out.println("Pas de clients");
           this.interaction(); //retour au menu principal
       }
        return Saisie.saisirEntier(); //plus de -1 car c'est un numéro de client
    }
    /*permet le saisie d'un montant=> depot,retrait,viremnent*/
    private BigDecimal choixMontant()
    {
        System.out.println("Quel montant");
        return Saisie.saisieBigDecimal();
    }

    //permet le choix d'un compte pour un client donné renvoi l'indice du compte dans le tableau
    private int choixCompte(Client clt)
    {
        if(clt.getCompte().size()>0) //test si le client à moins un compte
        {
            System.out.println("Quel Compte du client " + clt.getNom() + " ?");
            clt.getCompte().keySet().stream().forEach(key->System.out.println(key+")"));
            //conversion en set<Integer>
        }
        else { //le client n'a pas de comptes
            System.out.println("Le client " + clt.getNom() + " n'a pas encore de comptes");
            this.interaction(); //renvoi au menu principal
        }
        return Saisie.saisirEntier(); //retourne le numero de compte choisi
    }







}
