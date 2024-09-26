package ex17_04_runnable_interface_anon_util_function;

import java.util.ArrayList;
import java.util.function.Consumer;

//forEach 가 구현되는 방식을 구현한 클래스 예제
public class Box {

	private ArrayList<String> list = new ArrayList<>(); // 필드 ArrayList<String>
	
	public Box() {
		
	}
	
	public void add(String inputData) {
		list.add(inputData); // ArrayList 필드에 문자열 inputData 추가
	}
	
	public void forEach(Consumer<? super String> action) {
		for (String eachData : list) {
			action.accept(eachData);
		}
	}
	
}
