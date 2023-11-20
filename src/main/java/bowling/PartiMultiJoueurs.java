package bowling;

public class PartiMultiJoueurs implements IPartieMultiJoueurs {
	private String[] nomsDesJoueurs;
	private int nombreDeQuillesAbattues;
	private String nomDuJoueur;

	public PartiMultiJoueurs(String[] nomsDesJoueurs){
		System.out.println(nomsDesJoueurs); //faux à corriger juste histoire que ça soit pas vide 
	}

	public String demarreNouvellePartie(String[] nomsDesJoueurs){
		var x = nomsDesJoueurs; 
		String a = null; 
		for(var i = 0 ; i < x.length ; i++){
			a = "Prochain tir : " + nomsDesJoueurs[i] + "tour n° 1, boule n° 1";
		}
		return a; 
	}
	
	public String enregistreLancer(int nombreDeQuillesAbattues){
		return null; // à finir 
	}

	public int scorePour(String nomDuJoueur){
		return 0; // à finir
	}
	
}
