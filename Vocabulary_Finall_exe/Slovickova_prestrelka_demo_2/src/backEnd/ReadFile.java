package backEnd;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
public class ReadFile {
	private File file;
	public File[] txtSubory;
	public ReadFile(File file){
		this.file = file;
		this.txtSubory = new File[this.file.list().length];
	}
	public int getPritomnostTXT(){
		int stav = 0;
		int indexPola = 0;
		// kod zistuje pritomnost primitivneho .txt suboru
		for(File file : this.file.listFiles()) {
				String nameFile = file.getName();
				int indexBodky = 0;
				String[] pismena = new String[nameFile.length()];
				for (int i = 0; i < nameFile.length();i++){
					char pomocnaP = nameFile.charAt(i);
					pismena[i] = String.valueOf(pomocnaP);
					if(pismena[i].equalsIgnoreCase("."))indexBodky = i;
				}
				String typSuboru = nameFile.substring(indexBodky, nameFile.length());
				if(typSuboru.equalsIgnoreCase(".txt")){
					   txtSubory[indexPola] = file;
					   indexPola++;
					  stav++;
					}
		}
				return stav;
	}
	public File[] getFiles(){
		return this.txtSubory;
	}
	public void citajSubor() {
		// kod zistuje pritomnost primitivneho .txt suboru
		String nameFile = file.getName();
		int indexBodky = 0;
		String[] pismena = new String[nameFile.length()];
		for (int i = 0; i < nameFile.length();i++){
			char pomocnaP = nameFile.charAt(i);
			pismena[i] = String.valueOf(pomocnaP);
			if(pismena[i].equalsIgnoreCase("."))indexBodky = i;
		}
		String typSuboru = nameFile.substring(indexBodky, nameFile.length());
		// proces pokracuje v behu programu, ak je subor .txt
		if(typSuboru.equalsIgnoreCase(".txt")){
			try {
			BufferedReader citajSubor = new BufferedReader(new FileReader(this.file));
			String dataSuboru = "";
			while((dataSuboru = citajSubor.readLine().toString())!=null){
				System.out.println(dataSuboru);
			}
			citajSubor.close();
			}
			catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Vsetko prebehlo uspesne\n Prajem pekny den");
			}
			catch (FileNotFoundException ex){
				JOptionPane.showMessageDialog(null, "Nastala chyba pri Hladani suboru");
			}
			catch (IOException ex){
				JOptionPane.showMessageDialog(null, "Nastala Chyba\n vstup,vystup");
			}
		}
	}
}
