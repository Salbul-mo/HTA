package ex19_01_serialization;
/*
 * 객체를 직렬화 하는 프로그램
 * 직렬화 : 객체를 네트워크를 통해 전송하거나 파일에 저장하기 위해서 객체를 스트림으로 만드는 작업
 * 이러한 작업을 자바에서는 객체의 직렬화(serialization)이라고 한다.
 * 즉 직렬화는 객체를 바이트 형태로 변환하는 과정이다.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
public class ObjectOutputExample1 {
	
	public static void main(String[] args) {
		/*
		 * 1. 파일을 연다
		 * ObjectOutputStream 클래스는 객체를 스트림으로 만들어서 출력하는 기능이 있는 클래스이다.
		 * 이 클래스에는 데이터를 파일에 저장하는 기능이 없기 때문에 FileOutputStream 클래스와 함께 사용해야 한다.
		 * FileOutputStream 객체를 생성해서 ObjectOutputStream 클래스의 생성자 파라미터에 넘겨주어야 한다.
		 */
		
		ObjectOutputStream out = null; // ObjectOutputStream 객체 생성. 참조값 null.
		
		try {
			out = new ObjectOutputStream(new FileOutputStream("output.dat"));
			//ObjectOutputStream 에 FileOutputStream 을 파라미터로 새로운 객체 생성. out에 참조값 대입
		
		/*
		 * 2. 파일로 쓰기 - 객체르 직렬화 하는 과정이다
		 * writeObject 메서드 : 파라미터로 넘겨준 객체를 스트림으로 만들어서 출력하는 메서드이다.
		 * 파라미터로 넘겨진 객체가 파일에 저장된다.
		 * GregorianCalendar 객체를 생성해서 파일에 사용하자.
		 */
			out.writeObject(new GregorianCalendar(2023,0,14));
			//그레고리안 캘린더에 2023/1/14 날짜 파라미터 넣고 객체 생성. 
			//생성한 객체를 프로젝트 폴더의 output.dat 에 입력한다. 없으면 파일을 생성한다.
			out.writeObject(new GregorianCalendar(2023,0,15));
			//이하 동일
			out.writeObject(new GregorianCalendar(2023,0,16));
			//이하 동일
			
		} catch (IOException ie) { 
			//writeObject 중 발생할 수 있는 IOException 예외 처리
			System.out.println(ie.getMessage());
		}
		finally {
			try {
				if(out != null) // 열려있는 outputStream 닫기
					out.close();
			} catch (IOException ie2) { // outputStream 닫는 중 발생할 수 있는 IOException 처리
				System.out.println(ie2.getMessage());
			}
		}
	}

	
}
