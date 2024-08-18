package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.chrono.ThaiBuddhistDate;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ThaiBuddhistDate date = ThaiBuddhistDate.of(Integer.valueOf(br.readLine()), 1, 1);
		LocalDate ac = LocalDate.from(date);
		System.out.println(ac.getYear());
	}
}
