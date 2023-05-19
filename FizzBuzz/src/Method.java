public class Method {
	private int number;
	public Method() {
		number = 0;
	}
	
	public Method(int n) {
		number = n;
	}
	
	public String printFizzBuzz() {
		if (number % 3 == 0)
			return "Fizz";

	}
}
