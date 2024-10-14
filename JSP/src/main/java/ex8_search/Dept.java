package ex8_search;
/*
		자바빈(JavaBean) 은 자바빈 규약에 따라 작성된 자바 클래스이다.
		예를 들어 회원 정보, 게시판 글 등의 정보를 출력할 때 정보를 저장하고 있는 자바빈 객체를 사용하게 된다.
		
		다음은 자바빈 규약이다.
		1. 필드 마다 별도의 get/set 메서드가 존재해야 한다.
		2. get 메서드는 파라미터가 존재하지 않아야 한다.
		3. set 메서드는 반드시 하나 이상의 파라미터가 존재해야 한다.
		4. 빈즈 컴포넌트의 속성은 반드시 읽기 또는 쓰기가 가능해야 한다.
			단, 읽기 전용인 경우 get 또는 is 메서드만 정의할 수 있다.
		5. 생성자는 파라미터가 없는 기본 생성자를 반드시 작성해 주어야 한다.
		6. 필드의 접근 제어자는 private 이고 각 get/set 메서드의 접근 제어자는 public 이어야 하며 
			클래스 접근 제어자는 public 으로 한다.
		
		* 자바빈 클래스는 데이터를 저장하는 필드, 
		  데이터를 읽어올 때 사용되는 메서드 (getter 메서드), 
		  값을 저장할 때 사용되는 메서드(setter 메서드)로 구성된다.
		
		* 메서드 이름을 사용해서 프로퍼티(property)의 이름을 결정하게 된다.
		  예를 들어 프로퍼티의 이름이 name 이고 값의 타입이 int 인 경우 
		  프로퍼티와 관련된 메서드의 이름은 다음과 같이 결정된다.
		  
		  public void setName(int value){};
		  
		  public int getName(){};
		  
		  setName() 과 getName() 를 통해서 관리되는 데이터를 프로퍼티(property)라고 부른다.
		  
		  프로퍼티의 타입이 boolean 인 경우 get 대신 is 를 붙일 수 있다.
		  
		  즉, 프로퍼티의 값을 설정하는 메서드의 경우 프로퍼티의 이름 중 첫 글자를 대문자로 변환한 문자열 앞에 set 을 붙이고
		  프로퍼티의 값을 읽어오는 메서드의 경우 프로퍼티의 이름 중 첫 글자를 대문자로 변환한 문자열 앞에 get 을 붙인다.
		  프로퍼티의 이름과 필드의 이름은 같지 않아도 된다.
		  
		  예) private String _name;
		  
		  	  public String getName() {
		  	  		return _name;
		  	  }
		  	  
		  	  public void setName(String name) {
		  	  		_name = name;
		  	  }
 */
public class Dept {
	private int deptno;
	private String dname;
	private String loc;

	public Dept() {
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
