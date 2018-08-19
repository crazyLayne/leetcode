package TempTest151_175;

public class FindPeakElement {
	public static void main(String args[]){
		
	}
	//¶þ·Ö¼ìË÷
	public int findPeakElement(int[] nums) {
        int left =0, right = nums.length-1;
        while (left < right) {
            int mid = (right+left)/2;
            if (nums[mid]<nums[mid+1]) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
	//±©Á¦¼ìË÷
	public int findPeakElement2(int[] nums) {
        int i;
        for(i=1;i<nums.length;i++){
        	if(nums[i]<nums[i-1])break;
        }
        return i-1;
    }

}
