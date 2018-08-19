package TempTest51_75;

public class Sqst_X {
	public static void main(String args[]){
//		System.out.println(Integer.MAX_VALUE);
//		System.out.print(Math.sqrt(Integer.MAX_VALUE));
		System.out.println(mySqrt2(2147483647));
	}
	public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
	public static int mySqrt2(int x) {
		 if (x == 0)
		        return 0;
		        int left = 1, right = Integer.MAX_VALUE;
		        int ans = 0;
		        while (left <= right) {
		            int mid = left + (right - left)/2;
		           
		            if (mid > x/mid) {
		                right = mid - 1;
		            } else {
		                ans = mid;  
		                left = mid + 1;
		            }
		        }
		        return ans ;
    }

}
