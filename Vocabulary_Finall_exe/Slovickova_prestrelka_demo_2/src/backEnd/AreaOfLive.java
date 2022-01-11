package backEnd;

/*
 * 
 * Uklada data z txt filov, t.j word for next processing
 */
public class AreaOfLive {
	public int index;
	public String veta;
	public String[] poleWords;
	public AreaOfLive(int indexFilu,String vetaNaSpracovanie) {
		this.index = indexFilu;
		this.veta = vetaNaSpracovanie;
	}
	public int getIndex() {
		return index;
	}
	public String getVeta() {
		return veta;
	}
	public void setFields(){
		this.poleWords = veta.split(" ");
	}
	public String getFirstWord() {
		return poleWords[0];
	}
	public void setFieldOfWord(String[] pole){
		this.poleWords = pole;
	}
}
