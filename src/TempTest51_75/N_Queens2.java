package TempTest51_75;

import java.util.ArrayList;
import java.util.List;

public class N_Queens2 {
	public static void main(String args[]){
		
	}
	public int solution(int n){
		int[] sum = new int[1];
		int[] column = new int[n];			//行，列，斜，正斜值不大于1
		int[] xie = new int[2*n-1];
		int[] dexie = new int[2*n-1];
		int[][] panel = new int[n][n];
		queen(column,xie,dexie,panel,n,0,sum);
		return sum[0];
	}
	public static void queen(int[] column, int[] xie, int[] dexie,int[][] panel,int n,int count,int[] sum){
		if(count==n){			//结束,将数组转链表加入答案
			sum[0]++;
		}else{
			for(int i=0;i<n;i++){		//先加入，判合法性，合法往深层走，再删除
				column[i]++;
				xie[count-i+n-1]++;
				dexie[i+count]++;
				if(judge(column,xie,dexie)){
					panel[count][i]=1;
					queen(column,xie,dexie,panel,n,count+1,sum);
				}
				panel[count][i]=0;
				column[i]--;
				xie[count-i+n-1]--;
				dexie[i+count]--;
			}
		}
	}
	public static boolean judge(int[] m,int[] l,int[] n){
		for(int i=0;i<m.length;i++){
			if(m[i]>1)
				return false;
		}
        for(int i=0;i<l.length;i++){
            if(n[i]>1||l[i]>1)
                return false;
        }
		return true;
	}
}
