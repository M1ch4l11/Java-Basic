public class Fish extends Animal {
    private String hodnota;
    public Fish(String druh,String zvuk, int hmotnost,int vek,String hodnota){
        super(druh, zvuk, hmotnost, vek);
        if(hodnota.equals("freshwater") || hodnota.equals("marine")){
            this.hodnota = hodnota;
        }else this.hodnota = "marine";
    }

    public String toString(){
        return super.toString() + " - " + this.hodnota;
    }
}
