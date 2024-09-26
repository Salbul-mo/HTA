package ex18_10_file;

/*
 * 현재 디렉토리의 서브디렉토리와 파일 목록을 출력하는 프로그램
 * File 클래스 : 파일 관리 기능을 갖는 클래스
 * 디렉토리 관리 기능도 가지고 있다.
 */
import java.io.*;
import java.text.SimpleDateFormat;

public class FileExample1_0 {

	public static void main(String args[]) {

		File file = new File("."); // 현재 디렉토리(.) 상위 디렉토리 (..)
		// 파일 관리에 사용되는 File 클래스
		// File file = new File("."); => 현재 디렉토리 경로명을 가지고 File 객체를 생성한다.

		File arr[] = file.listFiles(); // 서브 디렉토리와 파일 목록을 가져온다.

		for (int cnt = 0; cnt < arr.length; cnt++) {
			String name = arr[cnt].getName(); // 이름을 리턴

			if (arr[cnt].isFile()) // 파일이면 true 아니면 false
				System.out.printf("%-25s%7d\t", name, arr[cnt].length());
			// arr[cnt].length() : 파일의 크기(바이트), 파일이면 크리 출력
			// 왼쪽으로 정렬 25자리 문자열,오른쪽으로 정렬 7자리 정수 그리고 tab
			else
				System.out.printf("%-25s%7s\t", name, "<DIR>");
			// 왼쪽으로 정렬 25자리 문자열, 오른쪽으로 정렬 7자리 문자열 그리고 tab 파일이 아니면 <DIR> 출력

			// 1970년 1월 1일 0시 0분 0초 기점으로 경과한 밀리세컨드 값을 리턴
			// 사람이 이해할 수 있는 날짜와 시간으로 변경할 필요가 있다.
			long time = arr[cnt].lastModified();// 최종 수정일시를 리턴
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
			System.out.printf("%s\n",sdf.format(time)); 
			//SimpleDateFormat 사용해서 변경
			/*
		   패턴  의미                      		출력
			G	연대(BC,AD)	            		AD
			y	년도								2022
			M	월 (1~12월 또는 1월~12월)			4또는 4월, April
			w	년의 몇 번째 주(1~53)	    		16
			W	월의 몇 번째 주(1~5)	    		3
			D	년의 몇 번째 일(1~366)	    		102
			d	월의 몇 번째 일(1~31)	    		12
			F	월의 몇 번째 요일(1~5)	    		2
			E	요일	                    		Tue or 화
			a	오전/오후(AM,PM)	        		AM
			H	시간(0~23)	            		10
			k	시간(1~24)	            		10
			K	시간(0~11)	            		10
			h	시간(1~12)	            		10
			m	분(0~59)	                		0
			s	초(0~59)	                		0
			S	천분의 1초(0~999)	        		468
			z	Time zone(General time zone)	KST
			Z	Time zone(RFC 822 time zone)	+0900
			'	escape문자(특수문자를 표현하는데 사용)	 
			*/
			
			
			//System.out.printf("%d\n", time);
			/* 유닉스 시간(Unix time, Unix time stamp, POSIX time, Epoch time)은 
			 * 유닉스 계열의 운영체제를 사용하는 컴퓨터에서 시간을 표시하는 방법이다. 
			 * 정확히는 UTC 기준 1970년 1월 1일 자정(0시 0분 0초)[1]에서부터 
			 * 현재까지 몇 초가 지났는지를 정수 형태로 표시한다. 그레고리력을 따르지만 윤초는 무시한다.
			 */
		}
	}
}
/*
밀리세컨드 출력
.classpath                  1185	1724802800565
.gitignore                     6	1722902096056
.project                     380	1721631151305
.settings                  <DIR>	1722902080705
bin                        <DIR>	1724803631055
ex18_02_filewriter           546	1723181370080
jumsu.txt                    100	1723192876615
output.txt                   185	1723175342235
output1.dat                   21	1723183614860
poem.txt                     697	1723171413093
src                        <DIR>	1724803630896

SimpleDateFormat 사용해서 출력
.classpath                  1185	2024-08-28 오전 08:53
.gitignore                     6	2024-08-06 오전 08:54
.project                     380	2024-07-22 오후 15:52
.settings                  <DIR>	2024-08-06 오전 08:54
bin                        <DIR>	2024-08-28 오전 09:07
ex18_02_filewriter           546	2024-08-09 오후 14:29
jumsu.txt                    100	2024-08-09 오후 17:41
output.txt                   185	2024-08-09 오후 12:49
output1.dat                   21	2024-08-09 오후 15:06
poem.txt                     697	2024-08-09 오전 11:43
src                        <DIR>	2024-08-28 오전 09:07
 */

