package TempTest176_200;

public class ReverseBits {
	public static void main(String args[]){
		System.out.println(reverseBits(1));
		System.out.println(reverseBits(Integer.MAX_VALUE+1));
	}
	public static int reverseBits(int n) {
		int res=0;
        for(int i=0;i<32;i++){
            res+=n&1;
            n>>>=1;
            if(i<31)
                res<<=1;
        }
        return res;
    }

}
