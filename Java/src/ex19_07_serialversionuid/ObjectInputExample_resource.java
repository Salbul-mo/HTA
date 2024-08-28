package ex19_07_serialversionuid;

import java.io.*;

public class ObjectInputExample_resource {

	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output6.dat"))) 
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
1. serialVersionUID 를 부여하고 직렬화 및 역직렬화
가로: 100
높이: 200
끝

2. 1번의 파일을 getArea 메서드를 주석처리하고 역직렬화
가로: 100
높이: 200
끝
=> 스트림으로 받은 객체의 클래스를 식별하는 serialVersionUID 가 명시적으로 설정되어 있기 때문에
클래스가 변경되어도 같은 클래스의 객체라고 인식해서 오류가 발생하지 않는다. 
*/