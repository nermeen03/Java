import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDraw extends Applet{
	int[] line = new int[4];
	boolean drag = false;
	
	public void init() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                line[0] = e.getX() ;
                line[1] = e.getY();
				drag = true;
            }
            public void mouseReleased(MouseEvent e) {
                line[2] = e.getX() ;
                line[3] = e.getY();
				drag = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    line[2] = e.getX() ;
					line[3] = e.getY();
                    repaint();
                }
            }
        });
    }
	public void paint(Graphics g) {
        g.drawLine(line[0],line[1],line[2],line[3]);
    }
}