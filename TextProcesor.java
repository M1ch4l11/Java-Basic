
public class TextProcesor {
  int poc = 0;
    
    void getLenght(String hodnota){
      System.out.println("Reťazec \""+ hodnota + "\" " + "má " + hodnota.length() + " znakov");
      poc++;
    }

    void getDigits(String hodnota){
      String pom = "";
      for (int i = 0; i < hodnota.length(); i++) {
        if(hodnota.charAt(i) <= '9' && hodnota.charAt(i) >= '0'){
          pom+=Character.toString(hodnota.charAt(i));
        }
      }
      System.out.println(pom);
      poc++;
    }
    void getDigitCount(String hodnota){
      int pom = 0;
      for (int i = 0; i < hodnota.length(); i++) {
        if(hodnota.charAt(i) <= '9' && hodnota.charAt(i) >= '0'){
          pom++;
        }
      }
      System.out.println(pom);
      poc++;
    }

    void getSumDigits(String hodnota){
      int pom = 0;
      for (int i = 0; i < hodnota.length(); i++) {
        if(hodnota.charAt(i) <= '9' && hodnota.charAt(i) >= '0'){
          pom+= Integer.parseInt(Character.toString(hodnota.charAt(i)));
        }
      }
      System.out.println(pom);
      poc++;
    }

    void getNumbers(String hodnota){
      String pom = "";
      boolean stav = false;
      for (int j = 0; j < hodnota.length(); j++) {
        int pomI = j;
        while(Character.isDigit(hodnota.charAt(pomI))){
          pom+=Character.toString(hodnota.charAt(pomI));
          if((pomI+1) < (hodnota.length()-1)){
            pomI++;
            continue;
          }
          
          if((pomI+1) == (hodnota.length()-1)){
            pom+=Character.toString(hodnota.charAt(pomI+1));
            pomI++;
            stav = true;
            break;
          }
        }
        if(pomI > 0&& Character.isDigit(hodnota.charAt(pomI-1)) )pom+=",";
        j=pomI;
        if(stav)break;
      }
      System.out.println(pom.substring(0,pom.length()-1));
      poc++;
    }
    void getOperationCount(){
      System.out.println(poc);
    }

    


  }