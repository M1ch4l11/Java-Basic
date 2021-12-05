public class Woman extends Person {
    private String farbaVlasov;
    private int lengthHair;

    public Woman(String meno,int rok, String adresa,String farba,int length){
        super(meno, rok, adresa);
        if(length < 0 || length > 120) this.lengthHair = 120;
        if(farba.equals("black") || farba.equals("blond") || farba.equals("brown") || farba.equals("red"))this.farbaVlasov = farba;
        else this.farbaVlasov = "neutral";
    }

    public String toString(){
        return super.toString() + ",hairs:" + farbaVlasov + "-" + lengthHair;
    }
}
