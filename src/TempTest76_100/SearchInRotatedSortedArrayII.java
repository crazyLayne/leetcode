package TempTest76_100;

public class SearchInRotatedSortedArrayII {
	public static void main(String args[]){
		int[] nums={1,3};
		int target=3;
		System.out.print(search(nums,target));
	}
	public static boolean search(int[] nums, int target){
		int len=nums.length;
		int i=0;
		int j=len-1;
		int mid;
		if(len<0)return false;
		while(i<=j){
			mid=(i+j)/2;
			if(nums[mid]==target)return true;
			if(nums[mid]>nums[i]){			//�������
				if(target>=nums[i] && target<nums[mid]){
					j=mid-1;
				}else{
					i=mid+1;
				}
			}else if(nums[mid]<nums[i]){							//�Ҳ�����
				if(target>nums[mid] && target<=nums[j]){
					i=mid+1;
				}else{
					j=mid-1;
				}
			}else{
				i++; 
			}
		}
		return false;
	}
	
	
	//���ֲ���
	public boolean search3(int[] nums, int target){
		int len=nums.length;
		int i=0;
		int j=len-1;
		int mid;
		if(len<0)return false;
		while(i<=j){
			if(nums[i]==nums[j]){		//����߿�ʼ�Ƴ��ظ�Ԫ��
				if(nums[i]==target)return true;
				while(i<=j && nums[i]==nums[j]){
					i++;
				}
				if(i>=j)return false;
			}
			mid=(i+j)/2;
			if(nums[mid]==target)return true;
			if(nums[mid]>=nums[i]){			//�������
				if(target>=nums[i] && target<nums[mid]){
					j=mid-1;
				}else{
					i=mid+1;
				}
			}else{							//�Ҳ�����
				if(target>nums[mid] && target<=nums[j]){
					i=mid+1;
				}else{
					j=mid-1;
				}
			}
		}
		return false;
	}
	//��֧��������
	public static boolean search2(int[] nums, int target){
		int i;
		if(nums.length>0){
			if(nums[0]==target)return true;
			else if(nums[0]<target){				//��ǰ������
				i=0;
				while(i<nums.length-1 && nums[i]<=nums[i+1]){	//��������
					if(nums[++i]==target)
						return true;
				}
			}else{									//�Ӻ���ǰ��
				i=nums.length-1;
				if(nums[i]==target)return true;
				while(i>1 && nums[i]>=nums[i-1]){		//���ֵݼ�
					if(nums[--i]==target)
						return true;
				}
			}
		}
		return false;
	}

}
