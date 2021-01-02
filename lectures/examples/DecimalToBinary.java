
public class DecimalToBinary {
	
	public static void main(String[] args) {
		int ascii = args[0].charAt(0);
		String binary = "";
		
		for(int temp = ascii; temp > 0; temp /= 2) { 
			binary = temp % 2 + binary;
		}
		
//		while(decimal > 0) {
//			int modulus = decimal % 2;
//			decimal /= 2;
//			binary = modulus + binary;
//		}
		
		System.out.println(ascii + " in binary is " + binary);
	}

}
