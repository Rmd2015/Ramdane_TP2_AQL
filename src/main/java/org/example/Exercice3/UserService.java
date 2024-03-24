package org.example.Exercice3;

public class UserService implements UtilisateurApi {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public boolean creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException {
        boolean creationReussie  =  utilisateurApi.creerUtilisateur(utilisateur);
        if(!creationReussie ){
            throw new ServiceException("\"Echec de la création de l'utilisateur");
        }
        return creationReussie ;
    }
    public int getIdUtilisateur(Utilisateur u){return u.getIdUtilisateur();}

}
