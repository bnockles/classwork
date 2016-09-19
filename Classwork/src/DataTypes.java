import java.math.BigDecimal;

public class DataTypes {

	public static final int digits = 8;

	public static void main(String[] args) {
		System.out.println(".1+.2 = "+(.1+.2));
		String s1 = representAsBinary(new BigDecimal(.1));
		String s2 = representAsBinary(new BigDecimal(.2));
		System.out.println(add(s1, s2));
		representAsBinary(new BigDecimal(.30000000000000004));
	}

	private static String add(String s1, String s2) {
		String answer = "";
		int index = digits;
		String carry = "0";
		while(index >0){
			String s = "0";
			if(s1.charAt(index) == '1' && s1.charAt(index) == '1'){
				if(carry.equals("1")){
					s = "1";
				}
				carry = "1";
			}else if((s1.charAt(index) == '0' && s1.charAt(index) == '1') || s1.charAt(index) == '1' && s1.charAt(index) == '0'){
				if(carry.equals("1")){
					s = "0";
					carry = "1";
				}else{
					s = "1";
					carry = "0";
				}

			}else{
				if(carry.equals("1")){
					s = "1";
					carry = "0";
				}else{
					s = "0";
					carry = "0";
				}
			}
			answer = s+answer;
			index --;
		}
		return "0."+answer;
	}


private static String representAsBinary(BigDecimal d) {
	String s = "0.";
	int digitCount = 0;
	BigDecimal subtractor = new BigDecimal(.5);
	while(d.compareTo(new BigDecimal(0)) > 0 && digitCount < digits){
		if(subtractor.compareTo(d)<0) {
			d = d.subtract(subtractor);
			//				System.out.print(subtractor+"+");
			s+="1";
		}else{
			s+="0";
		}
		digitCount ++;
		subtractor = subtractor.divide(new BigDecimal(2));
	}
	System.out.println("\n"+s);
	return s;
}

}
