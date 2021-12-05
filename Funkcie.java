import java.util.Scanner;
public class Funkcie {
    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);
        String[] pole = vstup.nextLine().split(" ");
        int sum = 0,poc= 0;
        String out = "";
        int outI = 0;
        boolean stav = true;
        if(pole.length==1)System.out.println(pole[0]);
        if(Character.isDigit(pole[1].charAt(0))){
            for (int i = 0; i < pole.length; i++) {
                if(pole[i].equals(""))continue;
                int pom = Integer.parseInt(pole[i]);
                sum+=pom;
                poc++;
            }
            sum=sum/poc;
 
            int median = 100;
            for (int i = 0; i < pole.length; i++) {
                int pom2 = Integer.parseInt(pole[i]);
                if(pom2 < median && pom2 >= sum){
                    outI = pom2;
                    median = pom2;
                }
            }
        }else {
            for (int i = 0; i < pole.length; i++) {
                sum+=pole[i].length();
                poc++;
            }
            sum = sum/poc;
            int median2 = 100;
           
            for (int i = 0; i < pole.length; i++) {
                if(pole[i].length() < median2 && pole[i].length()>=sum){
                    out=pole[i];
                    median2 = pole[i].length();
                }
            }
            stav = false;
        }
        if(stav)System.out.println(outI);
        else System.out.println(out);
       vstup.close();
    }   
}
