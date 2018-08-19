package TempTest1_25;

public class MedianofTwoSortedArrays {
	public static void main(String args[]){
		int[] nums1=new int[0];
		int[] nums2={2,3};
		System.out.println(findMedianSortedArrays(nums1,nums2));
		
	}
	
	public static double findMedianSortedArrays(int [] nums1,int [] nums2){
		int m=nums1.length;
        int n=nums2.length;
        if(m>n)return findMedianSortedArrays(nums2,nums1);
        if(m==0){
        	int a=nums2[(n-1)/2];
        	int b=nums2[n/2];
        	return (a+b)/2;
        			
        }
        int L1,L2,R1,R2,C1,C2,low,high;
        low=0;high=2*m;
        L1=Integer.MIN_VALUE;
        R1=Integer.MAX_VALUE;
        L2=Integer.MIN_VALUE;
        R2=Integer.MAX_VALUE;
        while(low<high){
            C1=(low+high)/2;        //¸îÈ¡ÖÐ¼ä
            C2=m+n-C1;
            L1 = (C1 == 0)?Integer.MIN_VALUE:nums1[(C1-1)/2];   //map to original element
            R1 = (C1 == 2*m)?Integer.MAX_VALUE:nums1[C1/2];
            L2 = (C2 == 0)?Integer.MIN_VALUE:nums2[(C2-1)/2];
            R2 = (C2 == 2*n)?Integer.MAX_VALUE:nums2[C2/2];
            
            if(L1>R2){
                high=C1-1;
            }else if(L2>R1){
                low=C1+1;
            }else{
                break;
            }
        }
        return (Math.max(L1, L2)+Math.min(R1, R2))/2.0;
	}

}
