package TempTest26_50;

public class JumpGameII {
	public static void main(String args[]){
		int[] nums={2,3,1,1,4};
		System.out.println(jump(nums));
	}
	public static int jump(int[] nums) {
		if(nums.length==0 || nums.length==1)return 0;
        int i=0;            //��ǰλ��
        int ip=0;           //�ϴαȽϵĽ���λ��
        int count=1;
        int maxi;
        while(i+nums[i]<nums.length-1){       //ûԽ��
            maxi=i;             //��һ����Զ��Ծ����,������Ϊ���
            for(int j=ip;j<=i+nums[i];j++){
                if(j+nums[j]>maxi+nums[maxi]){
                    maxi=j;
                }
            }
            if(i==maxi)return 0;        //��Զ����i�����������յ�
            ip=i+nums[i];
            i=maxi;
            count++; 
        }
        return count;
    }

}
