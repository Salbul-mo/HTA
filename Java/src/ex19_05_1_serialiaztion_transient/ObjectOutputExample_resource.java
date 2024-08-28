package ex19_05_1_serialiaztion_transient;

import java.io.*;

public class ObjectOutputExample_resource {

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output4.dat")))
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
/*
전체게시물의 수: 1
글쓴이: 방탄소년단
패스워드: sunshine
제목: 정모합시다
내용: 이번 주말 어떠세요?
*/