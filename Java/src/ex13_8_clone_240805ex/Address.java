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
		return this.city == ((Address)obj).city && this.street ==((Address)obj).street;
	}
}
