package guiWin;
//A number with both a numerator and a denomenator
public class Fraction {
	//Global Denominator and Numerator
	private int num, den;
	
	//Constants--------------------
	public static final Fraction ONE = new Fraction(1,1);
	public static final Fraction ZERO = new Fraction(0,1);
	
	
	//Constructors-----------------------
	public Fraction() {
		this.set(Fraction.ONE);
	}
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	public Fraction(int num) {
		this(num,1);
	}
	public Fraction(Fraction f) {
		this.num = f.num;
		this.den = f.den;
	}
	
	//For directly setting a new value
	public void set(int num, int den) {
		this.num = num;
		this.den = den;
	}
	public void set(int num) {
		this.set(num,1);
	}
	public void set(Fraction f) {
		this.num = f.num;
		this.den = f.den;
	}
	
	//Math-------------------------------
	public static Fraction multiply(Fraction f1, Fraction f2){
		return new Fraction(f1.num*f2.num,f1.den*f2.den);
	}
	public static Fraction divide(Fraction f1, Fraction f2) {
		return new Fraction(f1.num*f2.den,f1.den*f2.num);
	}
	public static Fraction add(Fraction f1, Fraction f2) {
		return new Fraction((f1.num*f2.den+f2.num*f1.den)/(f1.den*f2.den));
	}
	public static Fraction subtract(Fraction f1, Fraction f2) {
		return new Fraction((f1.num*f2.den-f2.num*f1.den)/(f1.den*f2.den));
	}
	
	//Display----------------------------------------
	public String toString() {
		return num + "/" + den;
	}
	
}
