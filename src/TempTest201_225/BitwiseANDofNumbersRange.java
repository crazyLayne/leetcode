package TempTest201_225;

public class BitwiseANDofNumbersRange {
	public static void main(String args[]){
		System.out.println(rangeBitwiseAnd(5,7));
		System.out.println(rangeBitwiseAnd(1,1));
		System.out.println(rangeBitwiseAnd(1,2));
		System.out.println(rangeBitwiseAnd(2,4));
	}
	public static int rangeBitwiseAnd(int m, int n){
		int bit;
		int num=0;
		int temp;
		int sub=n-m;
		int M=m;
		for(int i=0;i<31;i++){
			bit=m&1;
			if(bit==1){
				temp = 1<<i;
				int tempp=((temp<<1)-(M+1)%(temp<<1))%(temp<<1);
				if(tempp>=sub){
					num += temp;
				}
			}
			m>>=1;
		}
		return num;
	}

}
