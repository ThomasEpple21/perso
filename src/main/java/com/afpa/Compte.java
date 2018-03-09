package com.afpa;

import java.math.BigDecimal;

public interface Compte {

	public int getNumero();
	public BigDecimal getSolde();
	public void afficherSolde();
	public void setNumero(int numero);
	public void virer(BigDecimal valeur,Compte destinataire);
	public void depot(BigDecimal valeur);
	public void retrait(BigDecimal valeur);
}
