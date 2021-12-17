import java.io.IOException;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Labyrint app = new Labyrint("scene_01.txt");
        while (true){
            String posun = input.nextLine();
            if( posun.equals("w")
                    || posun.equals("a")
                    || posun.equals("s")
                    || posun.equals("d") )
            {
                app.updateLabyrint(posun);
                System.out.println("...Zadaj dalsi krok...");
                if(app.getStav())break;
                else continue;
            }else {
                System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
                System.out.println(" !!zadaj hodnoty: w - hore, s - dole, d - pravo, a - ľavo!! ");
                System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
                app.refresh();
            }
        }
        System.out.println("...........................");
        System.out.println("....|-This is the End-|....");
        System.out.println("...........................");
        input.close();
    }
}
