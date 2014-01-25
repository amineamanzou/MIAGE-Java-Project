/**
 * Type enumeration for phone and mail entity
 * 
 * @author Amanzou Amine
 */
enum Type {
       
    PRO("P"),
    MOBILE("M"),
    FIXE("F");


    private String text;

    Type(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Type fromString(String text) {
        if (text != null) {
            for (Type b : Type.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}
