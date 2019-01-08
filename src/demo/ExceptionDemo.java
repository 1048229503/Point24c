package demo;

public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(1/0);//ArithmeticException
		} catch (Exception e) {
			System.out.println("I catched it!");
		}
		System.out.println("hello world");
		System.out.println(Double.parseDouble("1.11as"));

	}

}
