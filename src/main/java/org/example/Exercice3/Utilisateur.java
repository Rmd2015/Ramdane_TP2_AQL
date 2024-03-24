package org.example.Exercice3;

public class Utilisateur {
    private String nom , prenom ,mail ;
    private  int idUtilisateur ;
    public Utilisateur(String nom, String prenom, String mail,int id) {
        this.nom = nom ;
        this.prenom = prenom;
        this.mail = mail ;
        this.idUtilisateur = id;
    }
    public int getIdUtilisateur(){return this.idUtilisateur;}
}
