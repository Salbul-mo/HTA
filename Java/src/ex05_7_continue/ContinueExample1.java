package ex05_7_continue;

public class ContinueExample1 {
	
	public static void main(String[] continues) {
		
		for ( int i = 1 ; i < 10 ; i++ ) {
			if ( i != 5 ) {
				System.out.println(i);
			}	
		}
		
		System.out.println("==============================");
		
		for (int i = 1 ; i < 10 ; i++) {
			if ( i == 5 ) {
				continue;
			}
			System.out.println(i);
		}
		
		
		
	}

}
