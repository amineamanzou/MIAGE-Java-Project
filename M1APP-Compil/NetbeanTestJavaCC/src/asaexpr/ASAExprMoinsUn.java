package asaexpr;

public class ASAExprMoinsUn extends ASAExpr {
    
    private final ASAExpr e1;
    
    public ASAExprMoinsUn(ASAExpr e1) {
        this.e1 = e1;
    }
    
    @Override
    public ASAExpr getExpr1() {
        return e1;
    }
    
    public String getLabelExplorateur() {
        return "MOINS_UN";
    }
    
    public int evalue() {
        return -e1.evalue();
    }
}