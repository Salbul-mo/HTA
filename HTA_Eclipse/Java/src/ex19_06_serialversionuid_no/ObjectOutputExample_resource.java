package ex19_06_serialversionuid_no;

import java.io.*;

public class ObjectOutputExample_resource {

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output5.dat")))
		{
			Rectangle obj = new Rectangle (100,200);
			System.out.println(obj);
			//System.out.println(obj.toString()) 이 내부적으로 일어난다. 
			
			out.writeObject(obj); // 객체 직렬화
			
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
			ioe.printStackTrace();
		}
	}
}
/*
serialUID 부여하지 않은 상태
getArea 메서드 주석처리하고 직렬화
가로: 100
높이: 200

*/