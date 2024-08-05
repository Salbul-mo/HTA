package ex07_00_object;

public class Ex_07_26_error {
	public static void main(String args[]) {
		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };
		int[][] score = { 
							{ 85, 60, 70 }, // 0행("강호동")}
							{ 90, 95, 80 }, // 1행("이승기")
							{ 75, 80, 100 }, // 2행("유재석")
							{ 80, 70, 95 }, // 3행("하하")
							{ 100, 65, 80 } // 4행("이광수")
						};
		


		int[] subject = new int[3]; // 과목총점 저장
		int[] student = new int[5]; // 학생 총점 저장

		// 상단 출력
		System.out.println("============ 학생별 / 과목별 총점 구하기 ============");

		for (int i = 0; i < sub_name.length; i++) {
			if (i == 0) {
				System.out.printf("\t%s\t", sub_name[i]);
			} else {
				System.out.printf("%s\t", sub_name[i]);
			}
		}
		System.out.printf("%s\t%s\n", "총점", "평균");

		// 배열 한번 돌려서 힉생총점 및 과목총점 저장
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < sub_name.length; j++) {
				student[i] += score[i][j];
				subject[j] += score[i][j];
			}
		}
		// 저장된 학생 총점을 기준으로 학생 이름배열, 각 학생 점수배열 , 학생 총점배열 재배치
		sort(name, student, score);
		
		// 재배치된 배열들로 출력 시작
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < sub_name.length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.printf("%d\t%.1f", student[i], ((double) student[i] / sub_name.length));
			System.out.println();
		}
		System.out.println("============================================");
		System.out.printf("%s\t%d\t%d\t%d", "과목총점", subject[0], subject[1], subject[2]);
	}

	// 총점 순으로 int[] student 정렬
	public static int[] sort(int[] arr) {
		// 오름차순
		// max = arr[length -1]
		// 중간 값들
		// min = arr[0]
		// 순차적으로 배열 돌리면서 최소 최대 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	// 총점 순으로 String[] name 정렬
	public static void sort(String[] name, int[] student, int[][] score) {
		// 오름차순
		// min = arr[0]
		// 중간 값들
		// max = arr[length -1]
		// 순차적으로 배열 돌리면서 최소 최대 정렬
		
		for (int i = 0; i < student.length; i++) {
			for (int j = i + 1; j < student.length; j++) {
				if (student[i] > student[j]) { // 최소여야할 총점이 더 크면
					//총점 순서 재배열
					int temp = student[i];
					student[i] = student[j];
					student[j] = temp;
					//이름도 재배열
					String temp_name = name[i]; 
					name[i] = name[j];
					name[j] = temp_name;
					//score 행도 재배열
					for(int sub = 0; sub < score[i].length; sub++) {
						int temp2 = score[i][sub]; 
						score[i][sub] = score[j][sub];
						score[j][sub] = temp2;
					}
					
				}
			}
		}
	
	}
	//static이고 클래스의 필드인 score와 student 라서 메서드에서 한번 바꾸면 반환하지 않아도 필드가 바뀌어버린다.
	//이름 따로 점수 따로 바꾸는 메서드를 각각 만들어 봤자
	//이름에서 총점 순서를 바꾸면서 이름을 재배치하게 만들면 
	//점수 바꾸는 메서드는 이미 바뀐 총점 순서대로 돌아가기 때문에 바뀌지 않는다.
	//그냥 메서드 한방에 다 바꾸자.
	public static void sort_score(int[][] score, int[] student) {
		for (int i = 0; i < student.length; i++) {
			for (int j = i + 1; j < student.length; j++) {
				if (student[i] > student[j]) {
					int temp = student[i];
					student[i] = student[j];
					student[j] = temp;
					for(int sub = 0; sub < score[i].length; sub++) {
						int temp2 = score[i][sub]; 
						score[i][sub] = score[j][sub];
						score[j][sub] = temp2;
					}
					/*int temp0 = score[i][0];
					int temp1 = score[i][1];
					int temp2 = score[i][2];
					score[i][0]=score[j][0];
					score[i][1]=score[j][1];
					score[i][2]=score[j][2];
					score[j][0] = temp0 ;
					score[j][1] = temp1 ;
					score[j][2] = temp2 ;*/
					}
				}
		}
	
	}
}
