import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("This program is a fraction calculator\n"
				+ "It will add, subtract, multiply and divide fractions until you type Q to quit.\n"
				+ "Please enter your fractions in the form a/b, where a and b are integers.\n"
				+ "---------------------------------------------------------------------------------");
		String operator = getOperation(input);
		while (!operator.equalsIgnoreCase("Q")) {
			Fraction fraction1 = getFraction(input);
			Fraction fraction2 = getFraction(input);
			if (operator.equals("+")) {
				Fraction result = fraction1.add(fraction2);
				System.out.println(fraction1.toString() + " + " + fraction2.toString() + " = " + result.toString());
				System.out.println("---------------------------------------------------------------------------------");
			} else if (operator.equals("-")) {
				Fraction result = fraction1.subtract(fraction2);
				System.out.println(fraction1.toString() + " - " + fraction2.toString() + " = " + result.toString());
				System.out.println("---------------------------------------------------------------------------------");
			} else if (operator.equals("/")) {
				Fraction result = fraction1.divide(fraction2);
				System.out.println(fraction1.toString() + " / " + fraction2.toString() + " = " + result.toString());
				System.out.println("---------------------------------------------------------------------------------");
			} else if (operator.equals("*")) {
				Fraction result = fraction1.multiply(fraction2);
				System.out.println(fraction1.toString() + " * " + fraction2.toString() + " = " + result.toString());
				System.out.println("---------------------------------------------------------------------------------");
			} else if (operator.equals("=")) {
				boolean result = fraction1.equals(fraction2);
				System.out.println(fraction1.toString() + " = " + fraction2.toString() + " is " + result);
				System.out.println("---------------------------------------------------------------------------------");
			}
			operator = getOperation(input);
		}
		
	}
	
	public static String getOperation(Scanner input) {
		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		String operation = input.next();
		while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") && !operation.equals("=") && !operation.equalsIgnoreCase("q")) {
			System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
			operation = input.next();
		}
		return operation;
	}
	
	public static boolean validFraction(String stringIn) {
		if (stringIn.startsWith("-")) {
			stringIn = stringIn.substring(1); // If stringIn started with -, then stringIn is now = stringIn from index 1 onwards (without the - character)
		}
		if (stringIn.contains("/")) {
			String[] split = stringIn.split("/", 2);
			if (isNumber(split[0]) == false || isNumber(split[1]) == false || Integer.parseInt(split[1]) == 0) {
				return false;
			} else {
				return true;
			}			
		} else if (isNumber(stringIn)) {
			return true; // If stringIn is just an integer, it will return as valid
		} else {
			return false;
		}
	}
	
	public static boolean isNumber(String stringIn) {
		if (stringIn.matches("\\d+")) {
			return true; // stringIn only consists of numbers[0-9]
		}
		return false; // stringIn contains something other than numbers[0-9]
		
	}
	
	public static Fraction getFraction(Scanner input) {
		System.out.print("Please enter a fraction (a/b) or integer (a): ");
		String stringIn = input.next();
		while (validFraction(stringIn) == false) {
			System.out.print("Invalid fraction. Please enter a fraction (a/b) or integer (a): ");
			stringIn = input.next();
		}
		if (isNumber(stringIn)) {
			Fraction fraction = new Fraction(Integer.parseInt(stringIn)); // If stringIn is just an integer, it will return as valid
			return fraction;
		} else if (stringIn.contains("/")) {
			String[] split = stringIn.split("/", 2);
			Fraction fraction = new Fraction(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			return fraction;
		} else {
			Fraction fraction = new Fraction(Integer.parseInt(stringIn));
			return fraction;
		}
	}

}
