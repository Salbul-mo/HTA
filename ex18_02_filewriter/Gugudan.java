package ex18_02_filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class Gugudan {
	public static void main(String[] s) {
		try {								                    // 경로 /파일이름.확장자
			FileWriter writer = new FileWriter("src/ex18_02_filewriter/gugudan.txt");
			                                  // 상대 경로이다.
			//현재 디렉토리는 C:\Users\jhta\git\HTA_Eclipse\Java 이다.
			// new FileWriter("src/ex18_02_filewriter/gugudan.txt");
			//cmd 창에서 
			//C:\Users\jhta\git\HTA_Eclipse\Java>cd src/ex18_02_filewriter
			//로 디렉토리 변경하는 것과 같은 원리이다.
			for (int j = 0; j < 10; j++) {
				for (int i = 2; i < 10; i++) {

					if (j == 0) {
						writer.write(String.format("[%d단]\t", i));
					} else {
						writer.write(String.format("%d*%d=%d\t", i, j, i * j));
					}
					
				}
				writer.write("\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
