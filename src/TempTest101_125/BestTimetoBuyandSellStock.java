package TempTest101_125;

public class BestTimetoBuyandSellStock {

	public static void main(String args[]){
		int[] prices={7,1,5,3,6,4};
		System.out.println(maxProfit2(prices));
	}
	//维持一个单调递增栈，要出栈或者读完数组后，更新maxP
	public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int maxP=0;
        int[] st=new int[20000];
        int p=-1;
        for(int i=0;i<prices.length;){
            if(p==-1 || prices[i]>=st[p]){  //栈为空或单调递增就入栈
                st[++p]=prices[i++];
            }else{
                maxP=Math.max(maxP, st[p--]-st[0]);
            }
        }
        return Math.max(maxP, st[p--]-st[0]);
    }
	//写两个小函数，	求下一个峰值和谷值，用于更新low和high，始终保持low<high
	public static int maxProfit2(int[] prices){
		int low=0;
		int high=0;
		int nh=0;
		int nl=0;
		int maxP=0;
		while(nh!=prices.length-1 && nl!=prices.length-1){
			nl=nextLow(prices, nh);
			low=prices[nl]>=prices[low]?low:nl;
			if(nl!=prices.length-1){
				nh=nextHigh(prices, nl);
				high=(prices[nh]<=prices[high] && high>=low)?high:nh;
				maxP=Math.max(maxP, prices[high]-prices[low]);
			}
		}
		return maxP; 
	}
	public static int nextLow(int[] prices, int i){
		int k;
		for(k=i+1; k<prices.length && prices[k]<=prices[k-1]; k++);
		return k-1;
	}
	public static int nextHigh(int[] prices, int i){
		int k;
		for(k=i+1; k<prices.length && prices[k]>=prices[k-1]; k++);
		return k-1;
	}
	//单向不回头的记录low和maxP
	public static int maxProfit3(int[] prices){
		if(prices.length==0)return 0;
		int maxP=0;
		int low=prices[0];
		for(int i=0;i<prices.length;i++){
			low=Math.min(low, prices[i]);
			maxP=Math.max(prices[i]-low, maxP);
		}
		return maxP;
	}
	
}
