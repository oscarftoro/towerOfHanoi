package domain;
//domain by Ebbe Vang

public class Disc {
	private int size;

	public Disc(int i) {
		// set size to i
		setSize(i);
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(size);
	}
	
}
