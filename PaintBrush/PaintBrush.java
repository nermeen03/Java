import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

class Shape{
	private int point1;
	private int point2;
	private int point3;
	private int point4;
	private int color;
	private int shape;
	private boolean filled;
	private boolean dotted;
	public Shape(){}
	public Shape(int x,int y,boolean n,boolean m){
		shape=x;
		color=y;
		filled=n;
		dotted=m;
	}
	public void setPoint1(int x){
		point1 = x;
	}
	public int getPoint1(){
		return point1;
	}
	public void setPoint2(int x){
		point2 = x;
	}
	public int getPoint2(){
		return point2;
	}
	public void setPoint3(int x){
		point3 = x;
	}
	public int getPoint3(){
		return point3;
	}
	public void setPoint4(int x){
		point4 = x;
	}
	public int getPoint4(){
		return point4;
	}
	public void setColor(int c){
		color = c;
	}
	public int getColor(){
		return color;
	}
	public void setShape(int s){
		shape = s;
	}
	public int getShape(){
		return shape;
	}
	public void setDotted(boolean d){
		dotted=d;
	}
	public boolean getDotted(){
		return dotted;
	}
	public void setFilled(boolean d){
		filled=d;
	}
	public boolean getFilled(){
		return filled;
	}
	
}

public class PaintBrush extends Applet{
	ArrayList <Shape> points = new ArrayList<Shape>();
	ArrayList <Shape> temp = new ArrayList<Shape>();
	ArrayList <Shape> temp2 = new ArrayList<Shape>();
	private Shape draw = new Shape();
	private int shape = 0;
	private int color = 0;
	private boolean checkflage = false;
	private boolean dotflage = false;
	private boolean drag = false;
	private boolean clearflag = false;
	private boolean eraserflag = false;

	public void init(){ 
		Button undo = new Button("undo");
		Button eraser = new Button("eraser");
		Button clear = new Button("clear all");
		Button pen = new Button("pen");
		Button rectangle = new Button("rectangle");
		Button oval = new Button("oval");
		Button line = new Button("line");
		Button red = new Button("red");
		Button green = new Button("green");
		Button blue = new Button("blue");
		Checkbox check = new Checkbox("fill",null,false);
		Checkbox dot = new Checkbox("dotted",null,false);
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(eraserflag == false){
					draw.setPoint1(e.getX());
					draw.setPoint2(e.getY());
				}
			}
			public void mouseReleased(MouseEvent e){
				drag = false;
				points.add(draw);
				draw = new Shape(draw.getShape(),draw.getColor(),checkflage,dotflage);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e) {
				if (eraserflag == false) {
					if (draw.getShape() == 0) { 
						int lastX = draw.getPoint1();
						int lastY = draw.getPoint2();
						if (lastX != -1 && lastY != -1) {
							Shape tempDraw = new Shape();
							tempDraw.setShape(3);  
							tempDraw.setPoint1(lastX);
							tempDraw.setPoint2(lastY);
							tempDraw.setPoint3(e.getX());
							tempDraw.setPoint4(e.getY());
							tempDraw.setColor(draw.getColor());
							tempDraw.setDotted(dotflage);
							tempDraw.setFilled(false);
							points.add(tempDraw); 
						}
						draw.setPoint1(e.getX());
						draw.setPoint2(e.getY());
					}
					drag = true;
					draw.setPoint3(e.getX());
					draw.setPoint4(e.getY());
				}
				else {
					int x = e.getX();
					int y = e.getY();
					for (int i = points.size() - 1; i >= 0; i--) {
						Shape s = points.get(i);
							int minX = Math.min(s.getPoint1(), s.getPoint3());
							int maxX = Math.max(s.getPoint1(), s.getPoint3());
							int minY = Math.min(s.getPoint2(), s.getPoint4());
							int maxY = Math.max(s.getPoint2(), s.getPoint4());
							if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
								temp2.add(s);
								points.remove(i);
								break;
							}
					}
				}
				repaint();
			}
		});
		
		eraser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraserflag = true;
			}
		});
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(clearflag && points.size() == 0){
					points = new ArrayList<>(temp);
					clearflag = false;
				}
				else if(eraserflag){
					points.add(temp2.remove(temp2.size()-1));
				}
				else{
					points.remove(points.size() - 1);
				}
				repaint();
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clearflag = true;
				temp = new ArrayList<>(points);
				points.clear();
				repaint();
			}
		});
		
		rectangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraserflag = false;
				draw.setShape(1);
			}
		});
		oval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraserflag = false;
				draw.setShape(2);
			}
		});
		line.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraserflag = false;
				draw.setShape(3);
			}
		});
		pen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraserflag = false;
				draw.setShape(0); 
				draw.setPoint1(-1);
			}
		});
		
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.setColor(1);
			}
		});
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.setColor(2);
			}
		});
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.setColor(3);
			}
		});
		check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					checkflage = true; 
				} else {
					checkflage = false; 
				}
				draw.setFilled(checkflage);
			}
		});
		
		dot.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					dotflage = true;
				} else {
					dotflage = false; 
				}
			}
		});
		
		add(undo);
		add(eraser);
		add(clear);
		add(pen);
		add(rectangle);
		add(oval);
		add(line);
		add(red);
		add(green);
		add(blue);
		add(check);
		add(dot);
	}
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		for (Shape s : points){
			if(s.getColor() == 1){
				g.setColor(Color.RED);
			}
			else if(s.getColor() == 2){
				g.setColor(Color.GREEN);
			}
			else if(s.getColor() == 3){
				g.setColor(Color.BLUE);
			}
			else if(s.getColor() == 4){
				g.setColor(Color.WHITE);
			}
			if (s.getDotted()) {
				float[] dash = {5.0f};
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
			} else {
				g2d.setStroke(new BasicStroke());
			}
			if (s.getShape() == 3) {
                g.drawLine(s.getPoint1(), s.getPoint2(), s.getPoint3(), s.getPoint4());
            }
			else{
				int width = Math.abs(s.getPoint3() - s.getPoint1());
				int height = Math.abs(s.getPoint4() - s.getPoint2());
				int x = Math.min(s.getPoint1(), s.getPoint3());
				int y = Math.min(s.getPoint2(), s.getPoint4());
				if (s.getShape() == 1) {
					if (!s.getFilled()) {
						g.drawRect(x, y, width, height);
					} else {
						g.fillRect(x, y, width, height);
					}
				} 
				else if (s.getShape() == 2) {
					if (!s.getFilled()) {
						g.drawOval(x, y, width, height);
					} else {
						g.fillOval(x, y, width, height);
					}
				}
            } 	
		}
		
		if(drag){
			if(draw.getColor() == 1){
				g.setColor(Color.RED);
			}
			else if(draw.getColor() == 2){
				g.setColor(Color.GREEN);
			}
			else if(draw.getColor() == 3){
				g.setColor(Color.BLUE);
			}
			else if(draw.getColor() == 4){
				g.setColor(Color.WHITE);
			}
			if (dotflage) {
				float[] dash = {5.0f};
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
			} else {
				g2d.setStroke(new BasicStroke());
			}
		
			if (draw.getShape() == 3) {
                g.drawLine(draw.getPoint1(), draw.getPoint2(), draw.getPoint3(), draw.getPoint4());
            }
			else{
				int width = Math.abs(draw.getPoint3() - draw.getPoint1());
				int height = Math.abs(draw.getPoint4() - draw.getPoint2());
				int x = Math.min(draw.getPoint1(), draw.getPoint3());
				int y = Math.min(draw.getPoint2(), draw.getPoint4());
				if (draw.getShape() == 1) {
					if (!checkflage) {
						g.drawRect(x, y, width, height);
					} else {
						g.fillRect(x, y, width, height);
					}
				} 
				else if (draw.getShape() == 2) {
					if (!checkflage) {
						g.drawOval(x, y, width, height);
					} else {
						g.fillOval(x, y, width, height);
					}
				}
            } 
		}
	}
}
		