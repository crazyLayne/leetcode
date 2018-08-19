package TempTest176_200;

public class Numberof1Bits {
	public static void main(String args[]){
		
	}
	public int hammingWeight(int n){
		int count = 0;
		for(int i=0;i<31;i++){
//			if((n&1)==1)count++;
			count+=n&1;
			n>>=1;
		}
		return (n>=0)?count:count+1;
	}

}
