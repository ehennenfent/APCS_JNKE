
public class Address {

	private String street;
	private String city;
	private String state;
	private int zipCode;
	
	public Address(String str, String cty, String stt, int zip){
		street = str;
		city = cty;
		state = stt;
		zipCode = zip;
	}
	
	public Address(){
		street = "Bicep Court";
		city = "Liftville";
		state = "Tricepistan";
		zipCode = 123469;
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

	public int getZipCode(){
		return zipCode;
	}
	public void setZipCode(int newZip){
		zipCode = newZip;
	}
	
}
