
public class Parkhaus {

    static float counter=0;
    static int gehbehindertcounter=0;
    //static int poscounter=0;
    //static int negcounter=0;
    //static int gm;
    //static int gmn;
    static float sum;
    static PositiveBewertung p = new PositiveBewertung(0);
    static NegativeBewertung n = new NegativeBewertung(0);
    public static float getSum(){
        return sum;
    }
    public static float getAvg(){
        if(counter!=0) {
            return sum/counter;
        }else {
            return 0;
        }
    }
    public static Fahrerstatistik getFahrstatistik(){
        return new Fahrerstatistik(gehbehindertcounter,(int)counter-gehbehindertcounter);
    }
    public static PositiveBewertung getPosWert(){
        return p;
    }
    public static NegativeBewertung getNegWert(){
        return n;
    }
    public static Nutzererfahrung getNuErf(){
        return new Nutzererfahrung(p.getCounter(),n.getCounter());
    }
    public static void leave(){
        counter++;
    }
    public static void gb(){
        gehbehindertcounter++;
    }
    public static void zahlung(float in){
        sum+=in;
    }
}
