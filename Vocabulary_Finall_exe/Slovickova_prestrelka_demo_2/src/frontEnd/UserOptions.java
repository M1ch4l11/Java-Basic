package frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import backEnd.AreaOfLive;
import backEnd.KodovanieUtf;
import backEnd.MainClass;
import backEnd.TestMain;

/*
 *  trieda ktora zodpoveda za funkcionality vyber - posli (sekciu)
 */
public class UserOptions extends JFrame implements KeyListener{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField areaGetText;
	Dimension dimension;
	 JLabel txtLabel;
	 JTextArea area;
	 String nameOfSection;
	 String allFinallScore;		
	 AloneProcess proces;
	JLabel backgroundImage;
	/*
	 * vytvaranie Frame okna....
	 */
	 public UserOptions()  {
		 dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		 setSize(365, 350);
		 setLayout(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setType(Type.POPUP);
		 ImageIcon image = new ImageIcon(UserOptions.class.getResource("/image/ML5.jpg"));
		 setIconImage(image.getImage());		 
		 setUndecorated(true);
		 int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		 int y = (int) (((dimension.getHeight() - getHeight()) / 2) - 50 );
		 setLocation(x, y);
		 textUserovy();
		 setButton();
		 getContentPane().setBackground(SystemColor.BLACK);
		 setBackgroundImage();
		 setVisible(true);
	}

	public void setBackgroundImage()
	{
		backgroundImage = new JLabel("\r\n");
		backgroundImage.setSize(400, 350);
		backgroundImage.setBackground(Color.BLUE);
		backgroundImage.setIcon(new ImageIcon(UserOptions.class.getResource("/image/unnamed.jpg")));
		getContentPane().add(backgroundImage);  
	}

	 
	 /*
	  * metoda vytvara textove polia
	  *  
	  */
	 public void textUserovy()
	 {
		  KodovanieUtf koduj = new KodovanieUtf();
		  String title = "Here you write to full of name the section ";
		  String[] fieldsKoduj = title.split(" ");
		  koduj.enKodingUtf(fieldsKoduj);
		  String[] titleEnK = koduj.getUtf8Field();
		 String finallStringForUser = ""; 
		  for (int i = 0; i < titleEnK.length; i++) {
			  finallStringForUser += " "  + titleEnK[i];
		  }

		 txtLabel = new JLabel();
		 txtLabel.setText(finallStringForUser);
		 txtLabel.setLocation(20, 120);
		 txtLabel.setForeground(Color.WHITE);
		 txtLabel.setSize (340 , 125);
		 txtLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 21));
		 		 
		 area = new JTextArea();
		 area.setSize(250, 125);
		 area.setLocation(55, 25);
		 area.setBackground(SystemColor.menu);
		 area.setEditable(false);
		 
		 areaGetText = new JTextField();
		 areaGetText.setSize(250, 25);
		 areaGetText.setLocation(55, 200);
		 areaGetText.addKeyListener(this);
		 
		 add(txtLabel);
		 add(area);
		 add(areaGetText);
	 }
	 public void setButton()
	 {
		 JButton button = new JButton("PLAY");
		 button.setSize(140, 40);
		 button.setBorder(null);
		 button.setBackground(SystemColor.CYAN);
		 button.setForeground(Color.black);
		 button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==button)
				{
					try {
					   setVisible(false);
//				       sectionTesting = Integer.parseInt(areaGetText.getText());
					   String nameOfSection = areaGetText.getText();
						/*
						 *  Saves data Sk files
						 */
						ArrayList<AreaOfLive> objectySK = new ArrayList<AreaOfLive>();
						ArrayList<String[]> fieldsOfWordSk = new ArrayList<String[]>();
						


						/*
						 * procesovanie SK files
						 */
						KodovanieUtf koduj = new KodovanieUtf();
						URL url = UserOptions.class.getResource("/DataSVK_ANJ");
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
						    
						    proces = new AloneProcess();
							proces.setVisibleFalse();
							proces.setNameOfSection(nameOfSection);
							proces.setFinallScore(allFinallScore);
							   
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
						    dispose();     
					}catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(null, "You didnt put any information");
						setVisible(true);
						dispose();
						proces.setOff();

						UserOptions user = new UserOptions();
												
						/*
						 * procesovanie SK files
						 */
						URL url = UserOptions.class.getResource("/DataSVK_ANJ");
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
					    	nazvyPreUsera += areaOfLive.getFirstWord() + "; ";
						}
					    user.setTxtArea(nazvyPreUsera);
					}
				}
			}	
		});
		 button.setLocation(110, 255);
		 add(button);	 
	 }
	 
	 public void setTxtArea(String textPreUzivatela)
	 {
		 area.setText(textPreUzivatela);
	 }
	 
	 public String getTxtArea()
	 {
		 return area.getText();
	 }
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}

	int sectionTesting = 0;
	
	@Override
	public void keyPressed(KeyEvent e) {
		try{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
		   setVisible(false);
	    //    sectionTesting = Integer.parseInt(areaGetText.getText());
		   String nameOfSection = areaGetText.getText();
			/*
			 *  Saves data Sk files
			 */
			ArrayList<AreaOfLive> objectySK = new ArrayList<AreaOfLive>();
			ArrayList<String[]> fieldsOfWordSk = new ArrayList<String[]>();
			
			/*
			 * procesovanie SK files
			 */
			KodovanieUtf koduj = new KodovanieUtf();
			URL url = UserOptions.class.getResource("/DataSVK_ANJ");
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
			    
			      proces = new AloneProcess();
				  proces.setVisibleFalse();
				  proces.setNameOfSection(nameOfSection);
				  proces.setFinallScore(allFinallScore);
				   
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
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont1(poleUpravenychStringov[numberRandom]);
				int numberRandom2 = randomProcess.getRandomNumber();
				
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom2 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont2(poleUpravenychStringov[numberRandom2]);
				int numberRandom3 = randomProcess.getRandomNumber();
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom3 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont3(poleUpravenychStringov[numberRandom3]);
				int numberRandom4 = randomProcess.getRandomNumber();
				
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom4 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont4(poleUpravenychStringov[numberRandom4]);
				int numberRandom5 = randomProcess.getRandomNumber();
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom5 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont5(poleUpravenychStringov[numberRandom5]);
				int numberRandom6 = randomProcess.getRandomNumber();
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom6 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont6(poleUpravenychStringov[numberRandom6]);
				int numberRandom7 = randomProcess.getRandomNumber();
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom7 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont7(poleUpravenychStringov[numberRandom7]);
				int numberRandom8 = randomProcess.getRandomNumber();
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom8 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont8(poleUpravenychStringov[numberRandom8]);
				int numberRandom9 = randomProcess.getRandomNumber();
				
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
						numberRandom9 = randomProcess.getRandomNumber();
						continue;
					} else {
						randomProcess.setOneNumber();
						break;
					}
				}
				proces.setLblWont9(poleUpravenychStringov[numberRandom9]);
				int numberRandom10 = randomProcess.getRandomNumber();
				
				// pole nahodne vybranych indexov
				while (stav) {
					if (randomProcess.hladajZhodu()) {
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
				dispose();
			}
			}catch (NullPointerException ex)
			{
				JOptionPane.showMessageDialog(null, "Bad information for, try again");
				UserOptions user = new UserOptions();
                user.setTxtArea(getTxtArea());
			}
			    
		        
		
	}
	public int getNumbers(RandomNumber classNumber)
	{
		RandomNumber find = classNumber;
		int value = find.getRandomNumber();
		boolean stav = true;
		while(stav){
			if(value ==1){
				value = find.getRandomNumber();
				continue;
			}
			else if(value != 1)break;
		}

		return value;
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}
	
	public void setAllFinallScore(String text)
	{
		allFinallScore = text;
	}
	// pomocna metoda 
	public String getAllFinallScore()
	{
		return allFinallScore;
	}
	
	public int getUserSelectedIndex()
	{
		return sectionTesting;
	}


}
