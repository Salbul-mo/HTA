package ex15_7_generic1_3_method_box_1;
//제네릭 메서드는 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메서드이다
//리턴 타입 앞에 <>를 추가하고 타입 파라미터를 기술한다.
public class Util {
	//접근 제어자   정적 여부     <타입 파라미터>    반환타입      메서드 이름     매개 변수
	public       static         <T>          Box<T>      boxing       (T t)  
	{
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}

}
