package SemesterProject;
import java.util.HashMap;


public class Grades {
	private String math;
	private String history;
	private String science;
	private String english;
	private String wellness;

	public Grades(String mG, String hG, String sG, String eG, String wG){
		math = mG;
		history = hG;
		science = sG;
		english = eG;
		wellness = wG;
	}
	
	public Grades(){
		math = "65";
		history = "80";
		science = "100";
		english = "90";
		wellness = "105";
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

	public String getWellness(){
		return wellness;
	}
	public void setWellness(String nW){
		wellness = nW;
	}
	
	public HashMap<String, String> getGrades(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Math", math);
		map.put("History", history);
		map.put("Science", science);
		map.put("English", english);
		map.put("Wellness", wellness);
		return map;
	}
}
