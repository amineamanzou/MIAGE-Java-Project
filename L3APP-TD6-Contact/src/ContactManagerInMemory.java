import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactManagerInMemory extends EntityManagerInMemory<Contact> implements ContactManager {
    
    @Override
    public void importCsv(String path){
        BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
        String listSplitBy = "-";
 
	try {
		br = new BufferedReader(new FileReader(path));
		while ((line = br.readLine()) != null) {
			String[] contact = line.split(cvsSplitBy);
                        List mailList = new ArrayList<Mail>();
                        if(contact.length > 5){
                            String[] mails = contact[5].split(listSplitBy);
                            for(String tmp : mails){
                                Mail m = new Mail();
                                m.setEmail(tmp);
                                mailList.add(m);
                            }
                        }
                        List phoneList = new ArrayList<Phone>();
                        if(contact.length > 6){
                            String[] phones = contact[6].split(listSplitBy);
                            for(String tmp : phones){
                                Phone m = new Phone();
                                m.setNumber(tmp);
                                phoneList.add(m);
                            }
                        }
                        List tagList = new ArrayList<Tag>();
                        if(contact.length > 7){
                            String[] tags = contact[7].split(listSplitBy);
                            for(String tmp : tags){
                                Tag m = new Tag();
                                m.setTag(tmp);
                                tagList.add(m);
                            }
                        }
                        Contact c = new Contact();
                        c.setNom(contact[0]);
                        c.setPrenom(contact[1]);
                        c.setSurnom(contact[2]);
                        c.setSexe(Sexe.fromString(contact[3]));
                        c.setAdresse(contact[4]);
                        c.setMail(mailList);
                        c.setTelephone(phoneList);
                        c.setTags(tagList);
                        save(c);
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NoSuchEntityException ex) {
                System.out.println("NoSuchEntityException");
        } finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
    }
    
    @Override
    public List<Contact> findByName(String name) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();
        
        for(Contact c : originale) {
            if(c.getNom().equals(name)) {
                finale.add(c);
            }
        }

        return finale;
    }

    @Override
    public List<Contact> findByPrenom(String prenom) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();
        
        for(Contact c : originale) {
            if(c.getPrenom().equals(prenom)) {
                finale.add(c);
            }
        }

        return finale;
    }

    @Override
    public List<Contact> findBySurnom(String surnom) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();
        
        for(Contact c : originale) {
            if(c.getSurnom().equals(surnom)) {
                finale.add(c);
            }
        }

        return finale;
    }

    @Override
    public List<Contact> findByMail(String mail) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();

        for(Contact c : originale) {
            for(Mail e : c.getMail()) {
                if(e.getEmail().equals(mail)) {
                    finale.add(c);
                }
            }
        }

        return finale;
    }

    @Override
    public List<Contact> findByPhone(String tel) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();

        for(Contact c : originale) {
            for(Phone t : c.getTelephone()) {
                if(t.getNumber().equals(tel)) {
                    finale.add(c);
                }
            }
        }

        return finale;
    }

    @Override
    public List<Contact> findByTag(String tag) throws NoSuchEntityException {
        List<Contact> finale = new ArrayList<Contact>();
        List<Contact> originale = findAll();

        for(Contact c : originale) {
            for(Tag t : c.getTags()) {
                if(t.getTag().equals(tag)) {
                    finale.add(c);
                }
            }
        }

        return finale;
    }

}
