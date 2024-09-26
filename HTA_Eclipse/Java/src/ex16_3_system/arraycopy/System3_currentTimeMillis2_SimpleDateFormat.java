package ex16_3_system.arraycopy;

import java.text.SimpleDateFormat;

public class System3_currentTimeMillis2_SimpleDateFormat {
	
	public static void main(String[] args) {
		
		long time1 = System.currentTimeMillis();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초 SSS밀리초 E요일");
		System.out.println(sdf1.format(time1));
	}

}
