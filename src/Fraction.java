
public class Fraction {
	//Private fields:
	
	private int num = 0;
	private int den = 0;
	
	
	// Constructors:
	
	public Fraction(int num, int den) {
		if (den == 0) {
			throw new IllegalArgumentException("Denominator cannot be zero");
		} else if (den < 0 && num < 0) {
			this.den = Math.abs(den);
			this.num = Math.abs(num);
		} else if (den < 0 && num > 0) {
			this.den = Math.abs(den);
			this.num = 0 - num;
		} else {
			this.num = num;
			this.den = den;
		}
	}
	
	public Fraction(int num) {
		this(num, 1);
	}
	
	public Fraction() {
		this(0, 1);
	}
	
	// Accessors and Mutators:
	
	public int getNumerator() {
		return num;
	}
	
	public int getDenominator() {
		return den;
	}
	
	public String toString() {
		if (getNumerator() == 0 || getDenominator() == 1 || getNumerator() == getDenominator()) {
			return num + "";
		} else return num + "/" + den;
	}
	
	public double toDouble() {
		return (double) num / den;
	}
	
	public Fraction add(Fraction other) {
		int newNum;
		int newDen;
		if (this.den == other.den) {
			newNum = this.num + other.num;
			Fraction fraction = new Fraction(newNum, this.den);
			fraction.toLowestTerms();
			return fraction;
		}
		newNum = (this.num * other.den) + (this.den * other.num);
		newDen = this.den * other.den;
		Fraction fraction = new Fraction(newNum, newDen);
		fraction.toLowestTerms();
		return fraction;
	}
	
	public Fraction subtract(Fraction other) {
		int newNum;
		int newDen;
		if (this.den == other.den) {
			newNum = this.num - other.num;
			Fraction fraction = new Fraction(newNum, this.den);
			fraction.toLowestTerms();
			return fraction;
		}
		newNum = (this.num * other.den) - (this.den * other.num); 
		newDen = this.den * other.den;
		Fraction fraction = new Fraction(newNum, newDen);
		fraction.toLowestTerms();
		return fraction;
	}
	
	public Fraction multiply(Fraction other) {
		int newNum = this.num * other.num;
		int newDen = this.den * other.den;
		Fraction fraction = new Fraction(newNum, newDen);
		fraction.toLowestTerms();
		return fraction;
	}
	
	public Fraction divide(Fraction other) {
		int newNum = this.num * other.den;
		int newDen = this.den * other.num;
		Fraction fraction = new Fraction(newNum, newDen);
		fraction.toLowestTerms();
		return fraction;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Fraction) {
			double otherDouble = ((Fraction) other).toDouble();
			double thisDouble = this.toDouble();
			if (otherDouble == thisDouble) {
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	private void toLowestTerms() {
		if (this.num != 0) {
			int a = Fraction.gcd(this.num, this.den);
			this.num = this.num / Math.abs(a);
			this.den = this.den / Math.abs(a);
		}
	}
	
	public static int gcd(int a, int b) {
		while (a != 0 && b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
	    return a;
	}
}
