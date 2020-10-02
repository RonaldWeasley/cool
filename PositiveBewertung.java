
public class PositiveBewertung {

	private int poscounter;

	public PositiveBewertung(int poscounter) {
		this.poscounter=poscounter;

	}
	
	public int build() {
		
		return ++this.poscounter;
	}
}
