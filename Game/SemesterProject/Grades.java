package SemesterProject;
import java.util.HashMap;


public class Grades {
	private int math;
	private int history;
	private int science;
	private int english;
	private int wellness;

	public Grades(int mG, int hG, int sG, int eG, int wG){
		math = mG;
		history = hG;
		science = sG;
		english = eG;
		wellness = wG;
	}
	
	public Grades(){
		math = 65;
		history = 80;
		science = 100;
		english = 90;
		wellness = 105;
	}
	
	public int getMath(){
		return math;
	}
	public void setMath(int nM){
		math = nM;
	}

	public int getHistory(){
		return history;
	}
	public void setHistory(int nH){
		history = nH;
	}

	public int getScience(){
		return science;
	}
	public void setScience(int nS){
		science = nS;
	}

	public int getEnglish(){
		return english;
	}
	public void setEnglish(int nE){
		english = nE;
	}

	public int getWellness(){
		return wellness;
	}
	public void setWellness(int nW){
		wellness = nW;
	}
	
	public HashMap<String, Integer> getGrades(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Math", math);
		map.put("History", history);
		map.put("Science", science);
		map.put("English", english);
		map.put("Wellness", wellness);
		return map;
	}
}
