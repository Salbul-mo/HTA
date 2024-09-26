package ex19_06_serialversionuid_no;

import java.io.*;

public class ObjectInputExample_resource {

	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output5.dat"))) 
		{
			while (true) {

				Rectangle rectangle = (Rectangle) in.readObject();
				System.out.println(rectangle);
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (EOFException eofe) {
			System.out.println("끝");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			//java.lang.ClassNotFoundException
			System.out.println(cnfe.getMessage());
		}
	}
}
/*
1. getArea 메서드 주석처리하고 직렬화-역직렬화

가로: 100
높이: 200
끝

2. 1번에서 직렬화한 파일을 getArea 메서드 주석처리 풀고 역직렬화
=> IOExcetion 발생, 직렬화할 때 사용한 클래스와 역직렬화할 때 사용한 클래스의 버전이 다를때 발생하는 에러메시지
ex19_06_serialversionuid_no.Rectangle; local class incompatible: 
stream classdesc serialVersionUID = 6044137569792663866,
local class serialVersionUID = -4505359267677758217

serialVersionUID 를 명시적으로 걸어주지 않으면 컴파일 할때 자동으로 UID가 주어지는데 
직렬화한 이후 클래스의 구성요소가 바뀌면 컴파일 시 자동으로 주어지는 UID 가 달라져서
같은 클래스의 객체로 인식하지 못하게 된다.
*/