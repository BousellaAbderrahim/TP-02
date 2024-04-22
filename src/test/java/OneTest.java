
import org.example.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OneTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;



    @Test
    public void testCreerUtilisateurException() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur(10,"Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour lancer une exception lors de l'appel
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock)
                .creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester et vérification qu'une exception est levée
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        // Vérification du message de l'exception
        assertEquals("Echec de la création de l'utilisateur", exception.getMessage());
    }
}
