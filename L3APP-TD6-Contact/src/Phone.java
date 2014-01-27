/**
 * Phone entity
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Phone implements Entity{

    private Integer id;
    private String number;
    private Type type;
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
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
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
     * Phone validator
     * 
     * @return true or false according to validation
     */
    @Override
    public boolean isValide(){
        return this.number.matches("^\\+?\\d+$");
    }
    
    @Override
    public String toString() {
        return  number + "[" + type + ']';
    }
    
}
