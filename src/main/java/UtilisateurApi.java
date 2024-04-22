import org.example.ServiceException;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;

    Object creerUtilisateurTrueOrFalse(Utilisateur any);

    Object getUtilisateurID();
}
