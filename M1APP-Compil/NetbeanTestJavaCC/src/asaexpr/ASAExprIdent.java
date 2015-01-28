package asaexpr;

public class ASAExprIdent extends ASAExpr {
    
    private final String valeur;
    
    public ASAExprIdent(String valeur) {
        this.valeur = valeur;
    }
      
    @Override
    public String getLabelExplorateur() {
        return "IDENT = " + valeur;
    }
    
    @Override
    public int evalue() {
        return 0;
    }
}