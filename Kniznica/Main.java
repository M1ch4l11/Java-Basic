package Kniznica;

public class Main {
    public static void main(String[] args) throws Exception {

        Autor autorko = new Autor("Greg Steinmetz", "gregusko@gmail.com", "man");
        Kniha app = new Kniha("Najbohatší muž všetkých čias",autorko,19.50);
        System.out.println("Autor: " +app.getAutorMeno() + " \ne-mail: " + app.getAutorEmail() );
        
    }
}
