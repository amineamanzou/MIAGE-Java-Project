import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Entity manager implementation in temp memory
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 * @param <E>
 */
public class EntityManagerInMemory<E extends Entity> implements EntityManager<E>{

    private Map<Integer,E> liste;
    private Integer count;
    
    /**
     *
     */
    public EntityManagerInMemory(){
        liste = new HashMap();
        count = 0;
    }
    
    @Override
    public E findById(Integer id) throws NoSuchEntityException{
        exists(id);
        return liste.get(id);
    }

    @Override
    public void save(E entity) throws NoSuchEntityException {
        if(entity.getId() == null){
            if(entity.isValide()){
                count++;   
                entity.setId(count);
            }
        }else{
           exists(entity);      
        }
        if(entity.isValide()){
            liste.put(count, entity);
        }
    }

    @Override
    public void remove(E entity) throws NoSuchEntityException {
        exists(entity);
        if(entity!=null){
            liste.remove(entity.getId());
        }
    }

    @Override
    public List<E> findAll() {
        return new ArrayList<E>(liste.values());
    }
    
    @Override
    public boolean validate(E entity) throws NoSuchEntityException{
        exists(entity);
        return entity.isValide();
    }
    
    @Override
    public void flush() {
        
    }
    
    private void exists(E entity) throws NoSuchEntityException{
         exists(entity.getId());
    }
    private void exists(Integer id) throws NoSuchEntityException{
         if(!liste.containsKey(id)){
               throw new NoSuchEntityException();
         }
    }

    
}
