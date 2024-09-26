package ex21_2_select_statement_method_list_map;

import java.util.*;

public class DAO_JOIN_Main {
	
	public static void main(String args[]) {
	
		DAO_JOIN dao = new DAO_JOIN();
		List<Map<String,Object>> list = dao.select();
		
		int num = 1;
		System.out.println("번호\t부서이름\t\t사원이름\t부서번호\t급여");
		System.out.println("------------------------------------------------------");
		
		for(Map<String,Object> h : list) {
			System.out.println(num++ +"\t"+ h.get("부서이름") +"\t" +h.get("사원이름") + "\t" + h.get("부서번호") + "\t" + h.get("급여"));
		}
	}

}
