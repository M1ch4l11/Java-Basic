public class Line {
    protected int zaciatokX,zaciatokY,koniecX,koniecY;

    public Line(int a,int b,int c, int d){
        if(a==b && a==c && a==d){
            this.zaciatokX = 0; this.zaciatokY = 0;
            this.koniecX = 10; this.koniecY = 10;
        }
        else {
            this.zaciatokX = a; this.zaciatokY = b;
            this.koniecX = c; this.koniecY = d;
        }
    }

    public double getSize(){
        int a = zaciatokX - koniecY;
        int b = zaciatokY - koniecY;
        return (double) ((a*a)+(b*b));
    }

    public String toString(){
        return "[" + zaciatokX + "," + zaciatoktY + "] - [" + koniecX + "," + koniecY + "]";
    }
}
