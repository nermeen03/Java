class Pattern{
	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		String[][] str = new String[num][num*3];
		int i = 0;
		int j = 0;
		int n = 0;
		for(int k=0; k<num*num*9 && i<num;k++){
			if(j==0 || j<=i){
				str[i][j]="*";
				j++;
			}
			else if(j == (num*2-i)+2*n && n<=i){
				str[i][j]="*";
				j++;
				n++;
			}
			else if (j!=num*3-1 && n>i){
				print(str[i],0);
				System.out.println();
				j=0;
				n=0;
				i++;
			}
			else if(j != (num*2-i)+2*n && j<num*3){
				str[i][j]=" ";
				j++;
			}
			
		}
		
	}
	public static void print(String[] s, int index) {
        if (index < s.length && s[index]!=null) {
            System.out.print(s[index]);
            print(s, index + 1);
        }
    }
}
