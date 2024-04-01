package Exercice4;

import org.example.Exercice4.*;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.*;

public class JeuTest {
    @Test
    void JeuFermeTest() {
        Banque banque = new BanqueImpl(1000, 100); // Fond de 1000 avec un fond minimum de 100
        Jeu jeu = new Jeu(banque);
        jeu.fermer();
        assertFalse(jeu.estOuvert());
        assertThrows(JeuFermeException.class, () -> jeu.jouer(new JoueurImpl(100), new DeImpl(), new DeImpl()));
    }
    @Test
    void JoueurInsolvableTest() {
        Banque banque = mock(Banque.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);
        Jeu jeu = new Jeu(banque);

        when(banque.est_solvable()).thenReturn(true); // La banque est solvable
        when(de1.lancer()).thenReturn(3); // Simulation du lancer des dés
        when(de2.lancer()).thenReturn(4);

        // Le joueur n'a pas assez d'argent pour miser
        Joueur joueur = mock(Joueur.class);
        when(joueur.mise()).thenReturn(100);
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));

        // Vérification que les dés ne sont pas utilisés lorsque le  est insolvable
        verifyNoInteractions(de1);
        verifyNoInteractions(de2);
    }

    @Test
    void BanqueInsolvableTest() {
        Banque banque = new BanqueImpl(100, 1000); // Fond de 100 avec un fond minimum de 1000
        Jeu jeu = new Jeu(banque);
        Joueur joueur = new JoueurImpl(100); // Un joueur avec une mise de 100
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, new DeImpl(), new DeImpl()));
        assertFalse(jeu.estOuvert()); // Vérifie que le jeu est fermé
    }
}
