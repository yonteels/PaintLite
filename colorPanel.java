import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class colorPanel extends JPanel implements ActionListener {
    private JRadioButton[] colorButtons;
    private ButtonGroup colorGroup;
    private static final String[] colorNames = {
        "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN",
        "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "YELLOW"
    };
    private static final Color[] colors = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW
    };
    private Color color = Color.BLACK;


    // Method name: colorPanel
    // Parameter: null
    // constructor method


    public colorPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridLayout(3, 4));

        colorButtons = new JRadioButton[colorNames.length];
        colorGroup = new ButtonGroup();
        
        for (int i = 0; i < colorNames.length; i++) {
            colorButtons[i] = new JRadioButton(colorNames[i]);
            colorButtons[i].setActionCommand(colorNames[i]); 
            colorButtons[i].addActionListener(this);
            colorGroup.add(colorButtons[i]);
            add(colorButtons[i]);
        }

        colorButtons[0].setSelected(true);
        this.setPreferredSize(new Dimension(900, 100));
    }


    // Method name: actionPerformed
    // Parameter: ActionEvent e
    // abstract method which has been overridden from the actionlistener class

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedColor = e.getActionCommand();
        for (int i = 0; i < colorNames.length; i++) {
            if (selectedColor.equals(colorNames[i])) {
                this.color = colors[i];
                System.out.println(this.color);
                break;
            }
        }
    }

    //getter method

    public Color getColor() {
        return this.color;
    }
}
