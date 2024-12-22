import java.applet.Applet;
import java.awt.Graphics;

public class movingBall2 extends Applet implements Runnable{
	int x = 0 ;
	int y = 0;
	boolean flag = true;
	boolean flag2 = true;
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
			if(flag){
				if(x<getWidth()-10){
					x+=4;
				}
				else{
				flag = false;
				}
			}
			else{
				if(x>=0){
					x-=4;
				}
				else{
				flag = true;
				}
			}
			if(flag2){
				if(y<getHeight()-10){
					y+=4;
				}
				else{
				flag2 = false;
				}
			}
			else{
				if(y>=0){
					y-=4;
				}
				else{
				flag2 = true;
				}
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