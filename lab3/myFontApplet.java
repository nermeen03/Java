import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;

public class myFontApplet extends Applet{
	public void paint(Graphics g){
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		String[] str = toolkit.getFontList();
		for(int i=0;i<str.length;i++){
			Font f = new Font(str[i],Font.BOLD,20);
			g.setFont(f);
			g.drawString(str[i],50,50+(30*i));
		}
	}
}