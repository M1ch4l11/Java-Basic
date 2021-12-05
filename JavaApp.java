


import java.util.Scanner;
public class JavaApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] pole = input.nextLine().split(" ");
        if(Character.isDigit(pole[0].charAt(0))){
            int[] poleInt = new int[pole.length];
            for (int i = 0; i < poleInt.length; i++) {
                poleInt[i]=Integer.parseInt(pole[i]);
            }
            for (int i = 0; i < poleInt.length-1; i++) {
                for (int j = 0; j < poleInt.length-1; j++) {
                    if(poleInt[j]>poleInt[j+1]){
                        int pom = poleInt[j];
                        poleInt[j] = poleInt[j+1];
                        poleInt[j+1] = pom;
                    }
                }
            }
            for (int i : poleInt) {
                System.out.print(i + " ");
            }
        }
        else{
            for (int i = 0; i < pole.length-1; i++) {
                for (int j = 0; j < pole.length-1; j++) {
                    if(pole[j].length()>pole[j+1].length()){
                        String pom = pole[j];
                        pole[j] = pole[j+1];
                        pole[j+1] = pom;
                    }
                }
            }
            for (String string : pole) {
                System.out.print(string + " ");
            }
        }
        input.close();
     }
} 
    
        
    

  
