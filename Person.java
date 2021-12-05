public class Person {
    
    protected String meno;
    protected int rok;
    protected String adresa;

    public Person(String meno,int rok, String adresa){
        if(rok<1900 || rok>2020) this.rok = 2000;
        else this.rok = rok;
        this.meno = meno;
        this.adresa = adresa;

    }
    

    
    public String toString(){
        return meno +  " ("+  rok + ")," + this.adresa;
    }

    

    public static void main(String[] args) {
      
    }

  
    
}
