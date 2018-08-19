package TempTest51_75;

public class ClimbingStairs {
	public static void main(String args[]){
		System.out.println(CS2(44));
	}
	public static int CS(int n){
		if(n==1)return 1;
        else if(n==2) return 2;
        else{
            return CS(n-1)+CS(n-2);
        }
	}
	public static int CS2(int n){
		if(n==1)return 1;
		if(n==2)return 2;
		int a=1;
		int b=2;
		int c;
		while(n>2){
			c=a+b;
			a=b;
			b=c;
			n--;
		}
		return b;
	}

}
