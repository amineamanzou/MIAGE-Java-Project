import java.util.List;

/**
 * Contact entity
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class Contact implements Entity{
    private Integer id;
    private String surnom;
    private String nom;
    private String prenom;
    private Sexe sexe;
    private String adresse;
    private List<Mail> mail;
    private List<Phone> telephone;
    private List<Tag> tags;

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
     * @return the surnom
     */
    public String getSurnom() {
        return surnom;
    }

    /**
     * @param surnom 
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
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
     * @return the adress
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    /**
     * @return the mail
     */
    public List<Mail> getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(List<Mail> mail) {
        this.mail = mail;
    }

    /**
     * @return the telephone
     */
    public List<Phone> getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(List<Phone> telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags the tag to set
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    /**
     * Contact validator
     * 
     * @return true because no validation on this item
     */
    @Override
    public boolean isValide(){
        return true;
    }
}
