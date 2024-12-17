class Complex{
	private int real;
	private int img;
	public void setReal(int real){
		this.real=real;
	}
	public void setImg(int img){
		this.img=img;
	}
	public int getReal(){return real;}
	public int getImg(){return img;}
}
class Main{
	public static void main(String[] args){
		Complex obj1 = new Complex();
		Complex obj2 = new Complex();
		
		String[] str = args[0].split("\\+");
		obj1.setReal(Integer.parseInt(str[0]));
		obj1.setImg(Integer.parseInt(str[1].replace("i","")));
		
		str = args[1].split("\\+");
		obj2.setReal(Integer.parseInt(str[0]));
		obj2.setImg(Integer.parseInt(str[1].replace("i","")));
		
		Complex obj3 = new Complex();
		obj3.setReal(obj1.getReal()+obj2.getReal());
		obj3.setImg(obj1.getImg()+obj2.getImg());
		
		System.out.println(obj3.getReal()+"+"+obj3.getImg()+"i");
		
		Complex obj4 = new Complex();
		obj4.setReal(obj1.getReal()-obj2.getReal());
		obj4.setImg(obj1.getImg()-obj2.getImg());
		
		System.out.println(obj4.getReal()+"+"+obj4.getImg()+"i");
	}
}