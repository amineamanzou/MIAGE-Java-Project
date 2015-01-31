
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static sun.security.krb5.Confounder.bytes;

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
    public static void main(String[] args) throws SAXException, Exception {
        if (args.length < 2) {
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
            File output = Readfiles.appendFiles(questions.getAbsolutePath(), answers.getAbsolutePath());

            Parser gestionnaire = new Parser();
            parseur.parse(questions, gestionnaire);
            String[] tabrep = gestionnaire.getTabRep();
            System.out.println(tabrep[0].toString());
            // utiliser SET/GET pour passer le tableau de réponse .
            
        } catch (ParserConfigurationException pce) {
            System.out.println("Erreur de configuration du parseur");
            System.out.println("Lors de l'appel à newSAXParser()");
        } catch (SAXException se) {
            se.printStackTrace();
            System.out.println("Erreur de parsing");
            System.out.println("Lors de l'appel à parse()");
        }
    }

}
