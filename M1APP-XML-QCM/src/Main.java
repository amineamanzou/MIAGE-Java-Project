import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Pierre Gaillard
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws SAXException {
        if(args.length < 2)
        {
            System.out.println("Error usage : java Qcm ./filenameQuestion ./filenameAnswer");
            System.exit(0);
        }

        try {
            // création d'une fabrique de parseurs SAX
            SAXParserFactory fabrique = SAXParserFactory.newInstance();
            // création d'un parseur SAX
            SAXParser parseur = fabrique.newSAXParser();
            // lecture d'un fichier XML avec un DefaultHandler
            File questions = new File(args[0]);
            File answers = new File(args[1]);
            DefaultHandler gestionnaire = new Parser();
            parseur.parse(questions, gestionnaire);
        } catch (ParserConfigurationException pce) {
            System.out.println("Erreur de configuration du parseur");
            System.out.println("Lors de l'appel à newSAXParser()");
        } catch (SAXException se) {
            se.printStackTrace();
            System.out.println("Erreur de parsing");
            System.out.println("Lors de l'appel à parse()");
        } catch (IOException ioe) {
            System.out.println("Erreur d'entrée/sortie");
            System.out.println("Lors de l'appel à parse()");
        }
    }
    
}