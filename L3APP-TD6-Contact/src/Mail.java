/**
 * Mail entity
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Mail implements Entity{

    private Integer id;
    private String email;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Email validator
     * 
     * @return true or false according to validation
     */
    @Override
    public boolean isValide(){
        return this.email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
    }

    @Override
    public String toString() {
        return  email + "[" + type + ']';
    }
    
}
