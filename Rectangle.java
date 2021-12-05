public class Rectangle extends Line {

    public Rectangle(int a, int b, int c, int d) {
        super(a, b, c, d);
        
    }

    public int getSize(){
        int a = zaciatokX - koniecX;
        int b = zaciatokY - koniecY;
        return a*b;
    }
    
}
