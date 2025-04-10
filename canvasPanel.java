import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class canvasPanel extends JPanel implements MouseListener, MouseMotionListener {
    private SettingPanel setp;
    private ArrayList<ColoredPoint> points = new ArrayList<>();
    private int size;


    // Method name: canvasPanel
    // Parameter: SettingPanel setp
    // constructor method which take in a reference of settingPanel setp 
    public canvasPanel(SettingPanel setp) {
        this.setp = setp;
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(1200, 600));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.size = setp.getSizePanel().sizeGetter();
    }


    // Method name: paintComponent
    // Parameter: Graphics g
    // paint component method which allow panel to be drawable
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (ColoredPoint p : points) {
            g.setColor(p.color);  // Use the stored color
            g.fillOval(p.point.x - 5, p.point.y - 5, p.size, p.size);
        }
    }


    // Method name: mousePressed
    // Parameter: MouseEvent e
    // abstract method from mouse listener which allow for listening to mouse click
    @Override
    public void mousePressed(MouseEvent e) {
        if (this.setp.getBrushPanel().getBrush()) {
            this.size = setp.getSizePanel().sizeGetter();
            Color currentColor = setp.getColorPanel().getColor(); // Get the current color

            points.add(new ColoredPoint(new Point(e.getX(), e.getY()), currentColor, this.size));
            repaint();

            System.out.println(currentColor);
        }

        if (this.setp.getBrushPanel().getEraser()) {
            int eraserSize = setp.getSizePanel().sizeGetter();
            points.removeIf(p -> p.point.distance(e.getX(), e.getY()) < eraserSize);
            repaint();
        }
    }

    // Method name: mouseDragged
    // Parameter: MouseEvent e
    // abstract method from mouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.setp.getBrushPanel().getBrush()) {
            Color currentColor = setp.getColorPanel().getColor(); // Store color at the time of drawing
            points.add(new ColoredPoint(new Point(e.getX(), e.getY()), currentColor, this.size));
            repaint();
        }

        if (this.setp.getBrushPanel().getEraser()) {
            int eraserSize = setp.getSizePanel().sizeGetter();
            points.removeIf(p -> p.point.distance(e.getX(), e.getY()) < eraserSize);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}


    // Method name: clearCanvas
    // Parameter: null
    // clear the canvasPanel
    public void clearCanvas(){
        points.clear();
        repaint();
    }

    // Method name: setSettingPanel
    // Parameter: SettingPanel setp
    // setter method to set and update settingPanel 

    public void setSettingPanel(SettingPanel setp) {
        this.setp = setp;
    }
}
