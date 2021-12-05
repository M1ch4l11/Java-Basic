public class Man extends Person {
    private int vyskaPlatu;

    public Man(String meno,int rok, String adresa, int vyskaPlatu){
        super(meno, rok, adresa);
        if(vyskaPlatu < 100 || vyskaPlatu > 10000)this.vyskaPlatu = 0;
        else this.vyskaPlatu = vyskaPlatu;
    }

    public String toString(){
        return super.toString() + ":" + vyskaPlatu + "EUR";
    }




}
