package ex19_02_serialization_error;

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
/*
ex19_02_serialization_error.GoodsStock
파일로 출력할 수 없습니다.
java.io.NotSerializableException: ex19_02_serialization_error.GoodsStock
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1197)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:354)
	at ex19_02_serialization_error.ObjectOutputExample1.main(ObjectOutputExample1.java:13)
*/