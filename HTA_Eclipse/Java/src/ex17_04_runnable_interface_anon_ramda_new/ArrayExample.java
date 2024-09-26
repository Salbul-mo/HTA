package ex17_04_runnable_interface_anon_ramda_new;

@FunctionalInterface // 두 개 이상의 추상 메서드가 선언되면 컴파일 오류를 발생시킨다.
public interface ArrayExample {

	int[] toArray(int size);
	
}
