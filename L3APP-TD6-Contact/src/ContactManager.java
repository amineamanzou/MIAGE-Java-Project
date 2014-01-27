import java.util.List;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface ContactManager extends EntityManager<Contact> {
    
    void importCsv(String path);
    void writeToCSV(List<Contact> contactList);
    List<Contact> findByName(String name) throws NoSuchEntityException;
    List<Contact> findByPrenom(String prenom) throws NoSuchEntityException;
    List<Contact> findBySurnom(String surnom) throws NoSuchEntityException;
    List<Contact> findByMail(String mail) throws NoSuchEntityException;
    List<Contact> findByPhone(String tel) throws NoSuchEntityException;
    List<Contact> findByTag(String tag) throws NoSuchEntityException;
    List<Contact> findBy(Integer field,String search) throws NoSuchEntityException;

}
