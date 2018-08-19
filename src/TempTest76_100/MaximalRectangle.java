package TempTest76_100;

import java.util.Arrays;
import java.util.Random;

public class MaximalRectangle {
	public static void main(String args[]){
		char[][] matrix=new char[3][7];
		for(int i=0;i<3;i++){
			for(int j=0;j<7;j++){
				matrix[i][j]='0';
			}
		}
		matrix[0][3]='1';
		System.out.println(maximalRectangle2(matrix));;
	}
	
	//将图像层层扫描，看作直方图，然后调用largestRectangleArea，再比较各层之间的maxArea
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] board=new int[m][n];
        for(int i=0;i<n;i++)
            if(matrix[0][i]=='1') board[0][i]=1;
            else board[0][i]=0;
        for(int i=1;i<m;i++){   //每一行向下叠加
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') board[i][j]=board[i-1][j]+1;
                else board[i][j]=0;
            }
        }
        int maxArea=0;
        for(int i=0;i<m;i++){
            maxArea=Math.max(maxArea, largestRectangleArea(board[i]));
        }
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights) {
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

    //动态规划：从上往下层层扫描，记录每个点的左右范围以及高度（即可算出面积）
    public static int maximalRectangle2(char[][] matrix) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int[] left=new int[n];
    	int[] right=new int[n];
    	int[] height=new int[n];
    	Arrays.fill(right, n);
    	int maxA=0;
    	int curLeft;
    	int curRight;
    	for(int i=0;i<m;i++){
    		curLeft=0;
    		curRight=n;
    		for(int j=0;j<n;j++){		//更新height
    			if(matrix[i][j]=='1')height[j]++;
    			else height[j]=0;
    		}
    		for(int j=0;j<n;j++){		//更新left
    			if(matrix[i][j]=='1')left[j]=Math.max(left[j],curLeft);
    			else {left[j]=0; curLeft=j+1;}
    		}
    		for(int j=n-1;j>=0;j--){		//更新right
    			if(matrix[i][j]=='1')right[j]=Math.min(right[j],curRight);
    			else {right[j]=n; curRight=j;}	//保证j在1的右侧，right-left的时候不用加一
    		}
    		for(int j=0;j<n;j++){
    			maxA=Math.max(maxA, (right[j]-left[j])*height[j]);
    		}
    	}
    	return maxA;
    }
}
