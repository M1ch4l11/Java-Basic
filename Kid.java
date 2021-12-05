public class Kid extends Person{
    private String menoRodic;

    public Kid(String meno,int rok, String adresa,String menoRodica){
        super(meno, rok, adresa);
        this.menoRodic = menoRodica;
    }

    public String toString(){
        return super.toString() + ",parent:" + this.menoRodic;
    }
}
