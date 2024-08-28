package ex19_03_serializable_interface;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample1 {

	public static void main(String[] args) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output2.dat"))) {

			out.writeObject(new GoodsStock("70101", 100));
			out.writeObject(new GoodsStock("70102", 50));
			out.writeObject(new GoodsStock("70103", 200));

		} catch (IOException ie) { 
			// ObjectOutputStream 이 발생 시키는 IOException과 FileOutputStream 이 발생시키는 FileNotFound 예외
			System.out.println(ie.getMessage());
			System.out.println("파일로 출력할 수 없습니다.");
			ie.printStackTrace();
		}

	}

}
