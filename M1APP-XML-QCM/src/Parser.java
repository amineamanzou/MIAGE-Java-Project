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
 * @author Pierre Gaillard 
 */
public class Parser extends DefaultHandler {

    private Scanner sc = new Scanner(System.in);
    private StringBuffer buffer;
    private Map<Integer, List<Integer>> bonneReponse;
    private int question;

    public Parser() {
        super();
        buffer = new StringBuffer();
        bonneReponse = new TreeMap<>();
    }

    @Override

    public void startDocument() throws SAXException {
        System.out.println("C'est parti !!!");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Et hop, c'est fini !!!");
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
            System.out.println("------------------------");
            question = Integer.parseInt(attributes.getValue("id"));
            System.out.println("Question n° : " + question);
            bonneReponse.put(question, new ArrayList());
            //if(Integer.parseInt(attributes.getValue("correction")) == 1) {
            //}
        }

        if (qName.equals("question") || qName.equals("reponses")
                || qName.equals("questionnaire")) {
            buffer = null;
        } else {
            buffer = new StringBuffer();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("intitule")) {
            System.out.println("Intitulé question : " + buffer);
            buffer = null;
        }
        if (qName.equals("reponse")) {
            System.out.println("Réponse : " + buffer);
            buffer = null;
        }

        if (qName.equals("question")) {
            try {
                InputStreamReader ist = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(ist);
                System.out.print("Réponse : ");
                String reponse = br.readLine();
                boolean co = true;
                reponse = reponse.trim();
                String[] tabRep = reponse.split(",");
                List<Integer> reponses = bonneReponse.get(question);
                int nbCorrecte = reponses.size();

                for (String rep : tabRep) {
                    if (reponses.contains(Integer.parseInt(rep))) {
                        nbCorrecte--;
                    } else {
                        co = false;
                    }
                }

                if (nbCorrecte == 0 && co) {
                    System.out.println("bonne réponse");
                } else {
                    System.out.println("Mauvaise réponse");
                }
                System.out.println("Les réponses étaient : " + reponses);
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
