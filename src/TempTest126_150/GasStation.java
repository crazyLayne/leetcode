package TempTest126_150;

public class GasStation {
	public static void main(String args[]){
		int[] gas={99,98,97,100};
		int[] cost={100,100,100,97};
		System.out.print(canCompleteCircuit(gas,cost));
	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int count=0; 
        int i;
        for(i=gas.length-1;i>=0;i--){           //找到第一个gas-cost为正的station
            if(gas[i]-cost[i]>=0){
                break;
            }
            count+=gas[i]-cost[i];
        }
        if(i<0)return -1;
        
        int tank=0;
        int point=0;        //最大点坐标
        int max=tank;       //最大容量
        for(;i>=0;i--){         //继续往前遍历，看什么时候gas tank累积最多
            tank+=gas[i]-cost[i];
            if(tank>=max){
                max=tank;
                point=i;
            }
        }
        return tank+count>=0?point:-1;
    }

}
