package comptebanquaire;


/**
 *
 * @author Amine Amanzou
 */
public class Compte {
    
    /* Final sur une methode rend cette derniere impossible a surcharger */
    public static final String DEVISE_SIGNE = "€";
    public static final String DEVISE_LIBELLE = "Euros";
    public static final double DEFAULT_MAX_DECOUVERT = 1000;
    public static final double DEFAULT_MAX_DEBIT = 800;
    static private int NUM_COMPTE = 0;
    private int numCompte;
    private String nomTitulaire;
    private double decouvertMax;
    private double debitMax;
    private double debitAutorisee;
    private double solde;
    
    
    /*
     * Constructeur initialisant le compte au valeur par défaut
     */
    public Compte(String nom){
        this(nom,0.0,DEFAULT_MAX_DECOUVERT,DEFAULT_MAX_DEBIT);
    }
    
    /**
     * Constructeur initialisant le compte au valeur souhaite
     * 
     * @param nom Nom du titulaire du compte
     * @param depotInitial Depot a la creation du compte
     * @param decouvertMax Decouvert maximum autorise
     * @param debitMax Debit maximal autorise
     */
    public Compte(String nom, double depotInitial, double decouvertMax, double debitMax) {
        this.numCompte = NUM_COMPTE++;
        this.nomTitulaire = nom;
        this.solde = depotInitial;
        this.decouvertMax = decouvertMax;
        this.debitMax = debitMax;
    }

    public int getNumCompte() {
        return this.numCompte;
    }
    
    public String getNomTitulaire() {
        return this.nomTitulaire;
    }
    
    public double getDecouvertMax() {
        return this.decouvertMax;
    }
    
    public void setDecouvertMax(double value) {
        this.decouvertMax = value;
    }
    
    public double getDebitMax() {
        return this.debitMax;
    }
    
    public void setDebitMax(double value) {
        this.debitMax = value;
    }

    public double getSolde() {
        return this.solde;
    }
    
    public boolean getSituationDecouvert() {
        if(this.solde < 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Operation consistant a ajouter un montant positif au solde du compte
     * 
     * @return boolean Succes ou echec de l'operation
     */
    public boolean crediter(double value) {
        if ( value > 0 ) {
            this.solde += value;
            return true;
        }
        return false;
    }
    
    /**
     * Operation consistant a soustraire un montant positif au solde tout en respectant le debit maximal
     * ainsi que le découvert maximal autorise
     * 
     * @param double value Montant a debiter
     * @return boolean Succes ou echec de l'operation
     */
    public boolean debiter(double value) {
        double soldeResultant;
        if ( value > 0 ) {
            soldeResultant = this.solde - value;
            if ( value <= this.debitMax ) {
                if ( soldeResultant > this.decouvertMax*-1 ) {
                    this.solde = soldeResultant;
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
     * Calcul le montant max pouvant etre retire
     * 
     * @return Montant maximum
     */
    public double montantMaxADebiter() {
        return Math.min(this.debitMax,this.decouvertMax+this.solde);
    }
    
    /*
     * Operation consistant a effectuer un virement d'une somme vers un autre compte
     * 
     * @return boolean Succes ou echec de l'operation
     */
    public boolean virerSomme(Compte dest, double value) {
        if ( this.debiter(value) ) {
            return false;
        }
        if ( dest.crediter(value) ) {
            return false;
        }
        return true;
    }
}
