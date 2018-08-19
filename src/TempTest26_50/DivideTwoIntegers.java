package TempTest26_50;

public class DivideTwoIntegers {
	public static void main(String args[]){
		
	}
	public static int solution(int dividend, int divisor){
		int shang=0;
        boolean fushu = false;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
            fushu = true;
        long A = Math.abs(dividend);
        long B = Math.abs(divisor);
		if(A==0) return 0;
		while(A>=B){
            if(shang==2147483647)
                return 2147483647;
			shang++;
			dividend-=divisor;
		}
        if(fushu)
            return -shang;
		return shang;
	}

}
