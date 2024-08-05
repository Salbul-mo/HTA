package ex06_1_array;

import java.util.Scanner;

public class ArrayTest06_String {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String names[] = {"홍길동", "전우치", "홍길동" ,"세종대왕" ,"김길동"};
		
		System.out.print("검색할 이름을 입력하세요>");
		String inputName = sc.next();
		
		for (int i = 0; i < names.length ; i++) {
			if (inputName.equals(names[i])) {
				System.out.println("이름:" + inputName);
				System.out.println(names[i]+"는(은) 배열의 인덱스 "+ i + "에서 찾았습니다." );
				break;
				//조건 만족할때 break를 붙이는 습관 들이자.
			} else if (i == names.length-1) {
				System.out.println("이름:" + inputName);
				System.out.println(inputName + "는(은) 배열방에서 찾지 못했습니다.");
			}
		}
		
		sc.close();
		
		
	}

}
/* 
 *   int index = -1; 로 베열 인덱스와 겹치지 않는 정수를 초기화하고
 *   
 *   for 문을 통해 값을 비교하고 조건에 맞는 인덱스를 대입한다.
 *   
 *   이 후 마지막에 index를 초기값과 비교하고 변하였으면 조건에 맞는 출력을 하고
 *   초기값과 변한게 없으면 그에 맞는 조건을 출력하면 된다.
 *   if (index == -1) "찾지 못했습니다."
 *      else "어디에서 찾았습니다."
 */
