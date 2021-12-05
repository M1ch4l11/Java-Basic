package BodTrojuholnik;

public class Trojuholnik {
    private Bod v1,v2,v3;

    public Trojuholnik(int x1,int y1,int x2,int y2,int x3,int y3){
        this.v1 = new Bod(x1,y1);
        this.v2 = new Bod(x2,y2);
        this.v3 = new Bod(x3,y3);
    }

    public Trojuholnik(Bod bod1,Bod bod2,Bod bod3){
        this.v1 = bod1;this.v2 = bod2;this.v3 = bod3;
    }

    public String toString(){
        return "Trojuholnik: " + v1.toString() + "," + v2.toString() + "," + v3.toString();
    }

    public double obvod(){
        return v1.vzdialenost(v2) + v2.vzdialenost(v3) + v3.vzdialenost(v1);
    }

    public String typ(){
        if(v1.vzdialenost(v2)==v2.vzdialenost(v3) && v2.vzdialenost(v3) == v1.vzdialenost(v3)) return "rovnostranny";
        else if(v1.vzdialenost(v2)==v2.vzdialenost(v3) || v2.vzdialenost(v3) == v1.vzdialenost(v3)) return "rovnoramenny";
        return "vseobecny";
    }
}
