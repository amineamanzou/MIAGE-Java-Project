import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactManagerInMemory extends EntityManagerInMemory<Contact> implements ContactManager {
    
    private static final String CSV_SEPARATOR = ";";
    private static final String LIST_SEPARATOR = "-";
    private static final String ELEMENT_SEPARATOR = ":";
    
    @Override
    public void importCsv(String path){
        BufferedReader br = null;
	String line = "";
 
	try {
		br = new BufferedReader(new FileReader(path));
		while ((line = br.readLine()) != null) {
			String[] contact = line.split(CSV_SEPARATOR);
                        List mailList = new ArrayList<Mail>();
                        if(contact.length > 5){
                            String[] mails = contact[5].split(LIST_SEPARATOR);
                            for(String tmp : mails){
                                Mail m = new Mail();
                                String[] entry = tmp.split(ELEMENT_SEPARATOR);
                                if(entry.length == 2){
                                    m.setType(Type.fromString(entry[0]));
                                    m.setEmail(entry[1]);
                                    mailList.add(m);
                                }
                            }
                        }
                        List phoneList = new ArrayList<Phone>();
                        if(contact.length > 6){
                            String[] phones = contact[6].split(LIST_SEPARATOR);
                            for(String tmp : phones){
                                Phone p = new Phone();
                                String[] entry = tmp.split(ELEMENT_SEPARATOR);
                                if(entry.length == 2){
                                    p.setType(Type.fromString(entry[0]));
                                    p.setNumber(entry[1]);
                                    phoneList.add(p);
                                }
                            }
                        }
                        List tagList = new ArrayList<Tag>();
                        if(contact.length > 7){
                            String[] tags = contact[7].split(LIST_SEPARATOR);
                            for(String tmp : tags){
                                Tag t = new Tag();
                                t.setTag(tmp);
                                tagList.add(t);
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
    public void writeToCSV(List<Contact> contactList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("importCSV.txt"), "UTF-8"));
            for (Contact c : contactList)
            {
                StringBuffer oneLine = new StringBuffer();
                StringBuilder builder = new StringBuilder();
                oneLine.append(c.getNom());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(c.getPrenom());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(c.getSurnom());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(c.getSexe().getText());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(c.getAdresse());
                oneLine.append(CSV_SEPARATOR);
                List<Mail> mailList = c.getMail();
                for(Mail m : mailList){
                    if(builder.length() != 0){
                        builder.append(LIST_SEPARATOR);
                    }
                    builder.append(m.getType().getText());
                    builder.append(ELEMENT_SEPARATOR);
                    builder.append(m.getEmail());
                    
                }
                oneLine.append(builder.toString());
                oneLine.append(CSV_SEPARATOR);
                builder = new StringBuilder();
                List<Phone> phoneList = c.getTelephone();
                for(Phone p : phoneList){
                    if(builder.length() != 0){
                        builder.append(LIST_SEPARATOR);
                    }
                    builder.append(p.getType().getText());
                    builder.append(ELEMENT_SEPARATOR);
                    builder.append(p.getNumber());
                }
                oneLine.append(builder.toString());
                oneLine.append(CSV_SEPARATOR);
                builder = new StringBuilder();
                List<Tag> tagList = c.getTags();
                for(Tag t : tagList){
                    if(builder.length() != 0){
                        builder.append(LIST_SEPARATOR);
                    }
                    builder.append(t.getTag());
                }
                oneLine.append(builder.toString());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
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
