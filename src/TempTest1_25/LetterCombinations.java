package TempTest1_25;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	public static void main(String args[]){
		
	}
	
	public static List<String> solution(String digits){
		List<String> strs = new ArrayList<>();
        String temp = "";
		if(digits.length()>0){
			subsol(strs,digits,0,temp);
		} 
		return strs;
	}
	
	public static void subsol(List<String> strs,String prestr,int p,String substr){
		if(p<prestr.length()){
			switch(prestr.charAt(p)){
                case '2': {
                    subsol(strs, prestr, p+1, substr+"a");
                    subsol(strs, prestr, p+1, substr+"b");
                    subsol(strs, prestr, p+1, substr+"c");
                    break;
                }
                case '3' : {
                    subsol(strs, prestr, p+1, substr+"d");
                    subsol(strs, prestr, p+1, substr+"e");
                    subsol(strs, prestr, p+1, substr+"f");
                    break;
                }
                case '4' : {
                    subsol(strs, prestr, p+1, substr+"g");
                    subsol(strs, prestr, p+1, substr+"h");
                    subsol(strs, prestr, p+1, substr+"i");
                    break;
                }
                case '5' : {
                    subsol(strs, prestr, p+1, substr+"j");
                    subsol(strs, prestr, p+1, substr+"k");
                    subsol(strs, prestr, p+1, substr+"l");
                    break;
                }
                case '6' : {
                    subsol(strs, prestr, p+1, substr+"m");
                    subsol(strs, prestr, p+1, substr+"n");
                    subsol(strs, prestr, p+1, substr+"o");
                    break;
                }
                case '7' : {
                    subsol(strs, prestr, p+1, substr+"p");
                    subsol(strs, prestr, p+1, substr+"q");
                    subsol(strs, prestr, p+1, substr+"r");
                    subsol(strs, prestr, p+1, substr+"s");
                    break;
                }
                case '8' : {
                    subsol(strs, prestr, p+1, substr+"t");
                    subsol(strs, prestr, p+1, substr+"u");
                    subsol(strs, prestr, p+1, substr+"v");
                    break;
                }
                case '9' : {
                    subsol(strs, prestr, p+1, substr+"w");
                    subsol(strs, prestr, p+1, substr+"x");
                    subsol(strs, prestr, p+1, substr+"y");
                    subsol(strs, prestr, p+1, substr+"z");
                    break;
                }
                // default :{}
			}
		}else
		    strs.add(substr);
	}

}
