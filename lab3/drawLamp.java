import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class drawLamp extends Applet {
    private boolean colorsChanged = false;

    public void init() {
		Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorsChanged = !colorsChanged;
                repaint();
            }
        });
        timer.start();
		
    }

    public void paint(Graphics g) {
        if (colorsChanged) {
            g.drawOval(50, 50, 150, 65);
            g.setColor(Color.GREEN);
            g.drawOval(50, 50, 150, 65);
            g.drawLine(50, 88, 20, 200);
            g.drawLine(200, 88, 230, 200);
            g.drawArc(20, 150, 210, 100, 180, 180);
			g.setColor(Color.RED);
            g.drawLine(100, 250, 80, 350);
            g.drawLine(150, 250, 170, 350);
            g.drawRect(20, 350, 220, 50);

            g.setColor(Color.GREEN);
            g.fillOval(40, 140, 30, 75);
            g.fillOval(105, 140, 35, 90);
            g.fillOval(175, 140, 30, 75);
        } else {
            g.drawOval(50, 50, 150, 65);
            g.setColor(Color.RED);
            g.drawOval(50, 50, 150, 65);
            g.drawLine(50, 88, 20, 200);
            g.drawLine(200, 88, 230, 200);
            g.drawArc(20, 150, 210, 100, 180, 180);
            g.drawLine(100, 250, 80, 350);
            g.drawLine(150, 250, 170, 350);
            g.drawRect(20, 350, 220, 50);

            g.setColor(Color.MAGENTA);
            g.fillOval(40, 140, 30, 75);
            g.fillOval(105, 140, 35, 90);
            g.fillOval(175, 140, 30, 75);
        }
    }
}
 