package ex17_04_runnable_interface_anon_util_function;

public class Student {

	private String name;
	private int no;

	public Student() { // 마우스 오른쪽 클릭 resource generate getter setter

	}
	
	public Student(String name, Integer no) {
		this.name = name;
		this.no = no;
	}

	@Override
	public String toString() {
		return "name=" + name + ", no=" + no;
	}
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
