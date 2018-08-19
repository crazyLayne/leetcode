package TempTest201_225;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public static void main(String args[]){
		int num=3;
		int[][] requist={{1,0},{0,1}};
		System.out.print(canFinish(num,requist));
	}
	public static boolean canFinish(int numCourses, int[][] prerequisites){
		boolean[][] graph=new boolean[numCourses][numCourses];
		int[] in=new int[numCourses];		//每个点的入度
		for(int i=0;i<prerequisites.length;i++){		//遍历所有边
			graph[prerequisites[i][0]][prerequisites[i][1]]=true;
			in[prerequisites[i][1]]++;
		}
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<numCourses;i++){
			if(in[i]==0)q.offer(i);
		}
		while(!q.isEmpty()){
			int t=q.poll();
			for(int i=0;i<numCourses;i++){
				if(graph[t][i]){
					in[i]--;			//判断这些点的入度是否是入度为0的点的出度
					if(in[i]==0)q.offer(i);
				}
			}
		}
		for(int i=0;i<numCourses;i++){
			if(in[i]!=0)return false;	//最后如果存在入度不为零的点 ,则表示他们是入度不为0的点的出度（即存在环）
		}
		return true;
	}

	
}
