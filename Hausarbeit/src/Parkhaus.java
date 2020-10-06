
public class Parkhaus implements ParkhausInterface {


    private float sum;
    private int counter;
    private BewertungsInterface p ;
    private BewertungsInterface n ;
    private FahrerstatistikInterface fs;

    public Parkhaus(){
        sum=0;
        p=new PositiveBewertung(0);
        n=new NegativeBewertung(0);
        fs=new Fahrerstatistik(0,0);
    }
    @Override
    public float getSum(){
        return sum/100;
    }
    @Override
    public float getAvg(){
        if(counter!=0) {
            return sum/counter;
        }else {
            return 0;
        }
    }
    @Override
    public FahrerstatistikInterface getFahrstatistik(){
        return fs;
    }
    @Override
    public BewertungsInterface getPosWert(){
        return p;
    }
    @Override
    public BewertungsInterface getNegWert(){
        return n;
    }
    @Override
    public Nutzererfahrung getNuErf(){
        return new Nutzererfahrung(p.getCounter(),n.getCounter());
    }
    @Override
    public void leave(){
        fs.addFahrer();
    }
    @Override
    public void gb(){
        fs.addGehbehindert();
    }
    @Override
    public void zahlung(float in){
        sum+=in;
    }
}

