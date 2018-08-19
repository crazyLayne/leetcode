package TempTest51_75;

public class AddBinary {
	public static void main(String args[]){
		String a="11";
		String b="1";
		char c;
		int i=3;
//		c=(char) (i+'0');
		System.out.println(addBinary(a,b));
				
	}
	 public static String addBinary(String a, String b) {
//	        if(a.length()==0)return b;
//	        if(b.length()==0)return a;
//	        if(a.length()>b.length()){      //保证a是短的
//	            String c=a;
//	            a=b;
//	            b=c;
//	        }
//	        char[] sum=new char[b.length()];
//	        int jin,an,bn,cn;
//	        jin=0;
//	        for(int i=0;i<a.length();i++){  //遍历a
//	            an=a.charAt(a.length()-i-1)-'0';
//	            bn=b.charAt(b.length()-i-1)-'0';
//	            cn=an+bn+jin;
//	            if(cn>1){
//	                jin=1;
//	                sum[b.length()-1-i]=(char) ((cn-2)+'0');
//	            }else{
//	                jin=0;
//	                sum[b.length()-1-i]=(char) (cn+'0');
//	            }
//	        }
//	        for(int j=b.length()-a.length()-1;j>=0;j--){ //接着遍历完b
//	            bn=b.charAt(j)-'0';
//	            cn=bn+jin;
//	            if(cn>1){
//	                jin=1;
//	                sum[j]=(char) ((cn-2)+'0');
//	            }else{
//	                jin=0;
//	                sum[j]=(char) (cn+'0');
//	            }
//	        }
//	        if(jin==0)return String.valueOf(sum);
//	            else return "1"+String.valueOf(sum);
		 int al,bl;
	        al=a.length();
	        bl=b.length();
	            if(al==0)return b;
		        if(bl==0)return a;
		        if(al>bl){      //保证a是短的
		            String c=a;
		            a=b;
		            b=c;
		        }
		        char[] sum=new char[bl];
		        int jin,an,bn,cn;
		        jin=0;
		        for(int i=0;i<al;i++){  //遍历a
		            an=a.charAt(al-i-1)-'0';
		            bn=b.charAt(bl-i-1)-'0';
		            cn=an+bn+jin;
		            if(cn>1){
		                jin=1;
		                sum[bl-1-i]=(char) ((cn-2)+'0');
		            }else{
		                jin=0;
		                sum[bl-1-i]=(char) (cn+'0');
		            }
		        }
		        for(int j=bl-al-1;j>=0;j--){ //接着遍历完b
		            bn=b.charAt(j)-'0';
		            cn=bn+jin;
		            if(cn>1){
		                jin=1;
		                sum[j]=(char) ((cn-2)+'0');
		            }else{
		                jin=0;
		                sum[j]=(char) (cn+'0');
		            }
		        }
		        if(jin==0)return String.valueOf(sum);
		            else return "1"+String.valueOf(sum);
	}
}
