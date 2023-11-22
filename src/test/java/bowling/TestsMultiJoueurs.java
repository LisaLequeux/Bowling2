package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestsMultiJoueurs {

	private PartiMultiJoueurs partie;
	private String[] joueurs;

	@BeforeEach
	void setUp() {
		partie = new PartiMultiJoueurs();
		joueurs = new String[]{"Lisa Lequeux","Julie Orcival"};
	}

	@Test
	void testDemarrerNouvellePartie() {
		assertEquals(partie.demarreNouvellePartie(joueurs),
			"Prochain tir: joueur Lisa Lequeux, tour n° 1, boule n° 1",
			"Ce n'est pas le bon tour/joueur/lancer");
	}

	@Test
	void testDemarrerSansJoueurs() {
		assertThrows(IllegalArgumentException.class, () -> {
			partie.demarreNouvellePartie(new String[]{});
		}, "1 joueur est nécessaire au minimum");
	}

	@Test
	void testEnregistreLancer() {
		partie.demarreNouvellePartie(joueurs);
		assertEquals(partie.enregistreLancer(5), "Prochain tir: joueur Lisa Lequeux, tour n° 1, boule n° 2", "Ce n'est pas le bon tour/joueur/lancer");
		assertEquals(partie.enregistreLancer(0), "Prochain tir: joueur Julie Orcival, tour n° 1, boule n° 1", "Ce n'est pas le bon tour/joueur/lancer");
		assertEquals(partie.enregistreLancer(10), "Prochain tir: joueur Lisa Lequeux, tour n° 2, boule n° 1", "Ce n'est pas le bon tour/joueur/lancer");
		for (int i = 0; i < 21; i++) {
			partie.enregistreLancer(10);
		}
		assertEquals(partie.enregistreLancer(10), "Partie finiz", "La partie doit être términée");
		assertThrows(IllegalStateException.class, () -> {partie.enregistreLancer(1);},
			"On ne doit pas pouvoir lancer àprès la fin de la partie");
	}

	@Test
	void testScore() {
		partie.demarreNouvellePartie(joueurs);
		partie.enregistreLancer(5);
		assertEquals(partie.scorePour("Lisa Lequeux"), 5, "Le score n'est pas bon pour ce joueur");
		assertThrows(IllegalArgumentException.class, () -> {partie.scorePour("Simon Bodin");}, "Ce joueur n'existe pas");
	}
}