package TempTest201_225;

public class UglyNumberII {
	public static void main(String args[]){
		System.out.print(nthUglyNumber(4));
	}
	public static int nthUglyNumber(int n){
		int count=1;
		int num=1;
		int[] ugly=new int[1700];
		ugly[1]=1;
		int n2,n3,n5;
		n2=n3=n5=1;
		int num2=ugly[n2]*2;
		int num3=ugly[n3]*3;
		int num5=ugly[n5]*5;
		while(count<n){
			num=Math.min(num2, Math.min(num3, num5));
            ugly[++count]=num;
			if(num==num2){n2++;num2=ugly[n2]*2;}
			if(num==num3){n3++;num3=ugly[n3]*3;}
			if(num==num5){n5++;num5=ugly[n5]*5;}
		}
		return num;
	}

}
