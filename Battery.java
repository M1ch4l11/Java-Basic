import java.util.Arrays;

public class Battery {

    private int cena,minuty,serioveCislo;
    public static int serioveCisloS = 100;
    private static int defaultMinuty = 500;


    public Battery(int cena){
        if(cena < 10 ) this.cena = 10;
        else if(cena > 1000) this.cena = 1000;
        else this.cena = cena;
        serioveCisloS++;
        serioveCislo = serioveCisloS;
        minuty = defaultMinuty;
    }

    public void changeLife(int hodnota){
        if(hodnota < 200) defaultMinuty = 200;
        if(hodnota > 10000) defaultMinuty = 10000;
    }

    public void hangePrice(int hodnota){
        if(hodnota < 0){
            int a = hodnota * (-1);
            cena = cena - a;
        }
        if(hodnota > 0) cena += hodnota;
        if(cena < 10)cena = 10;
        if(cena > 500)cena = 500;
    }
    public String toString(){
        return serioveCislo + " (price: "+cena+"), battery life: "  + minuty;
    }
    public static void main(String[] args) {
        Battery app = new Battery(-5);
        System.out.println(app.toString());
    }
}
