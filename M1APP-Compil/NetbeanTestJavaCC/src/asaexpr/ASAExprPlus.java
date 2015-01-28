package asaexpr;

public class ASAExprPlus extends ASAExpr {
    
    private final ASAExpr e1;
    private final ASAExpr e2;
    
    public ASAExprPlus(ASAExpr e1, ASAExpr e2) {
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
        return "PLUS";
    }
    
    public int evalue() {
        return e1.evalue()+e2.evalue();
    }
}