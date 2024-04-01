package org.example.Exercice4;

public class BanqueImpl implements Banque {
    private int fonds;
    private int fondsMinimum;

    public BanqueImpl(int fonds, int fondsMinimum) {
        this.fonds = fonds;
        this.fondsMinimum = fondsMinimum;
    }

    @Override
    public void crediter(int somme) {
        fonds += somme;
    }

    @Override
    public boolean est_solvable() {
        return fonds >= fondsMinimum;
    }

    @Override
    public void debiter(int somme) {
        fonds -= somme;
    }
}

