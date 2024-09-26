package ex07_00_object;

public class Ex {

public Ex() {
	}

public int[] sort(int[] arr) {
	//오름차순
	
	//max = arr[length -1]
	// 중간 값들	
	//min = arr[0]	
	for (int i = 0; i < arr.length ; i++) {	
		for (int j = i + 1 ; j < arr.length-1; j++) {
			if (arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	return arr;
}	



}

