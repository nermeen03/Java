import java.util.StringTokenizer;
class IPCutter{
	public static void main(String[] args){
		String[] s = args[0].split("\\.");
		for(String i: s){
			System.out.println(i);
		}
	System.out.println("----------------");
	StringTokenizer st = new StringTokenizer(args[0],".");
     while (st.hasMoreTokens()) {
		 System.out.println(st.nextToken());
     }	
	
	System.out.println("----------------");
	String str = args[0];
	int begin = 0;
	int stop = str.indexOf('.');
	while(stop!=-1){
	System.out.println(str.substring(begin,stop));
	begin=stop+1;
	stop=str.indexOf('.',begin);
	}
	System.out.println(str.substring(begin));
	}
}