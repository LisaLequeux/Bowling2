package bowling;

import java.util.*;
public class PartiMultiJoueurs implements IPartieMultiJoueurs {
	private String[] nomsDesJoueurs;
	private int nombreDeQuillesAbattues;
	private String nomDuJoueur;
	private int tourJoueurNo;
	private int nbJoueur;
	private Map<String, PartieMonoJoueur> parties;



	@Override
	public String demarreNouvellePartie(String[] nomsDesJoueurs) throws IllegalArgumentException {
		if(nomsDesJoueurs.length == 0) throw new IllegalArgumentException("1 joueur est nécessaire au minimum");
		var x = nomsDesJoueurs; 
		String a = null; 
		for(var i = 0 ; i < x.length ; i++){
			a = "Prochain tir : " + nomsDesJoueurs[i] + ", tour n° 1, boule n° 1";
		}
		return a; 
	}
	
	@Override
	public String enregistreLancer(int nombreDeQuillesAbattues) throws IllegalStateException {
		if(estFini()) throw new IllegalStateException("La partie est finie");
		PartieMonoJoueur joueurPartie = parties.get(nomsDesJoueurs[tourJoueurNo]);
		joueurPartie.enregistreLancer(nombreDeQuillesAbattues);
		if(joueurPartie.numeroProchainLancer() == 1 || joueurPartie.estTerminee()) tourJoueurNo = (tourJoueurNo+1) %nbJoueur;
		if (estFini()) return "Partie finie";
		return tourJoueur();
	}
	
	@Override
	public int scorePour(String nomDuJoueur) throws IllegalArgumentException {
		PartieMonoJoueur partieJoueur = parties.get(nomDuJoueur);
		if (partieJoueur == null) throw new IllegalArgumentException("Joueur inexistant");
		return partieJoueur.score();
	}

	private String tourJoueur(){
		return "Prochain tir: joueur " + nomsDesJoueurs[tourJoueurNo] + ", tour n° " + parties.get(nomsDesJoueurs[tourJoueurNo]).numeroTourCourant() + ", boule n° " + parties.get(nomsDesJoueurs[tourJoueurNo]).numeroProchainLancer();
	}

	private boolean estFini(){
		return parties.get(nomsDesJoueurs[nbJoueur-1]).estTerminee();
	}
	
}
