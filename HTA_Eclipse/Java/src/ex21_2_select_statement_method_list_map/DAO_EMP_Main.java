package ex21_2_select_statement_method_list_map;

import java.util.*;
public class DAO_EMP_Main {

	public static void main(String args[]) {
		DAO_EMP dao = new DAO_EMP();
		List<Map<String,Object>> list = dao.select();
		
		System.out.println("번호\t부서번호\t최고급여\t부서인원수");
		System.out.println("--------------------------------------------");
		int i = 1;
		for(Map<String,Object> h : list) {
			System.out.println(i++ + "\t" + h.get("부서번호")+ "\t" +h.get("최고급여")+"\t"+h.get("부서인원수")+"명");
		}
	}
}

