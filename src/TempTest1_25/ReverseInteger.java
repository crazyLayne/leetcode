package TempTest1_25;

public class ReverseInteger {
	public static void main(String args[]){
		int X = 1534236469;
		System.out.println(solution(X));
	}
	
	public static int solution(int x){
		int rex=0,reTemp=0;
		while(x!=0){
			reTemp=rex*10+x%10;
			if(reTemp/10!=rex)
				return 0;
			rex=reTemp;
			x/=10;
		}
		return x>=0?rex:-rex;
	}
}
