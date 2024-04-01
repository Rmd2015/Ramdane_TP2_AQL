package org.example.Exercice4;
import java.util.Random;

public class DeImpl implements De {
    private Random random;

    public DeImpl() {
        this.random = new Random();
    }

    @Override
    public int lancer() {
        // Simulation d'un lancer de dé entre 1 et 6 inclus
        return random.nextInt(6) + 1;
    }
}