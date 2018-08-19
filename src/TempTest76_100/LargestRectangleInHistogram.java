package TempTest76_100;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String args[]){
//		int[] heights = {2,1,5,6,2,3};
//		int[] heights = {2,1,2};
//		int[] heights = {0,1,0,2,0,3,0};
		int[] heights = {4,2,0,3,2,5};
		System.out.print(largestRectangleArea3(heights));
	}
	public static int largestRectangleArea(int[] heights) {
		int maxArea=0;
		int[] st=new int[100];
		int p=-1;
		
		for(int i=0;i<heights.length;i++){
			if(p>=0 && heights[i]<heights[st[p]]){//出栈直至栈内单调递增，并计算面积
				int last=p;	//记录出栈个数
				do{
					maxArea=Math.max(maxArea, (last-p+1)*heights[st[p--]]);
				}while(p>=0 && heights[st[p]]>heights[i]);
			}
			st[++p]=i;
		}
		int last=p;	//记录出栈个数
		while(p>=0){
			maxArea=Math.max(maxArea, (last-p+1)*heights[st[p--]]);
		}
		return maxArea;
    }
	public static int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
	//思想：维持一个递增栈，当遇到递减情况时，出栈计算maxArea，由于栈是递增的，可以轻松算出宽度。
	public static int largestRectangleArea3(int[] heights) {
        int maxArea=0;
		int[] st=new int[100000];
		int p=-1;
		int[] h=Arrays.copyOf(heights, heights.length+1);
        int i=0;
        while(i<h.length){
            if(p<0 || h[st[p]]<=h[i]) 
            	st[++p]=i++;
            else{
                maxArea=Math.max(maxArea, h[st[p--]]*(p<0?i:i-st[p]-1));
            }
        }
		return maxArea;
    }

}
