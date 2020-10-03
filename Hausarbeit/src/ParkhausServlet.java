


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ParkhausServlet
 */
@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet {
	static float counter=0;
	static int gehbehindertcounter=0;
	static int poscounter=0;
	static int negcounter=0;
	static int gm;
	static int gmn;
	PositiveBewertung p = new PositiveBewertung(poscounter);
	NegativeBewertung n = new NegativeBewertung(negcounter);
	
	
	private ServletContext getApplication() {
		return getServletConfig().getServletContext();
	}
	private Float getPersistentSum() {
		Float Summe;
		ServletContext application = getApplication();
		Summe = (Float)application.getAttribute("Summe");
		if(Summe == null) Summe = 0.0f;
		return Summe;
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] requestParamString = request .getQueryString().split("=");
		String command = requestParamString[0];
		String param = requestParamString[1];
		
		if("cmd".equals(command)) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			switch(param) {
			case "Summe":
				Float Summe = getPersistentSum();
				out.println(String.format("%.2f",Summe));
				System.out.println("Summe: " + Summe);
				break;
			case "avg":
				if(counter!=0) {
				out.println(getPersistentSum()/counter);
				System.out.println("AVG: " + getPersistentSum()/counter);
				}else {
					out.println(0);
				}
				break;
			/*case "cars":
				StringBuilder carBuilder = new StringBuilder();
				for (CarIF car: cars() ) {
					if(carBuilder.length() > 1) carBuilder.append(",");
					carBuilder.append(car.serialize());
				}
				out.println(carBuilder.toString());
				break;*/
			case "Fahrerstatistik":
				/*JsonObject FahrerRoot = Json.createObjectBuilder()
					.add("data", Json.createArrayBuilder()
							.add(Json.createObjectBuilder()
									.add("values", Car.asCategoryArray(cars()))
									.add("tables", Car.categories())
									.add("types", "pie")
									)
							).build();*/
				/*String a="{\n" + " \"data\": "
						+ "[\n" + " {\n" + 
				" \"values\": [\n" + String.format("%d",gehbehindertcounter)+",\n" + String.format("%d", (int)(counter-gehbehindertcounter))+"\n" + " ],\n" + ""
								+ "\"labels\":[\"gebehindert\",\"gesund\"],"+
						" \"type\": \"pie\"\n" + " }\n" + " ]\n" + "}";*/
				Fahrerstatistik fs=new Fahrerstatistik(gehbehindertcounter,(int)counter-gehbehindertcounter);
					out.println(fs.build());
					System.out.println(fs.build());
				break;
			case "Gefaelltmir":
				gm= p.build();
				out.println(gm);
				System.out.println(gm);
			break;
			case "Gefaelltmirnicht":
				gmn= n.build();
				out.println(gmn);
				System.out.println(gmn);
			break;
			case "Nutzererfahrung":
				Nutzererfahrung ne=new Nutzererfahrung(gm,gmn);
					out.println(ne.build());
					System.out.println(ne.build());
			}
		} else {
			System.out.println("Invalid Command: " + request.getQueryString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = getBody(request);
		System.out.println(body);
		String[] params = body.split(",");
		String event = params[0];
		if("leave".equals(event)) {
			Float Summe = getPersistentSum();
			String priceString = params[4];
			counter++;
			if("gehbehindert".equals(params[8])) {
				gehbehindertcounter++;		
				}
			
			if(!"_".equals(priceString)) {
				float price = Float.parseFloat(priceString);
				Summe = (price/100) + Summe;
				getApplication().setAttribute("Summe", Summe);
				
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(Summe + "€");
			if("Behinderbutton".equals(event)) {
				float price = Float.parseFloat(priceString);
				price = price * 0.5f;
				getApplication().setAttribute("Behindertenbutton", price);
				out.println(price);
			}
		}
		
		
	}
	private static String getBody(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try {
			InputStream inputStream = request.getInputStream();
			if(inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return stringBuilder.toString();
	}
}
