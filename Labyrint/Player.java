public class Player {

    public final String znakHrac = "O";
    public int x;
    public int y;

    public Player(int x,int y){
        this.x = x;this.y = y;
    }
    public void setPosition(int x,int y){
        this.x = x;this.y =y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
