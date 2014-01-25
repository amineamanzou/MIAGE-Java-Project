/**
 * Sexe enumeration for Contact Entity
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
enum Sexe {
       
    Homme("H"),
    Femme("F");


    private String text;

    Sexe(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Sexe fromString(String text) {
        if (text != null) {
            for (Sexe b : Sexe.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}
