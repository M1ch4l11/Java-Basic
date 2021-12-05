public class Employee extends Person{
    
    protected int plat;
    protected int deti;

    public Employee(String meno, int rok, int vyska, int hmotnost, int plat, int deti){
        super(meno,rok,vyska,hmotnost);
        if(plat<100)this.plat = 100;
        else if (plat > 10000) this.plat = 10000;
        else this.plat = plat;
        if(deti<0)this.deti = 0;
        else if(deti>15)this.deti = 15;
        else this.deti = deti;
    }

    public String toString(){
        return super.toString() + ", salary: " + plat + ", kids: " + deti;
    }



}
