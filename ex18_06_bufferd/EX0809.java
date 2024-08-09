package ex18_06_bufferd;

import java.io.*;

import java.util.*;

public class EX0809 {
	public static void main(String args[]) {
		ArrayList<Student6> list = new ArrayList<Student6>();
		input(list);

		// 자바에서 리스트를 정렬하기 위해 사용되는 메서드입니다.
		// 이 메서드는 java.util.Collections 클래스에 속하며 리스트의 요소들을 정렬 규칙에 따라 정렬합니다.(오름차순 또는
		// 내림차순)
		Collections.sort(list);
		print(list);
		// 4. BufferedReader를 이용하고 이 객체의 readLine()이용해서 "jumsu.txt"에서 한 줄씩 읽어옵니다.
		// 파일의 끝을 만나면 return 되는 값은 null입니다.
	}

	private static void input(ArrayList<Student6> as) {
		String str = null;
		try (BufferedReader reader = new BufferedReader(new FileReader("jumsu.txt"))) {
			// jumsu.txt는 프로젝트 폴더에 있습니다.
			while ((str = reader.readLine()) != null) {
				StringTokenizer stok = new StringTokenizer(str);
				while (stok.hasMoreTokens()) {
					String name = stok.nextToken();
					int kor = Integer.valueOf(stok.nextToken());
					int eng = Integer.valueOf(stok.nextToken());
					int math = Integer.valueOf(stok.nextToken());
					as.add(new Student6(name, kor, eng, math));
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void print(ArrayList<Student6> as) {

		System.out.println("=========== 학생별 / 과목별 총점 구하기 ===========");
		System.out.println("\t국어\t영어\t수학\t총점\t평균");

		for (int i = 0; i < as.size(); i++) {
			System.out.println(as.get(i).toString());
		}

		System.out.print(String.format("%48s", "\n총점").replace(" ", "="));
		for (int sub : Student6.subject) {
			System.out.print("\t" + sub);
		}
		System.out.println();
	}

}
