public class Animal {
    protected String druh,zvuk;
    protected int maxHmotnost, vek;

    public Animal(String druh,String zvuk,int hmotnost,int vek){
        if(hmotnost<1)this.maxHmotnost = 1;
        else this.maxHmotnost = hmotnost;
        if(vek<1)this.vek = 1;
        else this.vek = vek;
        this.druh = druh;
        this.zvuk = zvuk;
    }

    public String getSound(){return this.zvuk;}
    public int getAge() {return this.vek;};

    public String sing(){
        String pom = "";
        for (int i = 0; i < 3; i++) {
            pom+= zvuk + " ";
        }
        return pom;
    }

    public String toString(){
        return this.druh + ": " + this.maxHmotnost + "/" + this.vek + " (" + zvuk + ")";
    }

}
