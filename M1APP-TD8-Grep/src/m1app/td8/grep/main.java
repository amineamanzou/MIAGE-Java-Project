/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1app.td8.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("First Exercice Grep like function");
        
        System.out.println("==============Au moins 5 :================");
        grep("^([^i]*i){5,}[^i]*$","src/fr-dico.txt");
        System.out.println("==============Exactement 5 i :================");
        grep("^([^i]*i){5}[^i]*$","src/fr-dico.txt");
        System.out.println("================gras, gris ou gros :================");
        grep("gr[aio]s","src/fr-dico.txt");
        System.out.println("================Commence et finis par m , b , p :================");
        grep("^(m|b|p).*\\1$","src/fr-dico.txt");
        System.out.println("================Commence et fini par 3 même lettre :================");
        grep("^(...).*\\1$","src/fr-dico.txt");
        
        System.out.println("===========================================================");
        System.out.println("Second Exercice Sed like function");
        substit("^([0-9]{8}),([0-9]{8}),([^,].*),\"(.*)\"$","","src/feries.txt");
    }
    
    public static void grep(String regex, String nomFichier) {
        Pattern p = Pattern.compile(regex);
 
        try{
            BufferedReader buff = new BufferedReader(new FileReader(nomFichier));

            try {
                String line;
                while ((line = buff.readLine()) != null) {
                    Matcher m = p.matcher(line);
                    if(m.find())
                        System.out.println(line);
                }
            } finally {
                buff.close();
            }
        } catch (IOException ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        
    }
    
    public static void substit(String regex, String repl, String nomFichier){
        Pattern p = Pattern.compile(regex);
 
        try{
            BufferedReader buff = new BufferedReader(new FileReader(nomFichier));

            try {
                String line;
                while ((line = buff.readLine()) != null) {
                    Matcher m = p.matcher(line);
                    if(m.find())
                        System.out.println(m.replaceAll("$1 $2 $4"));
                }
            } finally {
                buff.close();
            }
        } catch (IOException ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        
    }
    
}
