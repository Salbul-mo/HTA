package ex17_04_runnable_interface_anon_ramda;

@FunctionalInterface // 두 개 이상의 추상 메서드가 선언되면 컴파일 오류를 발생시킨다.
public interface Negative {

	int neg(int x); // public abstract 생략되어 있다.
	//int max(int x, int y);
	//주석 처리 풀어서 메서드가 2개가 되면 오류가 발생한다.
}
