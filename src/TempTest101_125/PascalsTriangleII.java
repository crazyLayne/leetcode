package TempTest101_125;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public static void main(String args[]){
		
	}
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        if(rowIndex==0){
            res.add(1);
        }
        else if(rowIndex==1){
            res.add(1);
            res.add(1);
        }else if(rowIndex>1){
            res=getRow(rowIndex-1);
            res.add(1,res.get(0)+res.get(1));
            for(int i=2;i<rowIndex;i++){
                res.set(i,res.get(i)+res.get(i+1));
            }
        }
        return res;
    }

}
