package BodTrojuholnik;

public class Bod {

    private int x,y;

    public Bod(int x,int y){
        if(x<0)this.x = 0;
        else this.x = x;
        if(y<0)this.y = 0;
        else this.y = y;
    }

    public Bod(){
        this.x = 0;
        this.y = 0;
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x,int y){
        if(x<0)this.x = 0;
        else this.x = x;
        if(y<0)this.y = 0;
        else this.y = y;
    }

    public String toString(){
        return "(" + this.x + "," + ")";
    }

    public double vzdialenost(int x,int y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double vzdialenost(Bod bod){
        return Math.sqrt(Math.pow(this.x - bod.getX(), 2) + Math.pow(this.y - bod.getY(), 2));
    }
    
}