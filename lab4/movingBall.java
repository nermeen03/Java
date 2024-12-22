import java.applet.Applet;
import java.awt.Graphics;

public class movingBall extends Applet implements Runnable{
	int x = 0 ;
	int y = 0;
	public void init(){
		Runnable r = this;
		Thread th = new Thread(r);
		th.start();
	}
	public void paint(Graphics g){
		g.fillOval(x,y, 25, 25);
	}
	public void run(){
		while(true){
			if(x<getWidth()-20){
				x+=2;
			}
			else if (x>getWidth()-20){
				x-=2;
			}
			if(y<getHeight()-10){
					y+=2;
			}
			else if (y>=getHeight()-10){
				y-=2;
			}
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			repaint();
		}
	}
}