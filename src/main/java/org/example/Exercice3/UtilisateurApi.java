package org.example.Exercice3;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
    public int getIdUtilisateur(Utilisateur u);
}
