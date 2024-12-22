import java.applet.Applet;
import java.awt.Graphics;

public class twoMovingBalls extends Applet implements Runnable{
	int x = 0 ;
	int y = 0;
	int x1 = 300;
	int y1 = 300;
	boolean flag = true;
	boolean flag2 = true;
	boolean flag3 = true;
	boolean flag4 = true;
	public void init(){
		Runnable r = this;
		Thread th = new Thread(r);
		th.start();
	}
	public void paint(Graphics g){
		g.fillOval(x,y, 25, 25);
		g.fillOval(x1,y1, 25, 25);
	}
	public void run(){
		while(true){
			if(Math.abs(x1-x)<25){
				flag = !flag;
				flag3 = !flag3;
			}
			if(Math.abs(y1-y)<25){
				flag2 = !flag2;
				flag4 = !flag4;
			}
			if(flag){
				if(x<getWidth()-10){
					x+=30;
				}
				else{
				flag = false;
				}
			}
			else{
				if(x>=0){
					x-=30;
				}
				else{
				flag = true;
				}
			}
			if(flag2){
				if(y<getHeight()-10){
					y+=30;
				}
				else{
				flag2 = false;
				}
			}
			else{
				if(y>=0){
					y-=30;
				}
				else{
				flag2 = true;
				}
			}
			if(flag3){
				if(x1<getWidth()-10){
					x1+=30;
				}
				else{
				flag3 = false;
				}
			}
			else{
				if(x1>=0){
					x1-=30;
				}
				else{
				flag3 = true;
				}
			}
			if(flag4){
				if(y1<getHeight()-10){
					y1+=30;
				}
				else{
				flag4 = false;
				}
			}
			else{
				if(y1>=0){
					y1-=30;
				}
				else{
				flag4 = true;
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