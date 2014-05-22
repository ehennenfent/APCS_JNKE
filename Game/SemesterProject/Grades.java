package SemesterProject;

import java.util.HashMap;


public class Grades {
	private String math;
	private String history;
	private String science;
	private String english;

	public Grades(String mG, String hG, String sG, String eG){
		math = mG;
		history = hG;
		science = sG;
		english = eG;
	}
	
	public Grades(){
		math = "65";
		history = "80";
		science = "100";
		english = "90";
	}
	
	public String getMath(){
		return math;
	}
	public void setMath(String nM){
		math = nM;
	}

	public String getHistory(){
		return history;
	}
	public void setHistory(String nH){
		history = nH;
	}

	public String getScience(){
		return science;
	}
	public void setScience(String nS){
		science = nS;
	}

	public String getEnglish(){
		return english;
	}
	public void setEnglish(String nE){
		english = nE;
	}
	
	public HashMap<String, String> getGrades(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Math", math);
		map.put("History", history);
		map.put("Science", science);
		map.put("English", english);
		return map;
	}
}
