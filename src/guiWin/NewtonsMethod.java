package guiWin;
//Finding a root or an exponent of a BigDecimal using Newton's Method

import java.math.*;

public class NewtonsMethod{
	
	//---------------------------------------------------------------VARIANTS OF BDexp----------------------------------------------------------------------------------------------------
	/*
	public static BigDecimal BDexp(BigDecimal base, BigDecimal expD) {
		BigDecimal num = base;
		BigInteger expI = new BigInteger((expD.toBigInteger()).toString()); //Converts expD to integer (Drops the decimal) then changes it to a string so expI can have the integer value
		
		for(BigInteger i = new BigInteger("1"); i.compareTo(expI) == -1; i = i.add(BigInteger.ONE)) {
			num = num.multiply(base);
			//System.out.println(num); //<-for debuging purposes
		}
		
		//preparing numbers for the root portion of the calculation
		BigInteger rootB = //got from StackOverflow   this takes the decimal part of expD
                expD.remainder(BigDecimal.ONE).movePointRight(expD.scale()).abs().toBigInteger();
		long scale = (long)Math.pow(10,expD.scale()); 
		long root = rootB.intValue();
		BigDecimal rootBD = new BigDecimal(rootB.toString());
		
		System.out.print("base"+ base+"  num"+num+"  rootB"+rootB+"  scale"+scale+"  root"+root+"  rootBD"+rootBD+"\n");

		//Math derived from x^(a/b) = xroot(x^a,b) 
		BigDecimal test;
		if(root!=0) {
			test=BDexp(base,root);
			System.out.println("test"+test);
			base = BDroot(test, scale, base, 500);
		}
		num = num.multiply(base);
		return num;
	}*/
	public static BigDecimal BDexp(BigDecimal base, BigDecimal exp) {
		BigDecimal num = base; //Seperating variable so base does not get changed during calculations
		
	/*	BigInteger expIntegerPart = new BigInteger(exp.toBigInteger().toString()); //Isolates the integer part of the exponent
		
		BigInteger expDecimalPart = //got from StackOverflow   this isolates the decimal part of exponent
                exp.remainder(BigDecimal.ONE).movePointRight(exp.scale()).abs().toBigInteger();
		
		//Converting the decimal to a fraction eg 2.4 -> 24/10 or 12/5 BUT only the top part for now eg 2.4 -> 24
		expIntegerPart.multiply(BigInteger.valueOf(exp.scale())) .add(expDecimalPart);
		*/
		
		BigInteger exp2 = new BigInteger(exp.multiply(BigDecimal.TEN.pow(exp.scale())).toString());
		num = BDroot(BDexp(num, exp2), (long)Math.pow(10, exp.scale()),base.divide(BigDecimal.TEN),500);
		return num;
	}
	
	public static BigDecimal BDexp(BigDecimal base, BigInteger exp){
		
		BigDecimal num = base;
		BigDecimal expD = new BigDecimal(exp.toString());
		
		for(BigInteger i = BigInteger.ONE; i.compareTo(exp)== -1; i = i.add(BigInteger.ONE)) {
			num = num.multiply(expD);
		}
		
		return num;
	}
	
	
	public static  BigDecimal BDexp(BigDecimal base, long exp) {//is equivilant to bd.pow(long) (long instead of int)
		
		BigDecimal num = base;
		
		for(long i = 1; i < exp; i++) {
			num = num.multiply(base);
		}
		
		return num;
	}
	
	
	public static  BigDecimal BDexp(BigDecimal base, int exp) {//is equivilant to bd.pow(int)
	
		BigDecimal num = base;
	
		for(int i = 1; i < exp; i++) {
			num = num.multiply(base);
		}
	
		return num;
	}
	
	
	//--------------------------------------------------------------------VARIANTS OF BDroot-------------------------------------------------------------------------------------------
	
	
	
	public static BigDecimal BDroot(BigDecimal base, int root, BigDecimal guess, int guessNum){

		BigDecimal rootBD = new BigDecimal(String.valueOf(root));
		BigDecimal num = BigDecimal.ONE;
		int count = 0;
		//MathContext round = new MathContext(20,RoundingMode.HALF_DOWN);
		
		
		num = guess.subtract((BDexp(guess,root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(guess,(root-1))/*guess.pow(root-1)*/, MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);
		//divide has DECIMAL64 (precision 16) and subtract has DECIMAL32 (precision 7)
		// (above) num = guess - (guess^root - start)/(root * guess^(root-1))	
																																						       
		do {
			
			num = num.subtract((num.pow(root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(num,(root-1))/*num.pow(root-1)*/, MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);

			count++;
			
		}while(count < guessNum);
		
		return num;
	}
	
	
	public static BigDecimal BDroot(BigDecimal base, long root, BigDecimal guess, long guessNum){

		BigDecimal rootBD = new BigDecimal(String.valueOf(root));
		BigDecimal num = BigDecimal.ONE;
		int count = 0;
		//MathContext round = new MathContext(20,RoundingMode.HALF_DOWN);
		
		
		num = guess.subtract((BDexp(guess,root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(guess,(root-1)), MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);
		//divide has DECIMAL64 (precision 16) and subtract has DECIMAL32 (precision 7)
		// (above) num = guess - (guess^root - start)/(root * guess^(root-1))	
																																						       
		do {
			
			num = num.subtract((BDexp(num,root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(num,(root-1)), MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);

			count++;
			
		}while(count < guessNum);
		
		return num;
	}

	public static BigDecimal BDroot(BigDecimal base, long root, BigDecimal guess, int guessNum){

		BigDecimal rootBD = new BigDecimal(String.valueOf(root));
		BigDecimal num = BigDecimal.ONE;
		int count = 0;
		//MathContext round = new MathContext(20,RoundingMode.HALF_DOWN);
		
		
		num = guess.subtract((BDexp(guess,root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(guess,(root-1)), MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);
		//divide has DECIMAL64 (precision 16) and subtract has DECIMAL32 (precision 7)
		// (above) num = guess - (guess^root - start)/(root * guess^(root-1))	
																																						       
		do {
			
			num = num.subtract((BDexp(num,root).subtract(base, MathContext.DECIMAL128)).divide(rootBD.multiply(BDexp(num,(root-1)), MathContext.DECIMAL128), MathContext.DECIMAL128), MathContext.DECIMAL128);

			count++;
			
		}while(count < guessNum);
		
		return num;
	}

}

