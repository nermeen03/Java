import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class digitalWatch extends Applet implements Runnable{
	public void init(){
		Runnable r = this;
		Thread th = new Thread(r);
		th.start();
	}
	public void paint(Graphics g){
		Date d = new Date();
		g.drawString(d.toString(),50,50);
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			repaint();
		}
	}
}