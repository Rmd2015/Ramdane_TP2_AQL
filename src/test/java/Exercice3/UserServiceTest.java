package Exercice3;
import org.example.Exercice3.ServiceException;
import org.example.Exercice3.UserService;
import org.example.Exercice3.Utilisateur;
import org.example.Exercice3.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Captor
    ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com", 123);
// TODO : Configuration du comportement du mock, utiliser la
//directive « when » avec sa méthode « thenReturn »
// ...
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(false);
        // TODO : Création du service avec le mock
        UtilisateurApi userService = new UserService(utilisateurApiMock);
// Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        // Vérification que la méthode getIdUtilisateur n'a jamais été appelée
        verify(utilisateurApiMock, never()).getIdUtilisateur(any(Utilisateur.class));
    }

    @Test
    public void testCreerUtilisateur_EnvoiReussi() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",123);

        // Configuration du comportement du mock pour simuler un envoi réussi
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        // Définition d'un ID fictif
        int idUtilisateur = 123;

        // Configuration du mock pour renvoyer l'ID
        when(utilisateurApiMock.getIdUtilisateur(utilisateur)).thenReturn(idUtilisateur);
        // TODO : Création du service avec le mock
        UtilisateurApi userService = new UserService(utilisateurApiMock);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        assertEquals(idUtilisateur, utilisateur.getIdUtilisateur());
    }

    @Test
    public void testCreerUtilisateur_ArgumentsCaptures() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",123);

        // Configuration du comportement du mock pour simuler un envoi réussi
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);
// TODO : Création du service avec le mock
        UtilisateurApi userService = new UserService(utilisateurApiMock);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification des arguments capturés
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals(utilisateur.getNom(), utilisateurCapture.getNom());
        assertEquals(utilisateur.getPrenom(), utilisateurCapture.getPrenom());
        assertEquals(utilisateur.getMail(), utilisateurCapture.getMail());
    }

}
