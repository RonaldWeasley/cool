
public class Nutzererfahrung {
	private int pos;
	private int neg;
	public Nutzererfahrung(int pos , int neg) {
		this.pos=pos;
		this.neg=neg;
	}
	
	public String build() {
		/*return "{\n" + " \"data\": "
				+ "[\n" + " {\n" + 
		" \"values\": [\n" + String.format("%d",pos)+",\n" + String.format("%d", neg)+"\n" + " ],\n" + ""
						+ "\"labels\":[\"Gefaellt mir\",\"Gefaellt mir nicht\"],"+
				" \"type\": \"bar\"\n" + " }\n" + " ]\n" + "}";
	}*/
	
	return "{\n" + " \"data\": [\n" + " {\n" + 
	" \"x\": [\n" + " \"Likes\",\n" + " \"Dislikes\"\n" +  " ],\n" + 
	" \"y\": [\n" + String.format(" %d,\n",pos) + String.format(" %d\n",neg) + " ],\n" + 
	" \"type\": \"bar\"\n" + " }\n" + " ]\n" + "}";
}

}	
