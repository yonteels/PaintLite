import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class SettingPanel extends JPanel {
    private brushPanel bp;  
    private colorPanel cp;
    private sizePanel sp;

    // Method name: SettingPanel
    // Parameter: canvasPanel canvas
    // constructor method


    public SettingPanel(canvasPanel canvas) { 
        System.out.println("SettingPanel created");
        this.setPreferredSize(new Dimension(1200, 150));
        this.setLayout(new GridLayout(1, 3));

        bp = new brushPanel(canvas); 
        cp = new colorPanel();
        sp = new sizePanel();

        this.add(bp);
        this.add(cp);
        this.add(sp);
    }

    // getter method
    public brushPanel getBrushPanel() {
        return bp;
    }

    public colorPanel getColorPanel() {
        return cp;
    }

    public sizePanel getSizePanel() {
        return sp;
    }
}
