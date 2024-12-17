class Patterns{
	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		for(int i=0;i<num;i++){
			int k = 0;
			for(int j=0;j<num*3;j++){
				if(j<=i){
					System.out.print("*");
				}
				else if(j==(num*2-i)+2*k && k<=i){
					System.out.print("*");
					k++;
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

