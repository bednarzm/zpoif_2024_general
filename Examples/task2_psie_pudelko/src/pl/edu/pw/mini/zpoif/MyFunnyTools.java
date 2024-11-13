package pl.edu.pw.mini.zpoif;

public class MyFunnyTools {

	@FunctionalInterface
	private interface Concatenable{
		public String myConcatenation(String s1, String s2);
	}
	
	public Concatenable myConcatenation(){
		return String::concat;
	}
}
