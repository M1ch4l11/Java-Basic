package backEnd;

import java.io.File;
import java.util.ArrayList;

public class MainClass {	
	private ReadFile readFile;
	public File file;
	public File[] poleFilov;
	public String wordCharakterSK = "";
	public String typFolderu = "";
	ArrayList<AreaOfLive> objectySK = new ArrayList<AreaOfLive>();
	public FindWord wordProcess;
	public MainClass(File file) {
		this.file = file;
		readFile = new ReadFile(file);
	    typFolderu = file.getName().substring(4, file.getName().length());
	}
	public void setProcess(){
		// Folder ?
		if(file.isDirectory()==true){
            //txt file in folder ?
			if(readFile.getPritomnostTXT()!=0){
				// ukladame txt file do polaCQ
				// process txt file
				poleFilov = readFile.getFiles();
			    for (File file : poleFilov) {
				wordProcess = new FindWord(file);
			    wordProcess.setCreateObject(poleFilov);
				}			   
		    }
	     }
	}
	public void processFolders(){
		 // procesujeme jednotlive zlozky
		if(typFolderu.equalsIgnoreCase("SVK_ANJ")) {
			wordProcess.processFilesSk(0, poleFilov);      // mozna chyba
			wordCharakterSK = wordProcess.getWord();
		}
		if(typFolderu.equalsIgnoreCase("ANJ"))wordProcess.processFilesAj( poleFilov, wordCharakterSK);
		objectySK.addAll(wordProcess.getFieldsOfObject());
	}
	public void setWord(String slovo){
		wordCharakterSK = slovo;
	}
	public ArrayList<AreaOfLive> getObjectFieldsOfMain(){
		return objectySK;
	}
	public String getWord(){
		return wordCharakterSK;
	}
	public ArrayList<AreaOfLive> geFieldsOfObjects(){
		return wordProcess.getFieldsOfObject();
	}
}
