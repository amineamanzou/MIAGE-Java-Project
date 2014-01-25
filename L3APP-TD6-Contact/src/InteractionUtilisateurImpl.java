import java.util.Arrays;
import java.util.List;
import util.*;

/**
 * UI Console Implementation
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class InteractionUtilisateurImpl implements InteractionUtilisateur{
    

    private final ConsoleWriter writer;
    private final ConsoleReader reader;

    public InteractionUtilisateurImpl() {
        writer = new ConsoleWriter();
        reader = new ConsoleReader();
    }


    @Override
    public int getChoixUtilisateur () {
        //Affichage du menu
        writer.println("########################################");
        writer.println("\t*************************");
        writer.println("\t*****CONTACT MANAGER*****");
        writer.println("\t*************************");
        writer.println("\t\tMENU");
        writer.println("########################################");
        writer.println(Action.READ_ALL +  " => Afficher la liste des contacts");
        writer.println(Action.CREATE  +   " => Créer un contact");
        writer.println(Action.UPDATE  +   " => Modifier un contact");
        writer.println(Action.DELETE  +   " => Supprimer un contact");
        writer.println(Action.READ    +   " => Afficher un contact");
        writer.println(Action.SAVE    +   " => Sauvegarder les changements sur le disque");
        writer.println(Action.EXIT    +   " => Quitter");
        writer.println("########################################");
        writer.print("\t => ");
        return reader.readInt();
    }

    
    @Override
    public void afficherContact (Contact contact) {
        writer.println("########################################");
        writer.println("\t\tCreation d'un contact");
        writer.println("########################################");
        writer.println("Nom :"+contact.getNom());
        writer.println("Prénom :"+contact.getPrenom());        
        writer.println("Sexe :"+contact.getSexe());
        writer.println("Adresses Mail (csv):"+contact.getMail());
        writer.println("Numéros de Télephone (csv):"+contact.getTelephone());
        writer.println("########################################");
    }

    @Override
    public void afficherListeContact (List<Contact> liste) {
        writer.println("########################################");
        writer.println("Id\t Nom\t Prénom\t Sexe\t|");
        writer.println("––––––––––––––––––––––––––––––––––");
        if(!liste.isEmpty()){
            for(Contact c : liste){
                writer.println(c.getId() +"\t "+ c.getNom()+"\t "+c.getPrenom() +"\t "+c.getSexe()+"\t|");
           }
        }
        else {
            writer.println("La liste de contact est vide.");
        }
    }

    @Override
    public Contact saisirContact () {
        Contact c = new Contact();
        writer.println("########################################");
        writer.println("Creation d'un contact");
        writer.println("########################################");
        writer.println("Nom :");
        c.setNom(reader.readString());
        writer.println("Prénom :");
        c.setPrenom(reader.readString());
        do{
            writer.println("Sexe (H/F):");
            c.setSexe( Sexe.fromString(reader.readString()));
        }while(c.getSexe() == null);
        writer.println("Adresses Mail (csv):");        
        c.setMail(Arrays.asList(reader.readString().split(",")));
        writer.println("Numéros de Télephone (csv):");
        c.setTelephone(Arrays.asList(reader.readString().split(",")));
        return c;
    }

    @Override
    public Integer saisirContactId () {
        writer.print("Veuillez saisir l'id du contact à sélectionner : ");
        return reader.readInt();
    }

    public void afficherMessageErreurMenu(){
        writer.println("########################################");
        writer.println("ERREUR : Cette option n'existe pas.");
        writer.println("########################################");
    }

    @Override
    public void afficherMessage(String message) {
        writer.println(message);
    }

    @Override
    public void afficherErreurIdentifiant(Integer id) {
        writer.println("########################################");
        writer.println("ERREUR : L'identifiant saisi ne correspond");
        writer.println("à aucun identifiant de contact : "+id);
        writer.println("########################################");
    }

    @Override
    public void attenteUtilisateur(){
        writer.println("(Appuyez sur Entrer pour continuer.)");
        reader.read(true);
    }

    @Override
    public void afficherSauvegarde() {
        
    }
}

