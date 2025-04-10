import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class labelPanel extends JPanel{

    // Method name: JLabel
    // Parameter: null
    // constructor method
    
    private static JLabel sizeLabel, brushLabel, colorLabel;
    labelPanel(){
        this.setPreferredSize(new Dimension(1200, 50));
        this.setLayout(new GridLayout(1,3));
        this.setBackground(Color.PINK);
        sizeLabel = new JLabel("Size Selector");
        brushLabel = new JLabel("Brush Selector");
        colorLabel = new JLabel("Color Selector");

        this.add(brushLabel);
        this.add(colorLabel);
        this.add(sizeLabel);
    }
    
}
