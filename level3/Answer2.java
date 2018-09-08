package level3;

import java.math.BigInteger;

public class Answer2 {
	
	public static BigInteger gen = new BigInteger("0");
	public static BigInteger f; 
	public static BigInteger m;
	
	public static final String IMP = "impossible";

	
	public static String answer(String M, String F) {//compareTo -1 is less, 0 is equal, 1 is we're greater
		m = new BigInteger(M);
		f = new BigInteger(F);
		System.out.println(f + " " + m);
		
		while(f.compareTo(BigInteger.ONE) == 1 || m.compareTo(BigInteger.ONE) == 1) { //F > 1 || M > 1
			if((f.mod(m).equals(BigInteger.ZERO) || m.mod(f).equals(BigInteger.ZERO)) && //if f%m == 0 (even divide) && f != 1 && m != 1
					(!f.equals(BigInteger.ONE) && !m.equals(BigInteger.ONE)))
				return IMP;
			if((f.compareTo(m) == 1 && m.equals(BigInteger.ONE)) || (m.compareTo(f) == 1 && f.equals(BigInteger.ONE))) {
				if(f.compareTo(m) == 1) {
					f.subtract(BigInteger.ONE);
					System.out.println("1");
					return gen.add(f.subtract(BigInteger.ONE)).toString();
				}
				else {
					m.subtract(BigInteger.ONE);
					System.out.println("2");
					return gen.add(m.subtract(BigInteger.ONE)).toString();
				}
			}
			
			if(f.add(BigInteger.ONE).equals(m)) {
				return gen.add(f).toString();
			}
			else if(m.add(BigInteger.ONE).equals(f)) {
				return gen.add(m).toString();
			}
			
			if(f.compareTo(m) == 1) { 						//If f > m
				System.out.print(f + "F " + m + "F " + gen + "G ");
				BigInteger temp = new BigInteger(f.toString());
				f = f.mod(m);
				gen.add(temp.divide(m));
				gen = gen.add(temp.divide(m));
				System.out.println(f + "F " + m + "F " + gen + "G ");
			}
			if(m.compareTo(f) == 1) { 					//If m > f
				System.out.print(f + "F " + m + "F " + gen + "G ");
				BigInteger temp = new BigInteger(m.toString());
				m = m.mod(f);								//Get remainder, which is new number
				gen = gen.add(temp.divide(f));				//Increment gen by times it went in evenly
				System.out.println(f + "F " + m + "F " + gen + "G ");
			}
		}
		
		return gen.toString();
	}
	
	public static String power(int a, int b) {
		BigInteger temp = new BigInteger(Integer.toString(a));
		temp = temp.pow(b);
		return temp.toString();
	}
	
	public static String power2(int a, int b) {
		BigInteger temp = new BigInteger(Integer.toString(a));
		temp = temp.pow(b);
		temp = temp.subtract(BigInteger.ONE);
		return temp.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(answer("2", "3"));
	}

}
