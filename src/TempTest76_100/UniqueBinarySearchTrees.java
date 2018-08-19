package TempTest76_100;

public class UniqueBinarySearchTrees {
	public static void main(String args[]){
		System.out.println(numTrees(19));
	}
	public static int numTrees(int n) {
		if(n==0)return 0;
		if(n==1)return 1;
        if(n==2)return 2;
        int[] nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        nums[2]=2;
        for(int i=3;i<=n;i++){
            for(int j=0;j<i;j++){
                nums[i]+=nums[i-1-j]*nums[j];
            }
        }
        return nums[n];
    }
	

}
