package TempTest76_100;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static void main(String args[]){
		System.out.println(grayCode2(4));
	}
	public static List<Integer> grayCode(int n) {
		List<Integer> ans=new ArrayList<>();
        int num;
        for(int i=1;i<=Math.pow(2,n);i++){
        	num=0;
        	for(int j=1;j<=n;j++){
        		int T=(i-1)/((int)Math.pow(2, n-j))+1;		//µÚ¼¸×é
        		int k=T/2%2;
        		num*=2;
        		num+=k;
        	}
        	ans.add(num);
        }
        return ans;
    }
	public static List<Integer> grayCode2(int n){
		int m = 1 << n;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(i ^ i >> 1);
        }
        return list;
	}

}
