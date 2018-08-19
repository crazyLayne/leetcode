package TempTest126_150;

public class Candy {
	public static void main(String args[]){
	}
	
	//time out
	public int candy(int[] ratings) {
	     int len=ratings.length;
	     int[] candys=new int[len];
	     boolean flag=false;
	     while(!flag){
	         flag=true;
	         for(int i=1;i<len;i++){
	             if(ratings[i-1]>ratings[i] && candys[i-1]<=candys[i]){
	                 candys[i-1]++;
	                 flag=false;
	             }
	             if(ratings[i-1]<ratings[i] && candys[i-1]>=candys[i]){
	                 candys[i]++;
	                 flag=false;
	             }
	         }
	     }
	     int res=0;
	     for(int val:candys){
	         res+=val;
	     }
	     return res+len;
	}
	
	public static int candy1(int[] ratings){
		int len=ratings.length;
		int[] c=new int[len];
		for(int i=0;i<len-1;i++){		//从左往右扫一遍，保持递增
			if(ratings[i]<ratings[i+1] && c[i]>=c[i+1]){
				c[i+1]=c[i]+1;
			}
		}
		for(int i=len;i>0;i--){			//从右往左扫一遍，保持递增
			if(ratings[i-1]>ratings[i] && c[i-1]<=c[i]){
				c[i-1]=c[i]+1;
			}
		}
		int res=0;
        for(int val:c){
            res+=val;
        }
        return res+len;
	}
}
