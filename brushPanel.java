import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class brushPanel extends JPanel implements ActionListener {

    JRadioButton Brush, Eraser;
    ButtonGroup brushGroup; 
    private boolean brushSelected;
    private boolean  eraserSelected;
    private canvasPanel cp;
    JButton clear;

    // Method name: brushPanel
    // Parameter: canvasPanel cp
    // constructor method


    brushPanel(canvasPanel cp) {
        this.cp = cp;
        this.setLayout(new GridLayout(1, 3));
        brushGroup = new ButtonGroup();

        Brush = new JRadioButton("Brush");
        Eraser = new JRadioButton("Eraser");
        clear = new JButton("Clear All");


        brushGroup.add(Brush);
        brushGroup.add(Eraser);


        this.add(Brush);
        this.add(Eraser);
        this.add(clear);


        // Add action listeners
        Brush.addActionListener(this);
        Eraser.addActionListener(this);
        clear.addActionListener(this);

        // Set action commands
        Brush.setActionCommand("Brush");
        Eraser.setActionCommand("Eraser");
        clear.setActionCommand("Clear");

        Brush.setSelected(true);
        brushSelected = true;  
        eraserSelected = false;
    }

    // Method name: actionPerformed
    // Parameter: ActionEvent e
    // abstract method which has been overridden from the actionlistener class
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Brush")) {
            this.brushSelected = true;
            this.eraserSelected = false;
        } else if (command.equals("Eraser")) {
            this.eraserSelected = true;
            this.brushSelected = false;
        } else if (e.getSource() == clear) {
            cp.clearCanvas();
        }

    }

    //getter
    public boolean getEraser(){
        return this.eraserSelected;
    }

    public boolean getBrush(){
        return this.brushSelected;
    }
}