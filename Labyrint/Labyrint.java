import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrint {
    public  final int x;
    public  final int y;
    public String stena;
    String[][] poleZnakov;
    Player hrac;
    BufferedReader read;
    public boolean stav = false;
    public boolean stavWall = false;
    int xH;
    int yH;



    public Labyrint(String nazovSuboru) throws IOException {
        read = new BufferedReader(new FileReader(nazovSuboru));
        stena = "#";
        y = 20;
        x = 20;
        poleZnakov = new String[x][y];
        String pom;
        int poc = 0;
        while (true){
            if ((pom = read.readLine()) == null) break;
                for (int j = 0; j < poleZnakov[0].length; j++) {
                    if(pom.substring(j,j+1).equals("O")){
                        hrac = new Player(poc,j);
                    }
                    poleZnakov[poc][j] = pom.substring(j,j+1);
                }
                poc++;
        }
        yH = hrac.getY();
        xH = hrac.getX();
        showLabyrint();
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        System.out.println(" !!zadaj hodnoty: w - hore, s - dole, d - pravo, a - ľavo!! ");
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        System.out.println("...Zadaj dalsi krok...");
    }

    public void showLabyrint(){
        String out = "";
        for (int i = 0; i < poleZnakov.length; i++) {
            for (int j = 0; j < poleZnakov[0].length; j++) {
                out += poleZnakov[i][j];
            }
            out+="\n";
        }
        System.out.println(out);
    }

    public void refresh(){
        hrac.setPosition(xH,yH);
    }

    public void updateLabyrint(String posun){
        xH = hrac.getX();
        yH = hrac.getY();
        if (posun.equals("w"))xH -=1;
        else if (posun.equals("s"))xH+=1;
        else if (posun.equals("a"))yH-=1;
        else if (posun.equals("d"))yH+=1;
        zmenPoziciu(xH,yH);
    }

    // najdes hraca na aktualnej pozi, vymazes ..nasledne najdes novu poziciu a vlozis hraca "O"
    // ak sa hrac posunie na koniec labyrintu treba zmenit stav na true...
    public void zmenPoziciu(int x,int y) {
        if(volnaPozicia(x,y)){
            vymaz();
            pridaj();
            showLabyrint();
        } else {
            showLabyrint();
            System.out.println(" !! - nieje mozne sa presunut na danu poziciu - !!");
        }
    }

    public void pridaj(){
        for (int i = 0; i < poleZnakov.length; i++) {
            for (int j = 0; j < poleZnakov[0].length; j++) {
                if(hrac.getX()==i && hrac.getY()==j)poleZnakov[i][j] = "O";
                if(hrac.getY()==2 && hrac.getX()==19)stav = true;
            }
        }
    }

    public void vymaz(){
        for (int i = 0; i < poleZnakov.length; i++) {
            for (int j = 0; j < poleZnakov[0].length; j++) {
                if(poleZnakov[i][j].equals("O")){
                    poleZnakov[i][j] = " ";
                }
            }
        }
    }

    // vracia ci je mozne hraca posunut na dalsiu poziciu
    public boolean volnaPozicia(int x,int y) {
        int pomX = x;int pomY = y;
        System.out.println(pomX);
        System.out.println(pomY);
        if(!(pomX<=0 || pomX>=20 || pomY<=0 || pomY>20));
        if(poleZnakov[pomX][pomY].equals(" ")){
            hrac.setPosition(pomX,pomY);
            return true;
        }
        return false;
    }
    public boolean getStav(){
        return stav;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getStena() {
        return stena;
    }

    public void setStena(String stena) {
        this.stena = stena;
    }

    public String[][] getPoleZnakov() {
        return poleZnakov;
    }

    public void setPoleZnakov(String[][] poleZnakov) {
        this.poleZnakov = poleZnakov;
    }

    public Player getHrac() {
        return hrac;
    }

    public void setHrac(Player hrac) {
        this.hrac = hrac;
    }
}
