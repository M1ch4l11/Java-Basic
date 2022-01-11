package backEnd;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
public class ProcessUserSelectedSection {
	int userIndex = 0;
	public void setUserIndex(int index){
		userIndex = index;
	}
	public static void main(String[] args) {	
		/*
		 *  Saves data Sk files
		 */
		ArrayList<AreaOfLive> objectySK = new ArrayList<AreaOfLive>();
		ArrayList<String[]> fieldsOfWordSk = new ArrayList<String[]>();
		/*
		 *  Saves data Aj files
		 */
		ArrayList<AreaOfLive> objectyAj = new ArrayList<AreaOfLive>();
		ArrayList<String[]> fieldsOfWordAj = new ArrayList<String[]>();
		KodovanieUtf koduj = new KodovanieUtf();
		URL url = ProcessUserSelectedSection.class.getResource("/DataSVK_ANJ");
		File folderSK = new File(url.getFile());
		System.out.println(folderSK.toString());
		MainClass mainSK = new MainClass(folderSK);
	    mainSK.setProcess();
	    objectySK.addAll(mainSK.getObjectFieldsOfMain());
	    for (AreaOfLive j : objectySK) {
	    	/*
	    	 * proces kodovania utf8 
	    	 */
	    	String[] upravenePole = j.getVeta().split(" ");
			koduj.enKodingUtf(upravenePole);
			/*
			 * ukladame data do Arraylistu na dalsie procesovanie
			 */
		    fieldsOfWordSk.add(koduj.getUtf8Field());
		  }
	   /*
	    * procesovanie AJ files
	    * ----------------------------------------------------------------------------
		*/
		URL urlANJ = ProcessUserSelectedSection.class.getResource("/DataANJ");
	   File folderAJ = new File(urlANJ.getFile());
       MainClass mainAJ = new MainClass(folderAJ);
       GetFirstWord wordFirst = new  GetFirstWord();
       /*
        * process - first word everywhere
        */
        wordFirst.setWord(mainSK.getWord());
        mainAJ.setWord(wordFirst.getWord());
        mainAJ.setProcess();                               
       /*
        *  vytahujeme objekty
        */
       objectyAj.addAll(mainAJ.getObjectFieldsOfMain());
       /*
        *  kodujeme utf8 !! mozno to bude treba az nakonci procesovania vo front-ende
        */
       for (AreaOfLive objectAj  : objectyAj) {
    	   // potrebuje najst txt file ktory ma rovnake data, ale v inom language
    	   if(objectAj.getFirstWord().equalsIgnoreCase(mainSK.getWord()))
    	    {
    	   String[] pole = objectAj.getVeta().split(" ");
    	   koduj.enKodingUtf(pole);
    	   fieldsOfWordAj.add(koduj.getUtf8Field());
    	    }
	       }
       /*
        *  starting process porovnavania
        *  -----------------------------------------------------------------------
        */
       /*
        * !!! process porovnavania zacina v aj verzii vzdy od indexu 1 !!!!!
        * !!!
        */
       String[] poleANJ = fieldsOfWordAj.get(0);
       for (String[] stringsSk : fieldsOfWordSk) {
    	int countOfScore = 0; 
    	String wordToProces;
		for(int k = 0; k < stringsSk.length;k++){
			System.out.println(stringsSk[k]);
			wordToProces = "nieco";                                // nadstavit hodnoty user zadava slova na test- spravnosti
			if(wordToProces.equalsIgnoreCase(poleANJ[k+1])) {
				countOfScore++;
				continue;
			}
		}
		System.out.println("Pocet bodov: " + countOfScore);
      }
	}
}
