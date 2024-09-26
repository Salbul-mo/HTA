package ex06_2_method;

public class Main_arg3 {
	/*
	 * 2. cmd에서 
	 * java 프로젝트 경로의 bin 폴더 이동
	 * java 패키지명.클래스이름 문자열 입력하고 엔터
	 * ex)D:\Mo_hta\eclipse\Java\bin>java ex06_1_array.Main_arg2 대한 민국 만세
	 * 대한
	 * 민국
	 * 만세
	 * 
	 * D:\Mo_hta\eclipse\Java\bin>java ex06_1_array.Main_arg2 대한 민국 "세종 대왕"
	 * 대한
	 * 민국
	 * 세종 대왕
	 * 
	 * cmd에서 드라이브로 가려면 그냥 D: 를 입력한다.
	 * (cd 없이)
	 */
	
	public static void main(String args[]) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
}

