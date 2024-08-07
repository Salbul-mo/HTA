package ex16_3_system.arraycopy;

public class System1_arraycopy {

	public static void main(String[] args) {
			//           0     1    2    3     4    5     6    7     8    9    10    1    2     3
		char arr1[] = { '가', '나', '다', '라', '마', '바', '사', '아', '자', '차', '카', '타', '파', '하' };
		   //            0    1    2    3    4    5    6    7    8    9    10
		char arr2[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' };

// System.arraycopy(원본 배열, 원본 항목 시작 위치, 복사 대상 배열, 복사 대상 항목 시작 위치, 복사할 항목의 수);
				
				//      원본,   복사할index시작, 붙여넣을 배열, 붙여넣기 될 index위치, 복사할 index 수 
		System.arraycopy(arr1,       10   ,   arr2  ,           2         ,       3  );
		for (char ch : arr2) {
			System.out.print(ch + " ");
		}
		System.out.println();
		
		char[] arr3 = new char[arr1.length];
		System.arraycopy(arr1,0,arr3,0,arr1.length);
		// 복사할 인덱스 숫자 갯수이니까 전체 복사면 arr1.length개가 맞다.
		
		for(char ch : arr3) {
			System.out.print(ch +" ");
		}
	}
}
