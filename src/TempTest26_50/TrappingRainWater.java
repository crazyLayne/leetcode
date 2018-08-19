package TempTest26_50;

public class TrappingRainWater {
	public static void main(String args[]){
		
	}
	public static int solution(int[] height){
		int sum=0;
		int left,right;
		int Lval,Rval;
		int index=0;
		while(index<height.length-1){
			while(index<height.length-1 && height[index]<=height[index+1]){		//找到第一个下降的地方，作为左边
				index++;
			}
			left=index;
			Lval=height[left];
			
		}
		
		return sum;
	}

}
