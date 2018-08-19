package TempTest1_25;

public class IntegerToRoman {
	public static void main(String args[]){
		
	}
	public static String solution(int num){
		String str = "";
		while(num>=1000){
			str=str+"M";
			num-=1000;
		}
		if(num>=900 && num<1000){
			str=str+"CM";
			num-=900;
		}else if(num>=500 && num<900){
			str=str+"D";
			num-=500;
			while(num>=100){
				str=str+"C";
				num-=100;
			}
		}else if(num>=400 && num<500){
			str=str+"CD";
			num-=400;
		}else if(num>=1 && num<400){
			while(num>=100){
				str=str+"C";
				num-=100;
			}
		}
		if(num>=90 && num<100){
			str=str+"XC";
			num-=90;
		}else if(num>=50 && num<90){
			str=str+"L";
			num-=50;
			while(num>=10){
				str=str+"X";
				num-=10;
			}
		}else if(num>=40 && num<50){
			str=str+"XL";
			num-=40;
		}else if(num>=1 && num<40){
			while(num>=10){
				str=str+"X";
				num-=10;
			}
		}
		if(num>=9 && num<10){
			str=str+"IX";
			num-=9;
		}else if(num>=5 && num<9){
			str=str+"V";
			num-=5;
			while(num>=1){
				str=str+"I";
				num-=1;
			}
		}else if(num>=4 && num<5){
			str=str+"IV";
			num-=4;
		}else if(num>=1 && num<4){
			while(num>=1){
				str=str+"I";
				num-=1;
			}
		}
		return str;
	}

}
