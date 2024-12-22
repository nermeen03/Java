import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;
public class MovingBall extends Applet implements Runnable{
	int d = 1;
	int x = 0 ;
	int y = 0;
	boolean flag = true;
	boolean flag2 = true;
	Thread th;
	public void init(){
		th = new Thread(this);
		Button start = new Button("Start");
		Button pause = new Button("Pause");
		start.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if (d == 1) {
                th.start();
				d = 0;
            } else{
                th.resume();
            }
		}
	});
        pause.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			th.suspend();
		}
	});

        add(start);
        add(pause);
	}
	public void paint(Graphics g){
		g.fillOval(x,y, 25, 25);
	}
	public void run(){
		while(true){
			if(flag){
				if(x<getWidth()-10){
					x+=5;
				}
				else{
				flag = false;
				}
			}
			else{
				if(x>=0){
					x-=5;
				}
				else{
				flag = true;
				}
			}
			if(flag2){
				if(y<getHeight()-10){
					y+=5;
				}
				else{
				flag2 = false;
				}
			}
			else{
				if(y>=0){
					y-=5;
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
