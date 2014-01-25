import java.util.List;

/**
 * Contact entity
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class Contact implements Entity{
    private Integer id;
    private String nom;
    private String prenom;
    private Sexe sexe;
    private List<String> mail;
    private List<String> telephone;

    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the sexe
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the mail
     */
    public List<String> getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(List<String> mail) {
        this.mail = mail;
    }

    /**
     * @return the telephone
     */
    public List<String> getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(List<String> telephone) {
        this.telephone = telephone;
    }
}
