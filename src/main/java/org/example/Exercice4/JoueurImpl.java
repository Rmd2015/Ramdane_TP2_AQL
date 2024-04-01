package org.example.Exercice4;

public class JoueurImpl implements Joueur {
    private int argent;

    public JoueurImpl(int argent) {
        this.argent = argent;
    }

    @Override
    public int mise() {
        // Pour les besoins du test, on suppose une mise fixe
        return 100;
    }

    @Override
    public void debiter(int somme) throws DebitImpossibleException {
        if (somme > argent) {
            throw new DebitImpossibleException("Le joueur est insolvable.");
        }
        argent -= somme;
    }

    @Override
    public void crediter(int somme) {
        argent += somme;
    }
}
