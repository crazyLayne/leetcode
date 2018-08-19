package TempTest26_50;

public class SearchInRotatedSortedArray {
	public static void main(String args[]){
//		int [] nums={4,5,6,7,0,1,2};
		int [] nums={3,1};
		System.out.println(solution3(nums, 1));
	}
	//��������
	public static int solution(int[] nums, int target){
		for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
        }
        return -1;
	}
	//��֧��������
	public static int solution2(int[] nums, int target){
		int i;
		if(nums.length>0){
			if(nums[0]==target)return 0;
			else if(nums[0]<target){				//��ǰ������
				i=0;
				while(i<nums.length-1 && nums[i]<nums[i+1]){	//��������
					if(nums[++i]==target)
						return i;
				}
			}else{									//�Ӻ���ǰ��
				i=nums.length-1;
				if(nums[i]==target)return i;
				while(i>1 && nums[i]>nums[i-1]){		//���ֵݼ�
					if(nums[--i]==target)
						return i;
				}
			}
		}
		return -1;
	}
	// ���ֲ���
	public static int solution3(int[] nums, int target){
		int len=nums.length;
		int i=0;
		int j=len-1;
		int mid;
		if(len==0)return -1;
		
		while(i<=j){
			mid=(i+j)/2;
			if(nums[mid]==target)return mid;
			if(nums[mid]>=nums[i]){			//��������
				if(target<nums[mid] && target>=nums[i]){
					j=mid-1;
				}else{
					i=mid+1;
				}
			}else{							//�Ұ������
				if(target>nums[mid] && target<=nums[j]){
					i=mid+1;
				}else{
					j=mid-1;
				}
			}
			
		}
		return -1;
	}
}
