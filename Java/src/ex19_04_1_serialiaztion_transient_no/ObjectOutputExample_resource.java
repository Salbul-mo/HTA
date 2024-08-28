package ex19_04_1_serialiaztion_transient_no;

import java.io.*;

public class ObjectOutputExample_resource {

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output3.dat")))
		{
			BBSItem obj = new BBSItem("방탄소년단","sunshine","정모합시다","이번 주말 어떠세요?");
			System.out.println(obj);
			//System.out.println(obj.toString()) 이 내부적으로 일어난다. 
			
			out.writeObject(obj); // 객체 직렬화
			
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
			ioe.printStackTrace();
		}
	}
}
