import java.util.List;

/**
 * UI Interface
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public interface InteractionUtilisateur {
    /*
     * Lecture
     */
    Contact saisirContact();
    Integer saisirContactId();    
    int getChoixUtilisateur();
    void attenteUtilisateur();
    String saisirFieldRecherche ();
    String saisirMotCleRecherche();
    String saisirPath();
    
    /*
     * Ecriture
     */
    void afficherContact(Contact c);
    void afficherListeContact(List<Contact> l);    
    void afficherMessage(String message);
    void afficherErreurIdentifiant(Integer id);
    void afficherSauvegarde();
    
}
