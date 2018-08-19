package TempTest1_25;

public class ContainerWithMostWater {
	public static void main(String args[]){
		int [] x={1,1};
		System.out.println(solution2(x));
	}
	public static int solution(int[] height){
		int pre=0,rear=height.length-1;
		int max=0;
		while(rear>pre){
			if(Math.min(height[pre],height[rear])*(rear-pre)>max)
				max=Math.min(height[pre],height[rear])*(rear-pre);
			if(height[pre]>height[rear])
				rear--;
			else
				pre++;
		}
		return max;
	}
	
	public static int solution2(int [] height){
		int pre=0,rear=height.length-1;
		int max=0;
		while(rear>pre){
			if(Math.min(height[pre],height[rear])*(rear-pre)>max){
                max=Math.min(height[pre],height[rear])*(rear-pre);
            }
				
			if(height[pre]>height[rear])
				    rear--;
			else
				    pre++;
		}
		return max; 
	}
	

}
