package TempTest51_75;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	public static void main(String args[]){
		
	}
	public List<Interval> solution(List<Interval> intervals){
		List<Interval> ans = new ArrayList<>();
		boolean flag;
		for(int i=0;i<intervals.size();i++){
			flag=false;
			for(int j=0;j<ans.size();j++){
				if((ans.get(j).start<=intervals.get(i).start&&ans.get(j).end>=intervals.get(i).start)||(ans.get(j).start<=intervals.get(i).end&&ans.get(j).end>=intervals.get(i).end)){
					Interval a=new Interval(Math.min(ans.get(j).start,intervals.get(i).start ),Math.max(ans.get(j).end,intervals.get(i).end ));
					ans.set(j, a);
					flag=true;
					break;
				}
			}
			if(!flag)ans.add(intervals.get(i));
		}
		return ans;
	}
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	}

//	public List<Interval> solution2(List<Interval> intervals){
//		
//		
//		
//		
//	}
}


  
 
