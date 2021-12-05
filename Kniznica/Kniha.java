package Kniznica;

public class Kniha{
    private String nazov;
    private double cena;
    private int pocetKusov;
    public Autor autor;


    public Kniha(String nazov,Autor autor,double cena,int pocetKusov) throws Exception{
      
        if(cena<=0) throw new Exception("!!Zadaj spravnu cenu!!");
        else this.cena = cena;
        if(pocetKusov<=0) throw new Exception("!!Zadaj správny počet!!");
        else this.pocetKusov = pocetKusov;
        this.autor = autor;
    }

    public Kniha(String nazov,Autor autor,double cena) throws Exception{
        if(cena<=0) throw new Exception("!!Zadaj spravnu cenu!!");
        else this.cena = cena;
        this.autor = autor;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return this.cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPocetKusov() {
        return this.pocetKusov;
    }

    public void setPocetKusov(int pocetKusov) {
        this.pocetKusov = pocetKusov;
    }
    public Autor getAutor() {
        return this.autor;
    }
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    
    
    public String toString() {    
        return autor.toString();
   }
    // bonus
    public String getAutorMeno(){
        return this.autor.getMeno();
    }
    public String getAutorEmail(){
        return this.autor.getEmail();
    }
    public String getAutorPohlavie(){
        return this.autor.getPohlavie();
    }
}
