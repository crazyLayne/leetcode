package TempTest151_175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class MaximumGap {
	public static void main(String args[]){
		int[] array={15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
//		int[] array={1,1,1,1,1,5,5,5,5,5};
//		int[] array={13684,13701,15157,2344,28728,16001,9900,7367,30607,5408,17186,13230,1598,9766,13083,27618,29065,9171,2470,20163,5530,20665,14818,4743,24871,27852,8129,4071,17488,30904,1548,16408,1734,17271,19880,22269,18738,30242,6679,19867,13781,4615,10049,28877,9323,5373,11381,18489,13654,14324,28843,27010,10232,31696,29708,3008,28769,30840,21172,28461,20522,8745,17590,27936,30368,30993,24416,17472};
		System.out.println(maximumGap3(array));
	}
	//基数排序
	public static int maximumGap(int[] array){
		if(array.length<=1)return 0;
		int maxlen=0;			//最大位数
		int curlen;
		for(int i=0;i<array.length;i++){
			curlen=String.valueOf(array[i]).length();
			maxlen=Math.max(maxlen, curlen);
		}
		array = sortCore(array, 0, maxlen);
		int maxGap=0;
		for(int i=1;i<array.length;i++){
			maxGap=Math.max(maxGap, array[i]-array[i-1]);
		}
		return maxGap;
	}
	public static int[] sortCore(int[] array, int digit, int maxlen){
		if(digit>=maxlen)return array;		//已经遍历到最高位
		int base=10;						//十进制
		int len=array.length;
		int[] count=new int[base];			//统计各个位的数目
		int[] bucket=new int[len];			//记录重新分配的数字
		for(int num:array){
			count[(num /(int)Math.pow(10,digit))%10]++;		//计算该数第d位置的值，并更新统计量
		}
		for(int i=1;i<base;i++){			//将统计量向后传递，方便往bucket里放值
			count[i]+=count[i-1];
		}
		int temp;
		for(int i=len-1;i>=0;i--){			//倒着放入bucket，保持算法的稳定性
			temp=(array[i] /(int)Math.pow(10,digit))%10;	//计算该数第d位置的值
			bucket[count[temp]-1]=array[i];					//找到统计信息，即存储在bucket中的下标
			count[temp]--;									//更新统计信息
		}
		return sortCore(bucket, digit+1, maxlen);
	}

	//arrays排序
	public static int maximumGap2(int[] array){
		if(array.length<=1)return 0;
		Arrays.sort(array);
		int maxGap=0;
		for(int i=1;i<array.length;i++){
			maxGap=Math.max(maxGap, array[i]-array[i-1]);
		}
		return maxGap;
	}

	//将数组中的数放入等距的几个区间内，求距离最远的两个区间内的gap，就是整个数组的maxGap
	public static int maximumGap3(int[] array){
		if(array.length<=1)return 0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int n:array){
			max=Math.max(max, n);
			min=Math.min(min, n);
		}
		if(max==min)return 0;		//最大值等于最小值
		int num=array.length;		//num个区间
		int b=(max-min)/(num-1);	//除以num-1是为了保证num个区间能覆盖到[min,max]
		if(b==0) b=1;           	//数太密集
		num = (max-min)/b+1;
		int[] bucketMin=new int[num];	//只需要存储各个区间内的最大值和最小值
		int[] bucketMax=new int[num];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		int index;					//将值转化成bucket下标
		for(int n:array){
			index=(n-min)/b;
			bucketMin[index]=Math.min(n, bucketMin[index]);
			bucketMax[index]=Math.max(n, bucketMax[index]);
		}
		int maxIn=0;		//遍历过程中，存有值的前后区间
		int minIn=0;
		int maxGap=0;
		while(maxIn<=num-1){		//求相邻俩个区间的差值
			maxGap=Math.max(bucketMin[maxIn]-bucketMax[minIn], maxGap);
			minIn=maxIn;
			do{
			maxIn++;
			}while(maxIn<=num-1 && bucketMin[maxIn]==Integer.MAX_VALUE);
		}
		return maxGap;
	}

}
