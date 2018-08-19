package TempTest101_125;

import java.util.List;

public class Triangle {
	public static void main(String args[]){
		
	}
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0 || triangle.get(0).size()==0)return 0;
		int level=triangle.size();
		int[] L=new int[level];
		helper(triangle, level-1, L);
		int min=Integer.MAX_VALUE;
		for(int i:L){
			if(i<min)min=i;
		}
		return min;
    }
	public void helper(List<List<Integer>> tri, int level, int[] L){	//求第i[0,n-1]层的最短路径
		if(level==0){
			L[0]=tri.get(0).get(0);
		}else{
            helper(tri,level-1,L);		//求上一层的最短路径
		    L[level]=L[level-1]+tri.get(level).get(level);//倒着更改L
		    for(int i=level-1;i>0;i--){
		    	L[i]=tri.get(level).get(i)+Math.min(L[i], L[i-1]);
		    }
		    L[0]=L[0]+tri.get(level).get(0);
        }
	}

}
