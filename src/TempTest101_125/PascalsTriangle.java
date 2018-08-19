package TempTest101_125;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String args[]){
		generate(3);
	}
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        if(numRows<=0)return ans;
        List<Integer> an=new ArrayList<>();
        an.add(1);
        ans.add(an);
        for(int i=1;i<numRows;i++){         //µÚi²ã
            an=new ArrayList<>();
            an.add(1);
            for(int j=1;j<i;j++){
                an.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            an.add(1);
            ans.add(an);
        }
        return ans;
    }

}
