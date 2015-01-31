
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Pierre Gaillard Orbit system - Time Machine
 */
public class Parser extends DefaultHandler {

    private Scanner sc = new Scanner(System.in);
    private StringBuffer buffer;
    private Map<Integer, List<Integer>> bonneReponse;
    private int question;
    public String[] tabRep;
    
    public Parser() {
        super();
        buffer = new StringBuffer();
        bonneReponse = new TreeMap<>();
    }

    public String[] getTabRep() {
        return tabRep;
    }
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("");
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        String lecture = new String(chars, i, i1);
        if (buffer != null) {
            buffer.append(lecture);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("question")) {
            System.out.println("------------------------------------------------------------------------");
            question = Integer.parseInt(attributes.getValue("id"));
            System.out.println("Question n° : " + question);
        }
        
        if (qName.equals("corrige")) {
            System.out.println("Correction de la question numéro "+ attributes.getValue("id"));
            System.out.println(tabRep);
            // Affichage des réponses utilisateurs (tabRep)
        }
        
        if (qName.equals("correcte")) {
            // Comparaison avec la liste utilisateurs (tabRep & BonneRéponse) & stocke en mémoire true/false
        }

        if (qName.equals("question") || qName.equals("reponses")
                || qName.equals("questions")) {
            buffer = null;
        } else {
            buffer = new StringBuffer();
        }
        if (qName.equals("reponse")) {
            System.out.print("\t " + attributes.getValue("id") + ") ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("libelle")) {
            System.out.println("Intitulé question : " + buffer);
            buffer = null;
        }
        
        if (qName.equals("correcte")) {
            // Affiche la réponse concernée 
        }
                
        if (qName.equals("corrige")) {
            //Affichage du résultat pour l'utilisateur (bon ou faux) compare de tabRep (réponse util) et bonneRéponse
            System.out.println("Vous avez donc " + " " + " à cette question !");
            buffer = null;
        }
               
        if (qName.equals("reponse")) {
            System.out.println(buffer);
            buffer = null;
        }
        
        if (qName.equals("reponses")) {
            //Affichage des compteurs (bonne réponses, mauvaises réponses, réponses vides
            buffer = null;
        }
        
        if (qName.equals("questions")) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Fin du questionnaire !");
            buffer = null;
        }

        if (qName.equals("question")) {
            try {
                InputStreamReader ist = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(ist);
                System.out.print("Votre réponse (vide ou séparées par des virgules) : ");
                String reponse = br.readLine();

                boolean co = true;
                reponse = reponse.trim();
                tabRep = reponse.split(",");
                
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
