package org.example.Exercice2;

public class UserService implements UtilisateurApi {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public boolean creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException {
       return utilisateurApi.creerUtilisateur(utilisateur);

    }
}
