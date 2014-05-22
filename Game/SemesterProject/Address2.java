package SemesterProject;


public class Address2 {

	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address2(String str, String cty, String stt, String zip){
		street = str;
		city = cty;
		state = stt;
		zipCode = zip;
	}
	
	public Address2(){
		street = "Bicep Court";
		city = "Liftville";
		state = "Tricepistan";
		zipCode = "123469";
	}
	
	public String getStreet(){
		return street;
	}
	public void setStreet(String newStr){
		street = newStr;
	}

	public String getCity(){
		return city;
	}
	public void setCity(String newCty){
		city = newCty;
	}

	public String getState(){
		return state;
	}
	public void setState(String newStt){
		state = newStt;
	}

	public String getZipCode(){
		return zipCode;
	}
	public void setZipCode(String newZip){
		zipCode = newZip;
	}
	
}
