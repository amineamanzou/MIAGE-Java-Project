import java.util.Scanner;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Parser extends DefaultHandler {

    private StringBuffer buffer;

    public Parser() {
        super();
        buffer = new StringBuffer();
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
            int id = Integer.parseInt(attributes.getValue("id"));
            System.out.println("Question n° : " + id);
            System.out.println();
        }
        if (qName.equals("reponse")) {
            int id = Integer.parseInt(attributes.getValue("id"));
            String reponse = attributes.getQName(id);
            System.out.println("--> Réponse n°" + id + ": ");
        }
        if (qName.equals("reponse")) {
            System.out.println("\t \t" + buffer);
            buffer = null;
        }
        if (qName.equals("question")) {
            buffer = null;
        } else {
            buffer = new StringBuffer();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("question")) {       
            input();
        }
    }

    public String input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}