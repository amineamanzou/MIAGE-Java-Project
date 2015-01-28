
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierregaillard
 */
public class message implements Serializable {
    private String content;
    
    message (String num) {
        this.content = num;
    }


    /**
     * @return the content
     */
    public String getMessage() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setMessage(String content) {
        this.content = content;
    }
    
}
