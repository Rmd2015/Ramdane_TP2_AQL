package org.example.Exercice3;

public class UserService implements UtilisateurApi {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public void creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);

    }
    public int getIdUtilisateur(Utilisateur u){return u.getIdUtilisateur();}

}
