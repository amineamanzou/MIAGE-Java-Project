/**
 *
 * @author Amanzou Amine
 */
public class AppBanque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Compte c1;
        Compte c2;
        
        c1 = new Compte("J. DUPONT");
        printResult(c1.crediter(1000));
        c2 = new Compte("C. DURANT",50000,5000,6000);
        
        affiche(c1);
        affiche(c2);
        
        System.out.println("");
        System.out.println("Debit de c1 de 300 euros.");
        printResult(c1.debiter(300));
        System.out.println("Debit de c2 de 600 euros.");
        printResult(c2.debiter(600));
        System.out.println("Credit de c1 de 500 euros.");
        printResult(c1.crediter(500));
        
        System.out.println("");
        affiche(c1);
        affiche(c2);
        
        System.out.println("");
        System.out.println("Virement de 1000 euros de c2 à c1");
        printResult(c2.virerSomme(c1,1000));
        System.out.println("");
        
        affiche(c1);
        affiche(c2);
    }
    
    public static void affiche(Compte c){
        System.out.println("––––––––––––––––––––––––––––––");
        System.out.println("Numero de compte : \t\t" + c.getNumCompte() + "€");
        System.out.println("Nom du titulaire : \t\t" + c.getNomTitulaire());
        System.out.println("Decouvert Maximal autorise : \t" + c.getDecouvertMax() + "€");
        System.out.println("Debit Maximal autorise : \t" + c.getDebitMax() + "€");
        System.out.println("Solde du compte : \t\t" + c.getSolde() + "€");
        if(c.getSituationDecouvert()!=0) {
            System.out.println("\tAttention ce compte est a decouvert !");
        }
        System.out.println("––––––––––––––––––––––––––––––");
    }
    
    public static void printResult(boolean result) {
        if (!result) {
            System.out.println("\tEchec de l'operation !");
        }
        else
        {
            System.out.println("\tOperation effectuee !");
        }
    }
}
