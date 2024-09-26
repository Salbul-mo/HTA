package ex10_02.math;


public class PackageExample3 {

	public static void main(String args[]) {
		ex10_02.geometry.polygon_public.Rectangle obj = new ex10_02.geometry.polygon_public.Rectangle(2,3); 
		System.out.println("가로 = " +obj.width);
		System.out.println("높이 = " +obj.height);
		System.out.println("면적 = " +obj.getArea());
		
	}
}
