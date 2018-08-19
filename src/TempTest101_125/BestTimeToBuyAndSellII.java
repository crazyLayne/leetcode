package TempTest101_125;

public class BestTimeToBuyAndSellII {
	public static void main(String args[]){
		int[] prices={7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	//寻找峰值和谷值，类和峰值谷值差
	public static int maxProfit(int[] prices){
		int profit=0;
		int low=0;
		int high=0;
		while(low<prices.length-1 && high<prices.length-1){
			low=high;
			while(low<prices.length-1 && prices[low]>=prices[low+1])low++;
			high=low;
			while(high<prices.length-1 && prices[high] <=prices[high+1])high++;
			profit+=prices[high]-prices[low];
		}
		return profit;
	}
	public static int maxProfit2(int[] prices){
		int profit=0;
		int min=prices[0];
		for(int i=0;i<prices.length;i++){
			if(prices[i]<min){
				min=prices[i];
			}else{
				profit+=prices[i]-min;
				min=prices[i];
			}
		}
		return profit;
	}

}
