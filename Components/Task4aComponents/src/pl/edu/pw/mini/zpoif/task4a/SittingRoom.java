package pl.edu.pw.mini.zpoif.task4a;

public class SittingRoom {

	private static final int DEFAULT_WIDTH = 4;
	private static final int DEFAULT_HEIGHT = 2;
	private static final int DEFAULT_LENGTH = 5;

	private int width = 9;
	private int length = 7;
	private int height = 3;

	public static class Table {

		private Float width;
		private Float lenght;
		
		public Table() {
		}
		
		public Table(Float width, Float lenght) {
			this.width = width;
			this.lenght = lenght;
		}

	}

	public static class Cupboard {
		
	}
	
	public SittingRoom() {
		this.width = DEFAULT_WIDTH;
		this.length = DEFAULT_LENGTH;
		this.height = DEFAULT_HEIGHT;
	}

	public SittingRoom(int width, int length, int height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	private int calculateVolume() {
		return height * length * width;
	}

}
