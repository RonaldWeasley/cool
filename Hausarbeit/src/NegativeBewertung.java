
public class NegativeBewertung {

	private int negcounter;

	public NegativeBewertung(int negcounter) {
		this.negcounter=negcounter;

	}
	
	public int build() {
		
		return ++this.negcounter;
	}

    public int getCounter() {
		return negcounter;
    }
}
