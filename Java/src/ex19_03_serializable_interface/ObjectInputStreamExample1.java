package ex19_03_serializable_interface;

import java.io.EOFException;
/*
 * 객체를 역직렬화하는 프로그램
 * 프로그램에 입력된 스트림으로부터 다시 객체를 만들어 내는 작업을 역직렬화(deserialization)이라고 한다.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample1 {

	public static void main(String[] args) {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output2.dat"))) 
		{
			
			while (true) {
				GoodsStock goodsStock = (GoodsStock) in.readObject(); 
				// Object 클래스를 GoodsStock 클래스로 캐스트
				System.out.println(goodsStock.toString()); 
				// GoodsStock 클래스의 toString으로 정보 출력
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
/*
 * 상품코드:70101 상품수량:100 
 * 상품코드:70102 상품수량:50 
 * 상품코드:70103 상품수량:200 
 * 끝
 */
