import java.util.Random;

/**
 *
 * @author Amine Amanzou
 */
public class Compte {
    
    private int numCompte;
    private String nomTitulaire;
    private float decouvertMax;
    private float debitMax;
    private float situationDecouvert;
    private float debitAutorisee;
    private float solde;
    
    /*
     * Constructeur initialisant le compte au valeur souhaité
     */
    public Compte(String nom, float depotInitial, float decouvertMax, float debitMax) {
        Random r = new Random();
        this.numCompte = r.nextInt();
        if( this.numCompte < 0 ) {
            this.numCompte*=-1;
        }
        this.nomTitulaire = nom;
        this.solde = depotInitial;
        this.decouvertMax = decouvertMax;
        this.debitMax = debitMax;
        this.situationDecouvert = 0;
    }
    
    /*
     * Constructeur initialisant le compte au valeur par défaut
     */
    public Compte(String nom){
        Random r = new Random();
        this.numCompte = r.nextInt();
        if( this.numCompte < 0 ) {
            this.numCompte*=-1;
        }
        this.nomTitulaire = nom;
        this.solde = 0;
        this.debitMax = 1000;
        this.decouvertMax = 800;
        this.situationDecouvert = 0;
    }

    public int getNumCompte() {
        return this.numCompte;
    }
    
    public String getNomTitulaire() {
        return this.nomTitulaire;
    }
    
    public float getDecouvertMax() {
        return this.decouvertMax;
    }
    
    public void setDecouvertMax(float value) {
        this.decouvertMax = value;
    }
    
    public float getDebitMax() {
        return this.debitMax;
    }
    
    public void setDebitMax(float value) {
        this.debitMax = value;
    }

    public float getSolde() {
        return this.solde;
    }
    
    public void setSolde(float value) {
        this.solde = value;
    }
    
    public float getSituationDecouvert() {
        return this.situationDecouvert;
    }
    
    /*
     * Operation consistant a ajouter un montant positif au solde du compte
     * 
     * @return boolean Succes ou echec de l'operation
     */
    public boolean crediter(float value) {
        if ( value > 0 ) {
            this.solde += value;
            if ( this.solde >= 0) {
                this.situationDecouvert = 0;
            }
            else {
                this.situationDecouvert = this.solde*-1;
            }
            return true;
        }
        return false;
    }
    
    /*
     * Operation consistant a soustraire un montant positif au solde tout en respectant le debit maximal
     * ainsi que le découvert maximal autorise
     * 
     * @return boolean Succes ou echec de l'operation
     */
    public boolean debiter(float value) {
        float soldeResultant;
        if ( value > 0 ) {
            soldeResultant = this.solde - value;
            if ( value <= this.debitMax ) {
                if ( soldeResultant > this.decouvertMax*-1 ) {
                    this.setSolde(soldeResultant);
                    if (this.solde < 0) {
                        this.situationDecouvert = this.solde*-1;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
     * Operation consistant a effectuer un virement d'une somme vers un autre compte
     * 
     * @return boolean Succes ou echec de l'operation
     */
    public boolean virerSomme(Compte dest, float value) {
        boolean result;
        result = this.debiter(value);
        dest.crediter(value);
        return result;
    }
}
