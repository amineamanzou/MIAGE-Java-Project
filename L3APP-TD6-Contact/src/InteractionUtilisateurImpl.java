import java.util.ArrayList;
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
        writer.println(Action.SEARCH  +   " => Rechercher un contact");
        writer.println(Action.SAVE    +   " => Sauvegarder les changements CSV");
        writer.println(Action.LOAD    +   " => Importer un fichier CSV");
        writer.println(Action.EXIT    +   " => Quitter");
        writer.println("########################################");
        writer.print("\t => ");
        return reader.readInt();
    }

    
    @Override
    public void afficherContact (Contact contact) {
        writer.println("########################################");
        writer.println("\t" + contact.getNom() + " " + contact.getPrenom());
        writer.println("########################################");
        writer.println("Surnom : "+contact.getSurnom());
        writer.println("Sexe : "+contact.getSexe());
        writer.println("Adresse : "+contact.getAdresse());        
        writer.println("Emails : "+contact.getMail());
        writer.println("Télephones : "+contact.getTelephone());
        writer.println("Tags : \n\t"+contact.getTags());
        writer.println("########################################");
    }

    @Override
    public void afficherListeContact (List<Contact> liste) {
        writer.println("########################################");
        writer.println("–––––––––––––––––––––––––––––––––––––––––––––––––––");
        writer.printTab("Id","Nom","Prénom","Surnom","Sexe","Adresse |");
        writer.println("–––––––––––––––––––––––––––––––––––––––––––––––––––");
        if(!liste.isEmpty()){
            for(Contact c : liste){
                writer.printTab(
                        c.getId().toString(),
                        c.getNom(),
                        c.getPrenom(),
                        c.getSurnom(),
                        c.getSexe().toString(),
                        c.getAdresse() + "\t|"
                );
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
        writer.println("\tCreation d'un contact");
        writer.println("########################################");
        writer.println("Nom :");
        c.setNom(reader.readLine());
        writer.println("Prénom :");
        c.setPrenom(reader.readLine());
        writer.println("Surnom :");
        c.setSurnom(reader.readLine());
        writer.println("Adresse :");
        c.setAdresse(reader.readLine());
        // Sexe is a required field
        do{
            writer.println("Sexe (H/F):");
            c.setSexe( Sexe.fromString(reader.readString()));
        }while(c.getSexe() == null);
        // Adding mail to the contact
        writer.println("Adresses Mail:");
        String mailEntry = "";
        List<Mail> mailList = new ArrayList<Mail>();
        while(!mailEntry.equals("0")){
            writer.println("\tType(P/M/F),Mail : (P,mail@gmail.com)");
            mailEntry = reader.readLine();
            String mailString[] = mailEntry.split(",");
            if(mailString.length > 1){
                Mail e = new Mail();
                e.setType(Type.fromString(mailString[0]));
                e.setEmail(mailString[1]);
                mailList.add(e);
            }
        }
        c.setMail(mailList);
        // Adding phone to the contact
        writer.println("Numéros de Télephone:");
        String phoneEntry = "";
        List<Phone> phoneList = new ArrayList<Phone>();
        while(!phoneEntry.equals("0")){
            writer.println("\tType(P/M/F),Phone: (P,+332344244)");
            phoneEntry = reader.readLine();
            String phoneString[] = phoneEntry.split(",");
            if(phoneString.length > 1){
                Phone e = new Phone();
                e.setType(Type.fromString(phoneString[0]));
                e.setNumber(phoneString[1]);
                phoneList.add(e);
            }
        }
        c.setTelephone(phoneList);
        // Adding tag to the contact
        writer.println("Tags (csv):");
        String tagEntry = reader.readLine();
        List<Tag> tagList = new ArrayList<Tag>();
        String tagString[] = tagEntry.split(",");
        for(String tmp:tagString){
            Tag e = new Tag();
            e.setTag(tmp);
            tagList.add(e);
        }
        c.setTags(tagList);
        return c;
    }

    @Override
    public Integer saisirContactId () {
        writer.print("Veuillez saisir l'id du contact à sélectionner : ");
        return reader.readInt();
    }
    
    
    public String saisirRecherche () {
        writer.print("Veuillez saisir le mot recherché : ");
        return reader.readLine();
    }

    @Override
    public Integer saisirFieldRecherche (){
        writer.println("########################################");
        writer.println("\t*************************");
        writer.println("\t*****CONTACT MANAGER*****");
        writer.println("\t*************************");
        writer.println("Veuillez saisir le type de votre recherche.");
        writer.println("########################################");
        writer.println(ContactAction.NOM +  " => Par nom");
        writer.println(ContactAction.PRENOM  +   " => Par prenom");
        writer.println(ContactAction.SURNOM  +   " => Par surnom");
        writer.println(ContactAction.MAIL  +   " => Par email");
        writer.println(ContactAction.PHONE    +   " => Par telephone");
        writer.println(ContactAction.TAG    +   " => Par tag");
        writer.println(Action.EXIT    +   " => Quitter");
        writer.println("########################################");
        writer.print("\t => ");
        return reader.readInt();
    }
    
    @Override
    public String saisirMotCleRecherche(){
        writer.print("Veuiller saisir le mot cle recherché : ");
        return reader.readLine();
    }
    
    @Override
    public String saisirPath(){
        writer.print("Entrez le chemin du fichier : ");
        return reader.readLine();
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

