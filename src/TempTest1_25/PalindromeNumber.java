package TempTest1_25;

public class PalindromeNumber {
	public static void main(String args[]){
		int X=10;
		System.out.println(solution2(X));
	}
	public static boolean solution(int x){
        if(x<0)
            return false;
        if(x>=0&&x<10)
            return true;
		int rex=0;
		while(x!=0){
			rex=rex*10+x%10;
			if(rex==0)
				return false;
            if(x==rex)
                return true;
			x=x/10;
			if(x==rex)
				return true;
		}
		return false;
	}
	
	public static boolean solution2(int x){
		if(x<0 || (x%10==0 && x!=0))
			return false;
		int rex=0;
		while(x>rex){
			rex=rex*10+x%10;
			x/=10;
		}
		return rex==x || x==rex/10;
	}

}
