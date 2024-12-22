import java.applet.Applet;
import java.awt.Button;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.event. KeyListener;

public class MovingText extends Applet{
	int x = 50;
	int y = 50;
	public void init(){
		addKeyListener(new MyListener());
	}
		
	
	public void paint(Graphics g){
		g.drawString("This is java",x,y);
	}
	
	class MyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_UP){
				y-=5;
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				y+=5;
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT){
				x-=5;
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				x+=5;
				repaint();
			}
		}
	}
}