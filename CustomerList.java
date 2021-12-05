public class CustomerList {
    protected Person[] zoznam;
    private int pocFullListOfZoznam;
    public CustomerList(){
        this.zoznam = new Person[20];
        this.pocFullListOfZoznam = 0;
    }

    public void addMan(String meno,int rok, String adresa, int vyskaPlatu){
        zoznam[pocFullListOfZoznam] = new Man(meno,rok,adresa,vyskaPlatu);
        pocFullListOfZoznam++;
    }
    public void addWoman(String meno,int rok, String adresa,String farba,int length){
        zoznam[pocFullListOfZoznam] = new Woman( meno,rok, adresa,farba, length);
        pocFullListOfZoznam++;
    }
    public void addKid(String meno,int rok, String adresa,String menoRodica){
        zoznam[pocFullListOfZoznam] = new Kid(meno,rok,  adresa,menoRodica);
        pocFullListOfZoznam++;
    }

    public String getList(){
        String out = "";
        for (Person person : zoznam) {
            if(person!=null){
                out+= person.toString() + "/n";
            }
        }
        return out;
    }
}
