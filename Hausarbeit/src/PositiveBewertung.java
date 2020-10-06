
public class PositiveBewertung implements BewertungsInterface {

	private int poscounter;

	public PositiveBewertung(int poscounter) {
		this.poscounter=poscounter;

	}
	public int getCounter(){
		return poscounter;
	}
	
	public int build() {
		
		return ++this.poscounter;
	}
}