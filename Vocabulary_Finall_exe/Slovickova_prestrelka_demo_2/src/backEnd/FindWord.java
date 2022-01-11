package backEnd;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class FindWord {
	public BufferedReader readFile;
	// pole v ktorom su ulozene objekty AreaOfLive pripravene na procesovanie
	public ArrayList<AreaOfLive> wordTxt;
	public String[] wordsPole;
	public File file;
	//pomocne premenne
	int countLine;
	String wordCharakterSK = "";
	public FindWord(File file){	
		this.file = file;
		 wordTxt = new ArrayList<AreaOfLive>();
	}
	public void setCreateObject(File[] files){
		String veta = "";
	     try{  
			 int indexIdTxt = 0;
			 for (File file : files) {	 
					 try {
							this.readFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
						} catch (FileNotFoundException e) {
							JOptionPane.showMessageDialog(null, "FileReader nenasiel File");
						}
					 /*
					  * Ukladame jednotlive txt.files do objektov, ktore sa budu spracovavat 
					  */
				     try { 
					 while((veta = readFile.readLine().toString())!=null ) {
					 wordTxt.add(new AreaOfLive(indexIdTxt, veta));
					 indexIdTxt++;
				       }
				     }
				     catch (NullPointerException e) { }
				 readFile.close();
			  }
			} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "I/O Exeption");
		    }
	}
	public void processFilesSk(int indexVyberuFilu,File[] files){
		/*
		 * procesujeme userom vybrany lvl (vybrany subor txt)
		 * ukladame data do pola 
		 */
		int proces = 0;
			// riesenie problemu viacnasobneho opakovania
		      if(proces == 0) {
		    	 for (AreaOfLive i : wordTxt) {
			            if(i.getIndex()==indexVyberuFilu){
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
		         }
		  	    /*
				  *  ziskavame prve slovo vo file ktory vybral user 
				   */
				
				for (AreaOfLive file1 : wordTxt) {
					if(file1.getIndex()==indexVyberuFilu)wordCharakterSK = file1.getFirstWord();
				  }
		        }
		       proces++;
		      }
	public void processFilesAj(File[] files, String firstWordSK){
		/*
		  * procesovanie anj verzie
		   */
		int proces = 0;
		     if (proces == 0) {
	    	 for (AreaOfLive i : wordTxt) {
	    		 /*
	    		  *  from the text of the word
	    		  */
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
	    	    proces++;
		      }
	     }
	public ArrayList<AreaOfLive> getFieldsOfObject(){
		return wordTxt;
	}
	public String getWord(){
		return wordCharakterSK;
	}
}
