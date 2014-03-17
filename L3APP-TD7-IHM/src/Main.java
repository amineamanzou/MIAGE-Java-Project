import javax.swing.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre f = new Fenetre();
        JLabel label = new JLabel("Label");
        JButton button = new JButton("Button");
        JPanel panelSup = new JPanel();
        f.setContentPane(panelSup);
        panelSup.add(label);
        panelSup.add(button);
    }
    
}
