import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Font;

public class myFontApplet2 extends Applet{
	public void paint(Graphics g){
		GraphicsEnvironment graph =  GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] str = graph.getAvailableFontFamilyNames();
		for(int i=0;i<str.length;i++){
			Font f = new Font(str[i],Font.BOLD,20);
			g.setFont(f);
			g.drawString(str[i],50,50+(30*i));
		}
	}
}