import java.awt.*;

import javax.swing.*;

public class Project2Runner extends JFrame{
    
    
    static JFrame frame;

    public static void main(String[] args) {

        // Frame
        frame = new JFrame("Paint-Lite");

        // Setting Panel
        SettingPanel setp = new SettingPanel(null);

        // Create canvasPanel 
        canvasPanel cp = new canvasPanel(setp);
        
        //reference
        setp = new SettingPanel(cp);

        cp.setSettingPanel(setp); //reference 

        
        labelPanel lp = new labelPanel();

        // frame component
        frame.setLayout(new BorderLayout());
        frame.add(lp, BorderLayout.NORTH);
        frame.add(setp, BorderLayout.CENTER);  
        frame.add(cp, BorderLayout.SOUTH);


        // frame setting
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
