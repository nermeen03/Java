import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragBall extends Applet {
    int x = 0;
    int y = 0; 
    boolean drag = false;
    public void init() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= x && e.getX() <= x + 25 && e.getY() >= y && e.getY() <= y + 25) {
					drag = true;
				}
            }
            public void mouseReleased(MouseEvent e) {
                drag = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    x = e.getX() ;
                    y = e.getY();
                    repaint();
                }
            }
        });
    }
    public void paint(Graphics g) {
        g.fillOval(x, y, 25, 25);
    }
}
