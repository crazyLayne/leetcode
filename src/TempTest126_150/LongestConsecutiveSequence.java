package TempTest126_150;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public static void main(String args[]){
		int[] nums={100,4,3,200,1,2};
		System.out.println(longestConsecutive(nums));
	}
	
	public static int longestConsecutive(int[] nums) {
		if(nums.length==0)return 0;
		HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums)map.put(num, 1);
        int maxlen=1;
        int count;
        for(int num:nums){
        	if(map.containsKey(num)){
        		map.remove(num);
        		count=1;
            	while(map.containsKey(++num)){
            		map.remove(num);
            		count++;
            	}
            	num=num-count;
            	while(map.containsKey(--num)){
            		map.remove(num);
            		count++;
            	}
            	if(count>maxlen)maxlen=count;
        	}
        }
        return maxlen;
    }

}
