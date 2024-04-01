package org.example.Exercice4;
import java.util.Random;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque labanque) {
        this.banque = labanque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
            banque.crediter(mise);
        } catch (DebitImpossibleException e) {
            ouvert = false;
            throw new JeuFermeException("Le joueur est insolvable.");
        }

        int resultat = de1.lancer() + de2.lancer();
        if (resultat == 7) {
            if (!banque.est_solvable()) {
                ouvert = false;
                throw new JeuFermeException("La banque n'est plus solvable.");
            }
            joueur.crediter(mise * 2);
            banque.debiter(mise * 2);
        } else {
            ouvert = false;
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}