package asaexpr;

public class ASAExprMod extends ASAExpr {
    
    private final ASAExpr e1;
    private final ASAExpr e2;
    
    public ASAExprMod(ASAExpr e1, ASAExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @Override
    public ASAExpr getExpr1() {
        return e1;
    }
    
    @Override
    public ASAExpr getExpr2() {
        return e2;
    }
    public String getLabelExplorateur() {
        return "MOD";
    }
    
    public int evalue() {
        return e1.evalue()%e2.evalue();
    }
}