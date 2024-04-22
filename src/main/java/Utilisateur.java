public class Utilisateur {
    int id;
    String nom,prenom,email;
    public Utilisateur(int id,String n,String s,String e){
        this.id=id;
        this.nom=n;
        this.prenom=s;
        this.email=e;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
