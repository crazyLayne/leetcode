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
			while(index<height.length-1 && height[index]<=height[index+1]){		//�ҵ���һ���½��ĵط�����Ϊ���
				index++;
			}
			left=index;
			Lval=height[left];
			
		}
		
		return sum;
	}

}
