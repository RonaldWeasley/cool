/**
 * @Author 
 */


public class Nutzererfahrung {
	private int pos;
	private int neg;
	public Nutzererfahrung(int pos , int neg) {
		this.pos=pos;
		this.neg=neg;
	}
	
	public String build() {
		
		return "{\n" + " \"data\": [\n" + " {\n" + 
				" \"x\": [\n" + " \"Likes\",\n" + " \"Dislikes\"\n" +  " ],\n" + 
				" \"y\": [\n" + String.format(" %d,\n",pos) + String.format(" %d\n",neg) + " ],\n" + 
				" \"type\": \"bar\"\n" + " }\n" + " ]\n" + "}";
}

}	
