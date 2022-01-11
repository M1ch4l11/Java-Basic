package backEnd;

import java.nio.charset.StandardCharsets;
/*
 * trieda na kodovanie utf... na utf8
 */
public class KodovanieUtf {
	String[] utf8Field;
	public KodovanieUtf(){

	}
	/*
	 * proces kodovania utf8..
	 */
	public void enKodingUtf(String[] fieldWords){
		utf8Field = new String[fieldWords.length];
		for ( int i = 0 ; i < fieldWords.length;i++){
			String slovakString = fieldWords[i];
			byte[] slovakBytes = slovakString.getBytes();
			utf8Field[i] = new String(slovakBytes, StandardCharsets.UTF_8);
		}
	}
	/*
	 *  getting field of word, what was enkoding utf8...
	 */
	public String[] getUtf8Field() {
		return utf8Field;
	}
}
