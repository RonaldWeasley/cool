/**
 * @Author 
 */


public interface ParkhausInterface {
    float getSum();

    float getAvg();

    FahrerstatistikInterface getFahrstatistik();

    BewertungsInterface getPosWert();

    BewertungsInterface getNegWert();

    Nutzererfahrung getNuErf();

    void leave();

    void gb();

    void zahlung(float in);
}
