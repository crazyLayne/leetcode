package TempTest76_100;

public class MergeSortedArray {
	public static void main(String args[]){
		
		
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        //��nums1�е����ֵ
        int i,j;
        i=m-1;
        j=n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[i+j+1]=nums1[i--];
            }else{
                nums1[i+j+1]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[j]=nums2[j--];
        }
    }

}
