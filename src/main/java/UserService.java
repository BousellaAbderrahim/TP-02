import org.example.ServiceException;

public class UserService {
    private  UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }


}
