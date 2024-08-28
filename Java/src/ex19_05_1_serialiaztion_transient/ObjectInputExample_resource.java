package ex19_05_1_serialiaztion_transient;

import java.io.*;

public class ObjectInputExample_resource {

	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output4.dat"))) {
			while (true) {

				BBSItem bbsitem = (BBSItem) in.readObject();
				System.out.println(bbsitem);
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
전체게시물의 수: 0
글쓴이: 방탄소년단
패스워드: null <- transient 키워드
제목: 정모합시다
내용: 이번 주말 어떠세요?
끝
*/