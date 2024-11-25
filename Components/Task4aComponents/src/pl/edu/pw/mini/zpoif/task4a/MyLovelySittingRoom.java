package pl.edu.pw.mini.zpoif.task4a;

public class MyLovelySittingRoom extends SittingRoom {
	
	public static final String ROOM_LABEL = "It`s my lovely room!";
	public static final int PEOPLE_LIVING = 3;
	private int pepoleLiving = PEOPLE_LIVING;
	
	private Table myLovelyTable;
	
	private static class Mirror {
		
	}
	
	public MyLovelySittingRoom() {
		super(5, 5, 3);
	}

	public MyLovelySittingRoom(int width, int length, int height) {
		super(width, length, height);
	}
	
	public void doSomething() {
		
	}
	
	public void doSomethingElse(String arg1, String arg2) {
		
	}
	
	public void greet(String greeting) {
		System.out.println(" My greeting is: " + greeting);
	}
	
}
