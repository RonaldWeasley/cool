
public class Fahrerstatistik implements FahrerstatistikInterface {

	private int behindert;
	private int gesund;
	public Fahrerstatistik(int behindert , int gesund) {
		this.behindert=behindert;
		this.gesund=gesund;
	}
	
	@Override
	public String build() {
		return "{\n" + " \"data\": "
				+ "[\n" + " {\n" + 
		" \"values\": [\n" + String.format("%d",behindert)+",\n" + String.format("%d", gesund)+"\n" + " ],\n" + ""
						+ "\"labels\":[\"gebehindert\",\"gesund\"],"+
				" \"type\": \"pie\"\n" + " }\n" + " ]\n" + "}";
	}

	@Override
	public void addFahrer() {
		gesund++;
	}

	@Override
	public void addGehbehindert() {
		behindert++;
	}
}
