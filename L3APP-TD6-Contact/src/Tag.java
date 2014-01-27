/**
 * Tag entity
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Tag implements Entity{

    private Integer id;
    private String tag;
    private Integer userId;
    
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
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    /**
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the user id to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * Tag validator
     * 
     * @return true or false according to validation
     */
    @Override
    public boolean isValide(){
        return this.tag.matches("^[a-zA-Z\\s]+$");
    }
    
    @Override
    public String toString() {
        return "[" + tag + ']';
    }
    
}
