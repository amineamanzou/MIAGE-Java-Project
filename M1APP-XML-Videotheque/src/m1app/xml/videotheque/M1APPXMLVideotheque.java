/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1app.xml.videotheque;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class M1APPXMLVideotheque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        try {
            FileInputStream file = new FileInputStream(new File("src/video.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
 
            XPath xPath =  XPathFactory.newInstance().newXPath();
 
            String expression = "/videotheque/film/titre";
            System.out.println("*************************");
            System.out.println(expression);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            expression = "/videotheque/film[realisateur='Clint Eastwood']/titre";
            System.out.println("*************************");
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            expression = "/videotheque/film[realisateur='Quentin Tarantino' or ./acteurs/acteur='Quentin Tarantino']/titre";
            System.out.println("*************************");
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            expression = "/videotheque/film[realisateur='Quentin Tarantino' and ./acteurs/acteur='Quentin Tarantino']/titre";
            System.out.println("*************************");
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            System.out.println("*************************");
            expression = "/videotheque/film[@annee > '1990']/descendant-or-self::*";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            System.out.println("*************************");
            expression = "/videotheque/film[count(./acteurs/acteur)>=3]/descendant-or-self::*";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if( nodeList.getLength() > 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
                }
            }
            else {
                System.out.println("Pas de résultat.");   
            }
            
            System.out.println("*************************");
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }       
    }
    
}
