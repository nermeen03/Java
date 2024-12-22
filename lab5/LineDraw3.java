import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LineDraw3 extends Applet{
	ArrayList<int[]> lines = new ArrayList<>();
	int[] line = new int[4];
	boolean drag = false;
	
	
	public void init() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
				line[0] = e.getX();
                line[1] = e.getY();
				line[2] = e.getX();
                line[3] = e.getY();
				drag = true;
            }
            public void mouseReleased(MouseEvent e) {
				line[2] = e.getX();
                line[3] = e.getY();
                lines.add(line);
                line = new int[4];
                drag = false;
                repaint(); 
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    line[2] = e.getX();
                    line[3] = e.getY();
                    repaint();
			}}
        });
    }
	public void paint(Graphics g) {
		for (int[] l : lines) {
			g.drawLine(l[0], l[1], l[2], l[3]);
		}
		if (drag) {
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
    }
}