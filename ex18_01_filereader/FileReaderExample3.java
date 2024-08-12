package ex18_01_filereader;

import java.io.*;

public class FileReaderExample3 {

	public static void main(String[] args) {
		FileReader reader = null;
		char arr[] = new char[64]; // 파일에 있는 문자를 담을 char 배열

		try {

			reader = new FileReader("poem.txt");

			while (true) {
				// Returns : The number of characters read
				// arr의 배열 크기 만큼 문자를 읽어 arr에 저장한 후 읽은 개수를 반환한다.
				int num = reader.read(arr); // (cbuf Destination buffer 매개 변수)
				/*
				 * Reads characters into an array. This method will block until some input is
				 * available, an I/O error occurs, or the end of the stream is reached. 
				 * If the length of cbuf is zero, then no characters are read and 0 is returned;
				 * otherwise, there is an attempt to read atleast one character. If no character
				 * is available because the stream is at its end, the value -1 is returned;
				 * otherwise, at least one character is read and stored into cbuf.
				 */
				//int num = reader.read(arr, 0, 10);
				//입력 스트림에서 10개의 문자를 읽어와 arr[0] 부터 10 개의 문자를 저장한다.
				/*
				 * public int read(char[] cbuf, int offset, int length)
				 * 1. 입력 스트림으로부터 length개의 문자만큼 읽고 cbuf[off]부터 length개까지 저장한다.
				 * 2. 실제로 읽은 문자의 수가 length보다 작을 경우 읽은 수만큼 리턴한다.
				 * 3. offset이 0이고, length가 배열의 길이라면 read(char[] cbuf)와 동일하다
				 * 4. int num = reader.read(arr,0,arr.length);
				 */
				
				if (num == -1)
					break;
				for (int cnt = 0; cnt < num; cnt++) { 
					// 반환된 num은 배열에 저장된 데이터의 갯수를 의미하므로 cnt < num
					System.out.printf("%c", arr[cnt]);
				}
			}

		} catch (FileNotFoundException e1) {
			System.out.println("파일 열 때");
		} catch (IOException e) {
			System.out.println("파일 읽을 때");
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				System.out.println("파일 닫을 떄");

			}
		}

	}
}
/*
 * <별을 헤는 밤>
 * 
 * 지은이 : 윤 동주
 * 
 * 계절이 지나가는 하늘에는 가을로 가득 차 있습니다.
 * 
 * 나는 아무 걱정도 없이 가을 속의 별들을 다 헤일 듯 합니다.
 * 
 * 가슴속에 하나 둘 새겨지는 별을 이제 다 못 헤는 것은 쉬이 아침이 오는 까닭이요, 내일 밤이 남은 까닭이요, 아직 나의 청춘이 다하지
 * 않은 까닭입니다.
 * 
 * 별 하나에 추억과 별 하나에 사랑과 별 하나에 쓸쓸함과 별 하나에 동경과 별 하나에 시와 별 하나에 어머니, 어머니, 어머님, 나는 별
 * 하나에 아름다운 말 한 마디씩 불러 봅니다.
 */