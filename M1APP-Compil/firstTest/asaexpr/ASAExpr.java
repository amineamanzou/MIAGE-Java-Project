/*
 * ASAExpr.java
 *
 * Daniel Diaz - 2013
 *
 * Arbre Syntaxe Abstraite pour les expressions.
 */

package asaexpr;

/**
 * Cette classe represente une expression sous la forme d'un Arbre de Syntaxe Abstraite (ASA).
 */
public abstract class ASAExpr {
    
    /**
     * Access au premier fils
     * @return le premier fils
     */
    public ASAExpr getExpr1() {
        return null;
    }
    
    /**
     * Access au second fils.
     * @return le second fils.
     */
    public ASAExpr getExpr2() {     
        return null;
    }
    
    /**
     * Methode devant être definie dans chaque classe fille
     * doit retourner la chaine pour la notation explorateur.
     * @return la chaine representant le noeud
     */
    public abstract String getLabelExplorateur();
    
    /**
     * Calcule la notation explorateur de l'ASA.
     * @return la chaine contenant la notation explorateur.
     */
    
    public String notationExplorateur() {
        return notationExplorateur("");
    }
    
    private String notationExplorateur(String prefixe) {
        String res = prefixe + getLabelExplorateur() + "\n";
        String prefixeSuiv = prefixe + "   ";
        ASAExpr e1 = getExpr1();
        ASAExpr e2 = getExpr2();
        if (e1 != null) {
            res += e1.notationExplorateur(prefixeSuiv);
        }
        if (e2 != null) {
            res += e2.notationExplorateur(prefixeSuiv);
        }
        return res;
    }
}
