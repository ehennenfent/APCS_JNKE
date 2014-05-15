
public class Student {

	private Grades grades;
	private Address address;
	private String firstName;
	private String lastName;
	public Student(String fn, String ln, Grades g, Address a){
		firstName = fn;
		lastName = ln;
		grades = g;
		address = a;
	}
	
	public Student(){
		firstName = "Nicole";
		lastName = "Aldridge";
		grades = new Grades();
		address = new Address();
	}
	
	public String getName(){
		return firstName + " " + lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String nFN){
		firstName = nFN;
	}

	public String getLastName(){
		return lastName;
	}
	public void setLastName(String nLN){
		lastName = nLN;
	}

	
	public Grades getGrades(){
		return grades;
	}
	public void setGrades(Grades nG){
		grades = nG;
	}
	
	public Address getAddress(){
		return address;
	}
	public void setAddress(Address nA){
		address = nA;
	}
}
