package TempTest51_75;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	public static void main(String args[]){
		solution(4);
	}
	public static List<List<String>> solution(int n){
		List<List<String>> ans = new ArrayList<>();
		List<String> an = new ArrayList<>();
		int[] column = new int[n];			//行，列，斜，正斜值不大于1
		int[] row = new int[n];
		int[] xie = new int[2*n-1];
		int[] dexie = new int[2*n-1];
		int[][] panel = new int[n][n];
		queen(column,xie,dexie,ans,panel,n,0);
		return ans;
	}
	public static void queen(int[] column, int[] xie, int[] dexie, List<List<String>> ans,int[][] panel,int n,int count){
		if(count==n){			//结束,将数组转链表加入答案
			String str;
			List<String> an = new ArrayList<>();
			for(int i=0;i<n;i++){
				str="";
				for(int j=0;j<n;j++){
					if(panel[i][j]==1)str+="Q";
					else str+=".";
				}
				
				an.add(str);
			}
			ans.add(an);
		}else{
			for(int i=0;i<n;i++){		//先加入，判合法性，合法往深层走，再删除
				column[i]++;
				xie[count-i+n-1]++;
				dexie[i+count]++;
				if(judge(column,xie,dexie)){
					panel[count][i]=1;
					queen(column,xie,dexie,ans,panel,n,count+1);
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
