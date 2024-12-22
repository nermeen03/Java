import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDraw2 extends Applet{
	int[] line = new int[4];
	int[] line2 = new int[4];
	int[] line3 = new int[4];
	boolean drag = false;
	
	boolean l1= false;
	boolean l2= false;
	boolean l3= false;
	
	public void init() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
				if (line[0]==0 && line[1]==0) {
                    line[0] = e.getX();
                    line[1] = e.getY();
                    drag = true;
					l1 = true;
                }
                else if(line2[0]==0 && line2[1]==0) {
                    line2[0] = e.getX();
                    line2[1] = e.getY();
                    drag = true;
					l2 = true;
                }
                else if(line3[0]==0 && line3[1]==0) {
                    line3[0] = e.getX();
                    line3[1] = e.getY();
                    drag = true;
					l3 = true;
                }
            }
            public void mouseReleased(MouseEvent e) {
				if(l1){
					line[2] = e.getX();
					line[3] = e.getY();
					l1 = false;
				}
				else if(l2){
					line2[2] = e.getX();
					line2[3] = e.getY();
					l2 = false;
				}
				else if(l3){
					line3[2] = e.getX();
					line3[3] = e.getY();
					l3 = false;
				}
				drag = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    if (l1) {
                        line[2] = e.getX();
                        line[3] = e.getY();
                    } else if (l2) {
                        line2[2] = e.getX();
                        line2[3] = e.getY();
                    } else if (l3) {
                        line3[2] = e.getX();
                        line3[3] = e.getY();
                    }
                    repaint();
			}}
        });
    }
	public void paint(Graphics g) {
            g.drawLine(line[0], line[1], line[2], line[3]);
            g.drawLine(line2[0], line2[1], line2[2], line2[3]);
            g.drawLine(line3[0], line3[1], line3[2], line3[3]);
    }
}