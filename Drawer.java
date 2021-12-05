public class Drawer {


    void square(boolean stav,String vnutri,int hodnota){
        String pom = "";
        if(stav){
            for (int i = 0; i < hodnota; i++) {
                pom+=vnutri;
            }
            for (int i = 0; i < hodnota; i++) {
                System.out.println(pom);
            }
        }else {
            for (int i = 0; i < hodnota; i++) {
                    pom+=vnutri;        
                }
                System.err.println(pom);
                String pomS2 = "";
            for (int i = 0; i < hodnota; i++) {
               if(i==0)pomS2=vnutri;
               else if (i==hodnota-1)pomS2+=vnutri;
               else {
                   pomS2+=" ";
               }
            }
            for (int i = 1; i < hodnota-1; i++) {
                System.out.println(pomS2);
            }
            System.out.println(pom);
        }
    }
    

    public void diagonal(boolean stav, int hodnota) {
        String pom = "";
        if(stav){
            for (int i = 1; i <= hodnota; i++) {
                for (int j = 1; j <= i; j++) {
                    pom += " ";
                }
                System.out.println(pom.substring(0,pom.length()-1) + "x");
                pom = ""; 
            }
        } else {
            String[][] pole = new String[hodnota][hodnota];
            for (int i = 0; i < pole.length; i++) {
                for (int j = 0; j < pole[i].length; j++) {
                    pole[i][j] = "x";
                }
            }
            for (int i = 0; i < pole.length; i++) {
                for (int j = 0; j < pole[i].length; j++) {
                    if(i==j)pole[i][j]=" ";
                }
            }
            for (int i = 0; i < pole.length; i++) {
                for (int j = 0; j < pole[i].length; j++) {
                    System.out.print(pole[i][j]);
                }
                System.out.println();
            }
        }
           
    }
    
    public void rectangle(boolean stav, int hodnota, int hodnota2) {
        
        if(stav){
        for (int i = 0; i < hodnota; i++) {
            for (int j = 0; j < hodnota2; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
        }
        
    }
    
    public void triangle(boolean stav, int hodnota) {
        if(stav){
            int value = hodnota;
        int index = 1;
       String valueString = "";
       boolean stav2 = true;
       int indexpole = 0;
       String[] pole = new String[hodnota];
         while(stav2){
         //medzeri
        for (int i = 0; i < (value - index); i++) {
          valueString+= "x";
        }
        valueString+="x";
        pole[indexpole]=valueString;
        indexpole++;
        valueString="";
        if(index==value)stav2=false;
        index++;
      }
      for (int i = 0; i < pole.length; i++) {
        if(i==0){
            String pomS = "";
            for (int j = 0; j < pole.length; j++) {
                pomS+="x";
            }
            System.out.println(pomS);
        }
        else {
          System.out.println(pole[i]);
        }
    }
}
      else if (!stav){
        
          
        int value = hodnota;
        int index = 1;
       String valueString = "";
       boolean stav2 = true;
       int indexpole = 0;
       String[] pole = new String[hodnota];
         while(stav2){
         //medzeri
        for (int i = 0; i < (value - index); i++) {
          valueString+= " ";
        }
        valueString+="x";
        pole[indexpole]=valueString;
        indexpole++;
        valueString="";
        if(index==value)stav2=false;
        index++;
      }

      for (int i = 0; i < pole.length; i++) {
          if(i==0){
              String pomS = "";
              for (int j = 0; j < pole.length; j++) {
                  pomS+="x";
              }
              System.out.println(pomS);
          }
          else {
            System.out.println("x"+pole[i].substring(1,pole[i].length()));
          }
      }
      }

      
    }
      
      
    

}
    
    
    

    
  
