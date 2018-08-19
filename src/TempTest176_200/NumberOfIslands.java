package TempTest176_200;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public static void main(String args[]){
		
	}
	
	public int numIslands(char[][] grid) {
		if(grid.length==0 || grid[0].length==0)return 0;
		int m,n;
		int count=0;
		m=grid.length;
		n=grid[0].length;
		boolean[][] flags=new boolean[m][n]; 
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(flags[i][j])continue;	//已经访问过了
        		if(grid[i][j]=='0'){		//是海洋
        			flags[i][j]=true;
        			continue;
        		}
        		count++;		//是陆地,层次遍历完这块陆地
        		BFS(grid, flags, i, j, m, n);
        	}
        }
        return count;
    }
	//广度遍历x,y
	public static void BFS(char[][] grid, boolean[][] flags, int x, int y, int m, int n){
		Point p1,p2;
		Queue<Point> q = new LinkedList<>();
		flags[x][y]=true;
		p1 = new Point(x,y);
		q.offer(p1);
		while(!q.isEmpty()){	//从上下左右四个方向遍历
			p2 = q.poll();
			x=p2.x;
			y=p2.y;
			if(x-1>=0 && !flags[x-1][y]){
				flags[x-1][y]=true;
				if(grid[x-1][y]=='1'){
					p1 = new Point(x-1,y);
					q.offer(p1);
				}
			}
			if(x+1<m && !flags[x+1][y]){
				flags[x+1][y]=true;
				if(grid[x+1][y]=='1'){
					p1 = new Point(x+1,y);
					q.offer(p1);
				}
			}
			if(y-1>=0 && !flags[x][y-1]){
				flags[x][y-1]=true;
				if(grid[x][y-1]=='1'){
					p1 = new Point(x,y-1);
					q.offer(p1);
				}
			}
			if(y+1<n && !flags[x][y+1]){
				flags[x][y+1]=true;
				if(grid[x][y+1]=='1'){
					p1 = new Point(x,y+1);
					q.offer(p1);
				}
			}
		}
	}
	//直接在原数据上改,标识已经访问过了
	public int numIslands2(char[][] grid) {
		if(grid.length==0 || grid[0].length==0)return 0;
		int m,n;
		int count=0;
		m=grid.length;
		n=grid[0].length;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(grid[i][j]=='1'){	
        			count++;		//是陆地,层次遍历完这块陆地
        		    visit(grid, i, j, m, n);
        		}
        	}
        }
        return count;
    }
	public static void visit(char[][] grid, int i, int j, int m, int n){
		if(i>=0 && i<m && j>=0 && j<n && grid[i][j]=='1'){
			grid[i][j]='0';
			visit(grid, i-1, j, m, n);
			visit(grid, i+1, j, m, n);
			visit(grid, i, j-1, m, n);
			visit(grid, i, j+1, m, n);
		}
	}

}
