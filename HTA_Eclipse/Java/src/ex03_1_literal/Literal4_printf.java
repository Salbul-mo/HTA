package ex03_1_literal;

public class Literal4_printf {
	
	public static void main(String args[]) {
		/*
		 * 1. System.out.println(); 출력 한 후 한 행을 띄웁니다.
		 * 2. System.out.print(); 출력한 후 행을 띄지 않고 유지합니다.
		 * 3. System.out.printf(); 서식을 지정해서 출력합니다.
		 * 			형식 : ("포맷 명시자" , 데이터)
		 * 			주의점 : %로 시작하는 포맷 갯수와 데이터의 갯수가 일치해야 합니다.
		 */
		
		System.out.printf("%d\n", 42); 
		// 정수 42를 정수 서식(%d)으로 출력해라 \n 줄 바꿈
		System.out.printf("%f",42.195); 
		// 실수 42.195 (기본 소수점 이하 6자리) 42.195000 으로 출력
		System.out.println(); 
		//줄 바꿈.
		
		System.out.printf("%.2f%n",42.195);
		//실수 42.195를 실수 서식 소수점 이하 2자리(%.2f)로 출력해라. 소수점 아래 3자리에서 반올림
		//\n(%n) 은 출력 후 줄 바꾸라는 서식
		
		
		
		System.out.printf("%6.3f%n", 42.195);
		//전체 6자리에 소수점과 소수점 이하 자리 3자리를 출력
		System.out.printf("%7.3f%n", 42.195);
		//전체 7자리에 소수점과 소수점 이하 자리 3자리를 출력;
		
		System.out.printf("%10d\n",42);
		//정수 42를 정수 서식(%10d)로 출력해라 - 10칸의 자리, 오른쪽 정렬
		// 빈칸 8개 + 정수 2개
		
		System.out.printf("%c%n", 'A');
		// 문자 'A'를 문자 서식(%c) 로 출력해라.
		
		System.out.printf("%s%n","홍길동");
		// 문자 "홍길동"을 문자열 서식 (%s)로 출력해라
		
		System.out.printf("%10s\n","홍길동");
		// 문자 "홍길동"을 문자열 서식(%10s)로 출력해야 - 10칸의 자리, 오른쪽 정렬
		// 빈칸 7개 + 홍길동 3개
		System.out.printf("%-10s\n", "홍길동");
		// 문자 "홍길동"을 문자열 서식(%-10s)로 출력해라 - 10칸의 자리, 왼쪽 정렬
		// 홍길동 3개 + 빈칸 7개
		System.out.printf("\n나의 이름은 %s, 나의 나이는 %d세 입니다.","홍길동",21);
		// 줄바꿈 + "나의 이름은" +  %s + ", 나의 나이는" +  %d + "세 입니다."
		// %s 에 홍길동.  %d 에 21
		// 10자리 5자리 오른쪽 왼쪽
		System.out.printf("\n나의 이름은 %10s, 나의 나이는 %5d세 입니다.","홍길동",21);
		System.out.printf("\n나의 이름은 %-10s, 나의 나이는 %-5d세 입니다.","홍길동",21);
		
	}

}
