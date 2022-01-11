package backEnd;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import frontEnd.UserOptions;

public class TestMain {

	
	public static void main(String[] args) {
		// Front -End (objekty)
		UserOptions user = new UserOptions();
		/*
		 * procesovanie SK files
		 */
		URL url = TestMain.class.getResource("/DataSVK_ANJ");
		File folderSK = new File(url.getFile());
		MainClass mainSK = new MainClass(folderSK);
		TestMain mainTest = new TestMain();
	    mainSK.setProcess();
	    // ziskanie objektov utf-8
	    ArrayList<AreaOfLive> objekty = mainTest.getObjectyOdkodovaneUTf(mainSK.geFieldsOfObjects());
	    String nazvyPreUsera = "";
	    int indexFile = 0;
	    for (AreaOfLive o : objekty){
	    	nazvyPreUsera += o.getFirstWord() + "=" + indexFile + " \n";
	    	indexFile++;
	    }
	    user.setTxtArea(nazvyPreUsera);
	}
	/*
	 *  metoda nam sprocesuje sk - folder, vytiahne prve slova z filov...
	 */
	public ArrayList<AreaOfLive> getObjectyOdkodovaneUTf(ArrayList<AreaOfLive> objects){
		ArrayList<AreaOfLive> poleOdkodovanychFilov = objects;
		String[] wordsPole;
		for (AreaOfLive i : poleOdkodovanychFilov) {
	             wordsPole = i.getVeta().split(" ");
	             String[] utf8Field = new String[wordsPole.length];
	             for(int j = 0; j < wordsPole.length;j++){
		                 /*
		                  *  process kodovanie utf... na utf 8 !! nadstavit pracu s datami !!
		                  */
		                   String slovakString = wordsPole[j];
		                   byte[] slovakBytes = slovakString.getBytes();
		                   utf8Field[j] = new String(slovakBytes, StandardCharsets.UTF_8);					   
	                }
	                 /*
                      *  to the object, whot user selected, we'll put fieldsOfWord,
	                  *  ready to procesing next step
	                  */
	                     i.setFieldOfWord(utf8Field);
        }
		return poleOdkodovanychFilov;
	}
}
