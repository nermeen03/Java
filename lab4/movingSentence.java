import java.applet.Applet;
import java.awt.Graphics;

public class movingSentence extends Applet implements Runnable{
	int x = 0 ;
	public void init(){
		Runnable r = this;
		Thread th = new Thread(r);
		th.start();
	}
	public void paint(Graphics g){
		if(x<getWidth()-70){
				g.drawString("this is java",x,200);
				x+=20;
		}
		else{
			x=0;
		}
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