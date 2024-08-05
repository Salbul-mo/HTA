
class Exercise8_4 {
	static void method(boolean b) {
		try {
			System.out.println(1);
			if (b) throw new ArithmeticException();
			System.out.println(2);
		} catch (RuntimeException r) {
			System.out.println(3);
			return;
		} catch (Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		
		System.out.println(5);
	}
	
	public static void main(String[] args) {
		method(true);  //1 . 2. 4. 5 5?
		method(false); // 1. 2 5 5?
	}

}
