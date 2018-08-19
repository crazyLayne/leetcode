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
        for(i=gas.length-1;i>=0;i--){           //�ҵ���һ��gas-costΪ����station
            if(gas[i]-cost[i]>=0){
                break;
            }
            count+=gas[i]-cost[i];
        }
        if(i<0)return -1;
        
        int tank=0;
        int point=0;        //��������
        int max=tank;       //�������
        for(;i>=0;i--){         //������ǰ��������ʲôʱ��gas tank�ۻ����
            tank+=gas[i]-cost[i];
            if(tank>=max){
                max=tank;
                point=i;
            }
        }
        return tank+count>=0?point:-1;
    }

}
