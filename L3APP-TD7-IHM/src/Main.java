import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        JLabel title = new JLabel("TITRE");
        JLabel jour = new JLabel("JOUR");
        JLabel nuit = new JLabel("NUIT");
        JLabel jour1 = new JLabel("JOUR");
        JLabel nuit1 = new JLabel("NUIT");
        JLabel jour2 = new JLabel("JOUR");
        JLabel nuit2 = new JLabel("NUIT");
        final JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource();
                if(source == button){
                    if(button.getText().equals("OK")){
                        button.setText("Clicked");
                    } else {
                        button.setText("OK");
                    }
                }
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });      

        BorderLayout layout = new BorderLayout();
        GridLayout grid = new GridLayout(4,1);
        
        JPanel panel = new JPanel();
        JPanel panelEst = new JPanel();
        panel.setLayout(layout);
        panelEst.setLayout(grid);
        
        f.setContentPane(panel);
        panel.add(title,NORTH);
        panel.add(button,SOUTH);
        panel.add(jour,WEST);
        panel.add(nuit,CENTER);
        panel.add(panelEst,EAST);
        panelEst.add(jour1);
        panelEst.add(nuit1);
        panelEst.add(jour2);
        panelEst.add(nuit2);
        
        f.revalidate();
        f.repaint();
    }
    
}
