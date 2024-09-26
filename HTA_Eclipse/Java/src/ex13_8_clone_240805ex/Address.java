package ex13_8_clone_240805ex;

public class Address {
	String street;
	String city;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public String toString() {
		return "address=Address{street='" + this.street + ", city='" + this.city + "'}}";
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Address) {// 널체크 및 instanceof 체크
			return this.city.equals(((Address) obj).city) && this.street.equals(((Address) obj).street);
			// String 은 equals() 쓴다.
		} else
			return false;
	}
}
