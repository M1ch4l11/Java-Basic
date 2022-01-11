package frontEnd;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import backEnd.AreaOfLive;
import backEnd.KodovanieUtf;
import backEnd.MainClass;
import backEnd.TestMain;

public class AloneMain {

	private JFrame frame;
	String nameOfSection = "";
	JTextArea txtAreaAllScore = new JTextArea(" ");
	JTextField txtArea;
	int finallTime = 0;
	Platno platno;

	// string pre usera
	JLabel lblTxtPrve;
	JLabel lblTxtPrveOdpoved;
	JLabel lblTxtDruhe;
	JLabel lblTxtDruheOdpoved;
	JLabel lblTxtTretie;
	JLabel lblTxtTretieOdpoved;
	JLabel lblTxtStvrte;
	JLabel lblTxtStvrteOdpoved;
	JLabel lblTxtPiate;
	JLabel lblTxtPiateOdpoved;
	JLabel lblTxtSieste;
	JLabel lblTxtSiesteOdpoved;
	JLabel lblTxtSiedme;
	JLabel lblTxtSiedmeOdpoved;
	JLabel lblTxtOsme;
	JLabel lblTxtOsmeOdpoved;
	JLabel lblTxtDeviate;
	JLabel lblTxtDeviateOdpoved;
	JLabel lblTxtDesiate;
	JLabel lblTxtDesiateOdpoved;
	
	int countOfScore = 0;
	public int scoreOfSection;
	
	/**
	 * Create the application.
	 */
	public AloneMain() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		
		// Terc 
		platno = new Platno();
		System.out.println("AloneMain " + scoreOfSection);
		
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Jlabel title ... sluzia na zobrazenie words userovy
		 * - jednotlive komponenty na spracovanie textu, su pridane do lblTabulkaVysled
		 */
		JLabel lblTabulaVysled = new JLabel("");
		lblTabulaVysled.setBounds(800, 10, 795, 330);
		lblTabulaVysled.setBackground(new Color(0, 0, 0, 0));
		frame.getContentPane().add(lblTabulaVysled);
		
		JLabel lblTextTrue = DefaultComponentFactory.getInstance().createTitle("True");
		lblTextTrue.setBounds(63, 5, 116, 34);
		lblTabulaVysled.add(lblTextTrue);
		
	    lblTxtPrve = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtPrve.setBounds(63, 36, 116, 34);
		lblTabulaVysled.add(lblTxtPrve);
		
		JLabel lblUserAnsver = DefaultComponentFactory.getInstance().createTitle(" Your Ansver ");
		lblUserAnsver.setBounds(210, 5, 116, 34);
		lblTabulaVysled.add(lblUserAnsver);
		
		lblTxtPrveOdpoved = DefaultComponentFactory.getInstance().createTitle("");
		lblTxtPrveOdpoved.setBounds(210, 35, 106, 36);
        lblTabulaVysled.add(lblTxtPrveOdpoved);		
		
        lblTxtDruhe = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtDruhe.setBounds(63, 80, 124, 34);
		lblTabulaVysled.add(lblTxtDruhe);
		
		lblTxtDruheOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtDruheOdpoved.setBounds(210, 81, 117, 34);
		lblTabulaVysled.add(lblTxtDruheOdpoved);
		
		lblTxtTretie = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtTretie.setBounds(63, 124, 124, 34);
		lblTabulaVysled.add(lblTxtTretie);
		
		lblTxtTretieOdpoved = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtTretieOdpoved.setBounds(210, 124, 123, 34);
		lblTabulaVysled.add(lblTxtTretieOdpoved);
		
		lblTxtStvrte = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtStvrte.setBounds(63, 168, 106, 34);
		lblTabulaVysled.add(lblTxtStvrte);
		
		lblTxtStvrteOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtStvrteOdpoved.setBounds(210, 167, 106, 36);
		lblTabulaVysled.add(lblTxtStvrteOdpoved);
		
		lblTxtPiate = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtPiate.setBounds(63, 212, 106, 34);
		lblTabulaVysled.add(lblTxtPiate);
		
		lblTxtPiateOdpoved = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtPiateOdpoved.setBounds(210, 211, 106, 36);
		lblTabulaVysled.add(lblTxtPiateOdpoved);

		JLabel lblTextTrue2 = DefaultComponentFactory.getInstance().createTitle("True");
		lblTextTrue2.setBounds(430, 5, 116, 34);
		lblTabulaVysled.add(lblTextTrue2);
				
		lblTxtSieste = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtSieste.setBounds(430, 32, 106, 42);
		lblTabulaVysled.add(lblTxtSieste);

		JLabel lblUserAnsver2 = DefaultComponentFactory.getInstance().createTitle(" Your Ansver ");
		lblUserAnsver2.setBounds(561, 5, 116, 34);
		lblTabulaVysled.add(lblUserAnsver2);
		
		lblTxtSiesteOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtSiesteOdpoved.setBounds(561, 36, 116, 34);
		lblTabulaVysled.add(lblTxtSiesteOdpoved);
		
		lblTxtSiedme = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtSiedme.setBounds(430, 80, 116, 34);
		lblTabulaVysled.add(lblTxtSiedme);
		
		lblTxtSiedmeOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtSiedmeOdpoved.setBounds(561, 80, 116, 34);
		lblTabulaVysled.add(lblTxtSiedmeOdpoved);
		
		lblTxtOsme = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtOsme.setBounds(430, 123, 106, 36);
		lblTabulaVysled.add(lblTxtOsme);
		
		lblTxtOsmeOdpoved = DefaultComponentFactory.getInstance().createTitle(" ");
		lblTxtOsmeOdpoved.setBounds(561, 123, 116, 36);
		lblTabulaVysled.add(lblTxtOsmeOdpoved);
		
		lblTxtDeviate = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtDeviate.setBounds(430, 168, 106, 34);
		lblTabulaVysled.add(lblTxtDeviate);
		
		lblTxtDeviateOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtDeviateOdpoved.setBounds(561, 168, 106, 34);
		lblTabulaVysled.add(lblTxtDeviateOdpoved);
		
		lblTxtDesiate = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtDesiate.setBounds(430, 208, 106, 42);
		lblTabulaVysled.add(lblTxtDesiate);
		
		lblTxtDesiateOdpoved = DefaultComponentFactory.getInstance().createTitle("  ");
		lblTxtDesiateOdpoved.setBounds(561, 212, 116, 34);
		lblTabulaVysled.add(lblTxtDesiateOdpoved);
		
		JButton btnAgain = new JButton("PLAY AGAIN ");
		btnAgain.setBounds(1180, 300, 120, 50);
		btnAgain.setBorder(null);
		btnAgain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAgain)
				{
					// Front -End (objekty)
					UserOptions user = new UserOptions();
					user.setAllFinallScore(txtAreaAllScore.getText() + "\n" + "Score " + countOfScore);
					System.out.println();
					System.out.println("zbehol riadok" + txtAreaAllScore.getText());
					System.out.println();
					/*
					 * procesovanie SK files
					 */
					URL url = AloneMain.class.getResource("/DataSVK_ANJ");
					File folderSK = new File(url.getFile());
					MainClass mainSK = new MainClass(folderSK);
					TestMain mainTest = new TestMain();
				    mainSK.setProcess();
				    
				    // ziskanie objektov utf-8
				    ArrayList<AreaOfLive> objekty = mainTest.getObjectyOdkodovaneUTf(mainSK.geFieldsOfObjects());
				   
				    String nazvyPreUsera = "";
				    int numberGoNext = 4;
				    int pocitanieSlov = 0;
				    for (AreaOfLive areaOfLive : objekty) {
				    	pocitanieSlov++;
				    	if(pocitanieSlov == numberGoNext)
				    	{
					    	nazvyPreUsera += areaOfLive.getFirstWord() + "; " +"\n";
					    	numberGoNext += 4;
					    	continue;
				    	}
				    	nazvyPreUsera += areaOfLive.getFirstWord()  + "; ";
					}
				    user.setTxtArea(nazvyPreUsera);
					frame.dispose();
				}
			}
		});
		btnAgain.setBackground(SystemColor.menu);
		frame.add(btnAgain);
		
		JButton btnAgainSection = new JButton("PLAY AGAIN SAME SECTION");
		btnAgainSection.setBounds(1330, 300, 200, 50);
		btnAgainSection.setBorder(null);
		btnAgainSection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAgainSection)
				{	/*
					 *  Saves data Sk files
					 */
					ArrayList<AreaOfLive> objectySK = new ArrayList<AreaOfLive>();
					ArrayList<String[]> fieldsOfWordSk = new ArrayList<String[]>();
					
					/*
					 * procesovanie SK files
					 */
					KodovanieUtf koduj = new KodovanieUtf();
					URL url = AloneMain.class.getResource("/DataSVK_ANJ");
					File folderSK = new File(url.getFile());
					MainClass mainSK = new MainClass(folderSK);
					TestMain mainTest = new TestMain();
				    mainSK.setProcess();
				    
				    // ziskanie objektov utf-8
				    ArrayList<AreaOfLive> objekty = mainTest.getObjectyOdkodovaneUTf(mainSK.geFieldsOfObjects());
				   
				    objectySK.addAll(mainSK.getObjectFieldsOfMain());
				    
					    for (AreaOfLive j : objekty) {
					    	/*
					    	 * proces kodovania utf8 
					    	 */
					    	if(nameOfSection.equalsIgnoreCase(j.getFirstWord())) {
					    	String[] upravenePole = j.getVeta().split(" ");
							koduj.enKodingUtf(upravenePole);
							
							/*
							 * ukladame data do Arraylistu na dalsie procesovanie
							 */
						    fieldsOfWordSk.add(koduj.getUtf8Field());
					    	
					    	}
						  }
						AloneProcess proces  = new AloneProcess();
						   proces.setVisibleFalse();
						   proces.setNameOfSection(nameOfSection);
						   proces.setFinallScore(txtAreaAllScore.getText() + "\n" + "Score " + countOfScore );
						   System.out.println(" Click play again same section " + txtAreaAllScore.getText());
						   
						String[] poleUpravenychStringov = koduj.getUtf8Field();
						// proces nahodne vybranych cisel
						RandomNumber randomProcess = new RandomNumber(poleUpravenychStringov.length);
						boolean stav = true;
						int numberRandom = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont1(poleUpravenychStringov[numberRandom]);
					    int numberRandom2 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom2 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont2(poleUpravenychStringov[numberRandom2]);
					    int numberRandom3 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom3 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont3(poleUpravenychStringov[numberRandom3]);
					    int numberRandom4 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom4 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont4(poleUpravenychStringov[numberRandom4]);
					    int numberRandom5 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom5 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont5(poleUpravenychStringov[numberRandom5]);
					    int numberRandom6 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom6 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont6(poleUpravenychStringov[numberRandom6]);
					    int numberRandom7 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom7 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont7(poleUpravenychStringov[numberRandom7]);
					    int numberRandom8 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom8 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont8(poleUpravenychStringov[numberRandom8]);
					    int numberRandom9 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom9 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont9(poleUpravenychStringov[numberRandom9]);
					    int numberRandom10 = randomProcess.getRandomNumber();
						// pole nahodne vybranych indexov
						while(stav)
						{
							if(randomProcess.hladajZhodu()) {
								numberRandom10 = randomProcess.getRandomNumber();
								continue;
							}
							else {
								randomProcess.setOneNumber();
								break;
							}
						}
					    proces.setLblWont10(poleUpravenychStringov[numberRandom10]);
					    int[] poleIndexov = randomProcess.getFieldIndex();  /// pole do ktoreho vlozime pole z triedy random a posunieme triede alone process na dalsie procesovanie pre aj wont
					    proces.setFieldsIndex(poleIndexov);
					    proces.setVisibleTrue();
					    proces.clickFirstKomponent();
					    
					
					frame.dispose();
				}
			}
		});
		btnAgainSection.setBackground(SystemColor.menu);
		frame.add(btnAgainSection);

	    txtArea = new JTextField();
		txtArea.setText("  ");
		txtArea.setBounds(850, 300, 300, 50);
		txtArea.setEditable(false);
		frame.add(txtArea);
		
		txtAreaAllScore.setBounds(850, 430, 450, 300);
		txtAreaAllScore.setText(txtAreaAllScore.getText() + "\n" + txtArea.getText());
		txtAreaAllScore.setEditable(false);
		frame.add(txtAreaAllScore);		
		
		// changujeme velkost okna
		FullScreen full = new FullScreen();
		frame.setLocation(0, 0);
		full.nastavObrazovku(frame);
		frame.getContentPane().add(platno);
		ImageIcon icon = new ImageIcon("C:\\Users\\xgelb\\Desktop\\Ikonky na Subory\\ML5.jpg");
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
	}

	

	public void setCountOfScore(int number)
	{
		countOfScore = number;
	}
	
	public void setLblTxtPrve(String lblTxtPrve) {
		this.lblTxtPrve.setText(lblTxtPrve);
	}

	public void setLblTxtPrveOdpoved(String lblTxtPrveOdpoved) {
		this.lblTxtPrveOdpoved.setText(lblTxtPrveOdpoved);
	}

	public void setLblTxtDruhe(String lblTxtDruhe) {
		this.lblTxtDruhe.setText(lblTxtDruhe);
	}

	public void setLblTxtDruheOdpoved(String lblTxtDruheOdpoved) {
		this.lblTxtDruheOdpoved.setText(lblTxtDruheOdpoved);
	}

	public void setLblTxtTretie(String lblTxtTretie) {
		this.lblTxtTretie.setText(lblTxtTretie);
	}

	public void setLblTxtTretieOdpoved(String lblTxtTretieOdpoved) {
		this.lblTxtTretieOdpoved.setText(lblTxtTretieOdpoved);
	}

	public void setLblTxtStvrte(String lblTxtStvrte) {
		this.lblTxtStvrte.setText(lblTxtStvrte);
	}

	public void setLblTxtStvrteOdpoved(String lblTxtStvrteOdpoved) {
		this.lblTxtStvrteOdpoved.setText(lblTxtStvrteOdpoved);
	}

	public void setLblTxtPiate(String lblTxtPiate) {
		this.lblTxtPiate.setText(lblTxtPiate);
	}

	public void setLblTxtPiateOdpoved(String lblTxtPiateOdpoved) {
		this.lblTxtPiateOdpoved.setText(lblTxtPiateOdpoved);
	}

	public void setLblTxtSieste(String lblTxtSieste) {
		this.lblTxtSieste.setText(lblTxtSieste);
	}

	public void setLblTxtSiesteOdpoved(String lblTxtSiesteOdpoved) {
		this.lblTxtSiesteOdpoved.setText(lblTxtSiesteOdpoved);
	}

	public void setLblTxtSiedme(String lblTxtSiedme) {
		this.lblTxtSiedme.setText(lblTxtSiedme);
	}

	public void setLblTxtSiedmeOdpoved(String lblTxtSiedmeOdpoved) {
		this.lblTxtSiedmeOdpoved.setText(lblTxtSiedmeOdpoved);
	}

	public void setLblTxtOsme(String lblTxtOsme) {
		this.lblTxtOsme.setText(lblTxtOsme);
	}

	public void setLblTxtOsmeOdpoved(String lblTxtOsmeOdpoved) {
		this.lblTxtOsmeOdpoved.setText(lblTxtOsmeOdpoved);
	}

	public void setLblTxtDeviate(String lblTxtDeviate) {
		this.lblTxtDeviate.setText(lblTxtDeviate);
	}

	public void setLblTxtDeviateOdpoved(String lblTxtDeviateOdpoved) {
		this.lblTxtDeviateOdpoved.setText(lblTxtDeviateOdpoved);
	}

	public void setLblTxtDesiate(String lblTxtDesiate) {
		this.lblTxtDesiate.setText(lblTxtDesiate);
	}

	public void setLblTxtDesiateOdpoved(String lblTxtDesiateOdpoved) {
		this.lblTxtDesiateOdpoved.setText(lblTxtDesiateOdpoved);
	}
		
	public void setNameOfSection(String nameSection)
	{
		this.nameOfSection = nameSection;
	}
	public void setPLatnoAllScore(int[] scoreAll)
	{
		platno.setAllValueFieldScoreForTarget(scoreAll);
	}
	public String getTxtAreaAllScoreString()
	{
		return txtAreaAllScore.getText();
	}
	
	public void setTxtArea(String text)
	{
		txtArea.setText(text);
	}
	public void setTxtAreaFInallScore(String text)
	{
		txtAreaAllScore.setText(text);
	}
	
	public void setFinallTime(String text)
	{
		finallTime = Integer.parseInt(text);
	}
	
	public void setOff()
	{
		frame.dispose();
	}
	public void setScore(int score)
	{
		this.scoreOfSection = score;
	}
	
	public void setVisibleFalse()
	{
		frame.setVisible(false);
	}
	public void setVisibleTrue()
	{
		frame.setVisible(true);
	}
	public void setPlatnoScore()
	{
		platno.setScore(scoreOfSection);
	}
}
