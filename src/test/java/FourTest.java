
import org.example.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FourTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;






    @Test
    public void testCreerUtilisateurArgumentCaptor() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur(10,"Jean", "Dupont", "jeandupont@email.com");

        // Création de l'ArgumentCaptor pour capturer les arguments passés au mock
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        // Configuration du mock pour renvoyer true lors de l'appel de creerUtilisateur
        when(utilisateurApiMock.creerUtilisateurTrueOrFalse(any(Utilisateur.class))).thenReturn(true);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Capture des arguments passés à la méthode creerUtilisateur du mock
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        // Obtenir l'utilisateur capturé
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // TODO : Vérification des arguments capturés, utiliser les getters de l’objet utilisateurCapture
        // Vérification que l'objet capturé est bien l'utilisateur original
        assertEquals(utilisateur.getNom(), utilisateurCapture.getNom());
        assertEquals(utilisateur.getPrenom(), utilisateurCapture.getPrenom());
        assertEquals(utilisateur.getEmail(), utilisateurCapture.getEmail());
    }
}
