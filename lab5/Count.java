import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;


public class Count extends Applet{
	int count;
	public void init(){
		count = 0;
		Button inc = new Button("increment");
		Button dec = new Button("decrement");
		inc.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count++;
			repaint();
		}
	});
		dec.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count--;
			repaint();
		}
	});
		add(inc);
		add(dec);
		
	}
	public void paint(Graphics g){
		g.drawString("counter = " + count,50,50);
	}
		
}