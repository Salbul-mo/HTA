package ex19_02_serialization_error;

import java.io.EOFException;
/*
 * 객체를 역직렬화하는 프로그램
 * 프로그램에 입력된 스트림으로부터 다시 객체를 만들어 내는 작업을 역직렬화(deserialization)이라고 한다.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ObjectInputStreamExample1 {

	public static void main(String[] args) {
		/*
		 * 1. 파일을 연다 ObjectInputStream 클래스는 스트림 형태로 읽어들인 객체를 프로그램에서 사용할 수 있는 객체로 만드는 기능의
		 * 클래스이다. 이 클래스를 FileInputStream 클래스와 함께 사용하면 저장된 객체를 프로그램에서 다시 읽어서 사용할 수 있다.
		 * FileInputStream 객체를 생성해서 ObjectInputStream 생성자 파라미터로 넘겨주어야 한다.
		 */

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output.dat"))) {
			while (true) {
				/*
				 * 2. 파일 읽기 - 객체를 역직렬화하는 부분이다. readObject 메서드 : 입력된 스트림으로부터 객체를 만들어서 리턴하는 메서드로
				 * 리턴 타입은 Object이다. 리턴 타입 Object를 원래 클래스 타입으로 사용하기 위해 캐스트 시켜야 한다. readObject() 가
				 * Object형이므로 GregorianCalendar 타입으로 형 변환한다.
				 */
				GregorianCalendar calendar = (GregorianCalendar) in.readObject();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				System.out.println(year + "/" + month + "/" + date);

			}
		} catch (FileNotFoundException fnfe) { // 파일이 존재하지 않을 때 발생하는 예외처리
			System.out.println(fnfe.getMessage());
		} catch (EOFException eofe) { // 파일로부터 더이상 읽을 객체가 없을 때 발생하는 예외처리
			System.out.println("끝"); // 해주지 않으면 null 이 튀어나온다. 반드시 처리해주자.
		} catch (IOException ioe) { // 스트림을 읽어 들어올 때 발생하는 예외처리, InputStream 닫을 때 일어나는 예외 처리
			System.out.println(ioe.getMessage());
		} catch (ClassNotFoundException cnfe) { // 클래스가 존재하지 않을 때 발생하는 예외처리
			System.out.println(cnfe.getMessage());

		}

	}
}


