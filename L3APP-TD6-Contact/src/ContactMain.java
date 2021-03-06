/**
 * Main class of the application
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class ContactMain {
    
    public static void main(String[] args) {
        InteractionUtilisateur iu = new InteractionUtilisateurImpl();
        ContactManager cm = new ContactManagerInMemory();
        
        do{
            try{

                switch(iu.getChoixUtilisateur()){

                    case Action.CREATE :
                        Contact c = iu.saisirContact();
                        cm.save(c);
                        break;  
                    case Action.READ :
                        Integer id = iu.saisirContactId();
                        Contact c2  = cm.findById(id);
                        iu.afficherContact(c2);
                        break;  
                    case Action.READ_ALL :
                        iu.afficherListeContact(cm.findAll());                    
                        break;  
                    case Action.UPDATE :
                        Integer id2 = iu.saisirContactId();
                        Contact c3 = iu.saisirContact();                    
                        c3.setId(id2);
                        cm.save(c3);
                        break;  
                    case Action.DELETE :
                        Integer id3 = iu.saisirContactId();
                        cm.remove(cm.findById(id3));
                        break;
                    case Action.SEARCH :
                        Integer field = iu.saisirFieldRecherche();
                        if(field == 0)
                            break;
                        String search = iu.saisirMotCleRecherche();
                        iu.afficherListeContact(cm.findBy(field,search));
                        break;
                    case Action.SAVE :
                        cm.writeToCSV(cm.findAll());
                        iu.afficherSauvegarde();                    
                        break;
                    case Action.LOAD :
                       String path = iu.saisirPath();
                       cm.importCsv(path);
                       break;  
                    case Action.EXIT :
                        cm.writeToCSV(cm.findAll());
                        iu.afficherSauvegarde();
                        System.exit(0);
                }
            }catch(NoSuchEntityException e){
                
            }
            
            iu.attenteUtilisateur();
        }while(true);
    }
    
}
