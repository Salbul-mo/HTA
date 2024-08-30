package ex17_21_stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exam4 {

	public static void main(String args[]) {
		/*
		 * 문제 복사가 제대로 안되어서 일단 예상해보고 제출하겠습니다.... 
		 * 
		 * [CLERK, SALESMAN, MANAGER, ANALYST, PRESIDENT] 
		 * [ANALYST, CLERK, MANAGER, PRESIDENT, SALESMAN] 
		 * 5
		 * 
		 * 이렇게만 복사가 되어있었네요...
		 */
		Emp[] emp = new Emp[] {
								new Emp("SMITH","CLERK"),  	 new Emp("ALLEN","SALESMAN"),
								new Emp("WARD","SALESMAN"),	 new Emp("JONES","MANAGER"),  
								new Emp("MARTIN","SALESMAN"),new Emp("BLAKE","MANAGER"),  
								new Emp("CLARK","MANAGER"),  new Emp("SCOTT","ANALYST"),
								new Emp("KING","PRESIDENT"), new Emp("TURNER","SALESMAN"),
								new Emp("ADAMS","CLERK"),    new Emp("JAMES","CLERK"),
								new Emp("FORD","ANALYST"),   new Emp("MILLER","CLERK")};
		
		Stream<Emp> stream = Stream.of(emp);
		List<String> list = stream.map(Emp::getJob).distinct().collect(Collectors.toList());
		System.out.println(list);
		
		
		list = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list.size());
		
	}	
}

class Emp {

	private String name;
	private String job;

	Emp(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
