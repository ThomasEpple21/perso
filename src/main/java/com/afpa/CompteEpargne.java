package com.afpa;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CompteEpargne implements Compte {

	private int numero;
	private BigDecimal solde;
	private LocalDate datecreation;
	private LocalDate dateDerniereOperation;
	private BigDecimal tauxInteret;
	private BigDecimal montantInterets;
		
	
	
	public void CompteEpargne() {
		datecreation=LocalDate.now();
		dateDerniereOperation=LocalDate.of(2012, 05, 15);
		tauxInteret = new BigDecimal(0.001);
		montantInterets = new BigDecimal(0);
		
	}
		
		
	@Override
	public int getNumero() {
		return numero;
	}

	@Override
	public BigDecimal getSolde() {
		return solde;
	}

	@Override
	public void afficherSolde() {
		System.out.println(solde.setScale(2));
	}

	@Override
	public void setNumero(int numero) {
		this.numero = numero;

	}

	@Override
	public void virer(BigDecimal valeur, Compte destinataire) {
		this.retrait(valeur);
        destinataire.depot(valeur);
	}

	@Override
	public void depot(BigDecimal valeur) {
		solde=solde.add(valeur);
	}

	@Override
	public void retrait(BigDecimal valeur) {
		solde=solde.subtract(valeur);
	}
	
	public void calculInterets() {
		
	}

}
