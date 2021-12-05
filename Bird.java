public class Bird extends Animal {
    
    private int rozpatie;

    public Bird(String druh,String zvuk, int hmotnost,int vek,int hodnota){
        super(druh, zvuk, hmotnost, vek);
        if(hodnota<1)this.rozpatie = hodnota;
        else this.rozpatie = hodnota;
    }
    public String toString(){
        return druh + ": " + maxHmotnost + "/" + vek + "/" + rozpatie + " (" + zvuk + ")"; 
    }
}
