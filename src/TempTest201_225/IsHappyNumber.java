package TempTest201_225;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.HashSet;

public class IsHappyNumber {
	public static void main(String args[]){
		System.out.println(isHappy2(1));
	}
	
	//一直求平方和下去，看是否会重复到1
	public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            n=sqr(n);
            if(n==1)return true;
        }
        return false;
    }
    public int sqr(int num){
        int res=0;
        int rem=0;
        while(num!=0){
            rem=num%10;
            res+=rem*rem;
            num/=10;
        }
        return res;
    }
    
    //不是happy数，必定会到4，不会证明
    public static boolean isHappy2(int n){
    	int num;
    	while(n!=1 && n!=4){
    		num=0;
    		while(n!=0){
    			num+=(n%10)*(n%10);
    			n/=10;
    		}
    		n=num;
    	}
    	return n==1;
    }
  

}
