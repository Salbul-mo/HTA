package ex15_7_generic1_4_wild;

public class GrandParent {

	String name;

	GrandParent() {

	}

	GrandParent(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
