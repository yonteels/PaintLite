import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class sizePanel extends JPanel implements ActionListener {
    int size = 14;
    JRadioButton Small, Medium, Large;
    ButtonGroup sizeGroup; 

    // Method name: sizePanel
    // Parameter: null
    // constructor method


    public sizePanel() {
        this.setLayout(new GridLayout(1, 3));
        sizeGroup = new ButtonGroup();

        Small = new JRadioButton("Small");
        Medium = new JRadioButton("Medium");
        Large = new JRadioButton("Large");

        sizeGroup.add(Small);
        sizeGroup.add(Medium);
        sizeGroup.add(Large);

        this.add(Small);
        this.add(Medium);
        this.add(Large);

        // Add action listeners
        Small.addActionListener(this);
        Medium.addActionListener(this);
        Large.addActionListener(this);

        // Set action commands
        Small.setActionCommand("Small");
        Medium.setActionCommand("Medium");
        Large.setActionCommand("Large");

        Small.setSelected(true);
    }

    // Method name: actionPerformed
    // Parameter: ActionEvent e
    // abstract method which has been overridden from the actionlistener class

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Small")) {
            this.size = 16;
            System.out.println("Small selected");
        } else if (command.equals("Medium")) {
            this.size = 32;
            System.out.println("Medium selected");
        } else if (command.equals("Large")) {
            this.size = 64;
            System.out.println("Large selected");
        }
    }

    // getter method
    public int sizeGetter(){
        return this.size;
    }
}