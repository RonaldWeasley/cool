
public class Fahrerstatistik {

	private int behindert;
	private int gesund;
	public Fahrerstatistik(int behindert , int gesund) {
		this.behindert=behindert;
		this.gesund=gesund;
	}
	
	public String build() {
		return "{\n" + " \"data\": "
				+ "[\n" + " {\n" + 
		" \"values\": [\n" + String.format("%d",behindert)+",\n" + String.format("%d", gesund)+"\n" + " ],\n" + ""
						+ "\"labels\":[\"gebehindert\",\"gesund\"],"+
				" \"type\": \"pie\"\n" + " }\n" + " ]\n" + "}";
	}
}

