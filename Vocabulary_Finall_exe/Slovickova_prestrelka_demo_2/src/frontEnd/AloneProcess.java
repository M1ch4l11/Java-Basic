package frontEnd;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import Target.AloneTarget;
import backEnd.AreaOfLive;
import backEnd.GetFirstWord;
import backEnd.KodovanieUtf;
import backEnd.MainClass;
import backEnd.TestMain;


public class AloneProcess {
	private JFrame frame;
	public JLabel lblTime;
	public JLabel lblWont10;
	public JLabel lblWont9;
	public JLabel lblWont8;
	public JLabel lblWont7;
	public JLabel lblWont6;
	public JLabel lblWont5;
	public JLabel lblWont4;
	public JLabel lblWont3;
	public JLabel lblWont2;
	public JLabel lblWont1;
	public JTextField textField_10;
	public JTextField textField_11;
	public JTextField textField_12;
	public JTextField textField_13;
	public JTextField textField_14;
	public JTextField textField_15;
	public JTextField textField_16;
	public JTextField textField_17;
	public JTextField textField_18;
	public JTextField textField_19;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	AloneTarget targetClass;
	AloneMain finallValuesEnter;
    // --------------------------------------------------------
	int countOfScore = 0; 
	Timer timer;
	private Robot bot;
	// int delay = 100;
	int milis = 0;
	int second = 0;
	String secondString = String.format("%020d", second);	
	// time for close app
    int seconApp = 0;
	boolean stav = true;
	int[] fieldsForAllScoreUser = new int[10];
	int nextField = 0;
	int[] numbersIndex;
	public long startTime;
	public long stopTime;
	public String nameOfSection = "";
	// --------------------------------------------------------------
	ArrayList<AreaOfLive> objectySK ;
	ArrayList<String[]> fieldsOfWordSk;
	ArrayList<AreaOfLive> objectyAj;
	ArrayList<String[]> fieldsOfWordAj;
	ArrayList<AreaOfLive> objekty;
	KodovanieUtf koduj;
	File folderSK;
	MainClass mainSK;
	File folderAJ;
	MainClass mainAJ;
	GetFirstWord wordFirst;
	String[] fieldsAjString;
	String allFinallScore;
	/**
	 * Create the application.
	 */
	public AloneProcess() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws  
	 */
	private void initialize()  {	
		// back end
		/*
		 *  Saves data Sk files
		 */
		 objectySK = new ArrayList<AreaOfLive>();
		 fieldsOfWordSk = new ArrayList<String[]>();
		/*
		 *  Saves data Aj files
		 */
		 objectyAj = new ArrayList<AreaOfLive>();
		 fieldsOfWordAj = new  ArrayList<String[]>();
		
		/*
		 * procesovanie SK files
		 */
		koduj = new KodovanieUtf();
		URL url = AloneProcess.class.getResource("/DataSVK_ANJ");
	    folderSK = new File(url.getFile());
		mainSK = new MainClass(folderSK);
		TestMain mainTest = new TestMain();
	    mainSK.setProcess();
		//class target for showing shoot
		targetClass = new AloneTarget();
		targetClass.setVisibilityFalse();
		targetClass.setVisibilityMessageClassOff();
		targetClass.centrujOkno();
	    // ziskanie objektov utf-8
	    objekty = mainTest.getObjectyOdkodovaneUTf(mainSK.geFieldsOfObjects());
	    objectySK.addAll(mainSK.getObjectFieldsOfMain());
		    /*
			    * procesovanie AJ files
			    * ----------------------------------------------------------------------------
				*/
				URL urlANJ = AloneProcess.class.getResource("/DataANJ");
			   folderAJ = new File(urlANJ.getFile());
		       mainAJ = new MainClass(folderAJ);
		       wordFirst = new  GetFirstWord();
		       /*
		        * process - first word everywhere
		        */
		        wordFirst.setWord(mainSK.getWord());
		        mainAJ.setWord(wordFirst.getWord());
		        mainAJ.setProcess();
		        mainAJ.processFolders();
		       /*
		        *  vytahujeme objekty
		        */
		       objectyAj.addAll(mainAJ.getObjectFieldsOfMain());
		    // front - end
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 912, 744);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		finallValuesEnter = new AloneMain();
		finallValuesEnter.setVisibleFalse();
		// Objekt pomocnej triedy pre posuvanie kurzora 
		try {
			bot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		textField_10 = new JTextField();
		textField_10.setBounds(544, 30, 185, 44);
		textField_10.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {	
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					kodujUtf();
					fieldsAjString = fieldsOfWordAj.get(0);	
					textField_10.setBackground(SystemColor.menu);
					textField_10.setEditable(false);	
					if(fieldsAjString[(numbersIndex[0] + 1)].equalsIgnoreCase(textField_10.getText())){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;	
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
				    }
					finallValuesEnter.setLblTxtPrve(fieldsAjString[numbersIndex[0] + 1]);
					finallValuesEnter.setLblTxtPrveOdpoved(textField_10.getText());
			    }   
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(544, 90, 185, 44);
		textField_11.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_11.setBackground(SystemColor.menu);
					textField_11.setEditable(false);
					if(textField_11.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[1] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setVisibilityMessageClassOn();
						targetClass.setTimerClassOnn();
						timer.start();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtDruhe(fieldsAjString[numbersIndex[1] + 1]);
					finallValuesEnter.setLblTxtDruheOdpoved(textField_11.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_11);
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(544, 150, 185, 44);
		textField_12.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_12.setBackground(SystemColor.menu);
					textField_12.setEditable(false);	
					if(textField_12.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[2] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtTretie(fieldsAjString[numbersIndex[2] + 1]);
					finallValuesEnter.setLblTxtTretieOdpoved(textField_12.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_12);
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(544, 210, 185, 44);
		textField_13.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_13.setBackground(SystemColor.menu);
					textField_13.setEditable(false);	
					if(textField_13.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[3] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					
					finallValuesEnter.setLblTxtStvrte(fieldsAjString[numbersIndex[3] + 1]);
					finallValuesEnter.setLblTxtStvrteOdpoved(textField_13.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_13);
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(544, 270, 185, 44);
		textField_14.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_14.setBackground(SystemColor.menu);
					textField_14.setEditable(false);
					if(textField_14.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[4] + 1)])){countOfScore++;
					int valueTimeString = Integer.parseInt(secondString);
					int finallScore = targetClass.getFinallScore(valueTimeString);
					targetClass.setPlatnoScoreAndClassOn(finallScore);
					targetClass.setVisibilityTrue();
					targetClass.setPlatnoVisibleTrue();
					targetClass.setMessageClassOnTxtForUser(finallScore);
					targetClass.setTimerClassOnn();
					targetClass.setVisibilityMessageClassOn();
					timer.stop();
					setTimeDefault();
					timer.start();
					fieldsForAllScoreUser[nextField] = finallScore;
					nextField++;
				}
				else {
					targetClass.setMessageClassOnTxtForUser(0);
					timer.stop();
					targetClass.setMessageTimeClassOnnVisibleOff();
					targetClass.setMessageClassMoveNextTextField();
					setTimeDefault();
					timer.start();
				}
					finallValuesEnter.setLblTxtPiate(fieldsAjString[numbersIndex[4] + 1]);
					finallValuesEnter.setLblTxtPiateOdpoved(textField_14.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_14);
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(544, 330, 185, 44);
		textField_15.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_15.setBackground(SystemColor.menu);
					textField_15.setEditable(false);	
					if(textField_15.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[5] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtSieste(fieldsAjString[numbersIndex[5] + 1]);
					finallValuesEnter.setLblTxtSiesteOdpoved(textField_15.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_15);
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(544, 390, 185, 44);
		textField_16.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_16.setBackground(SystemColor.menu);
					textField_16.setEditable(false);	
					if(textField_16.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[6] + 1 )])){ 
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtSiedme(fieldsAjString[numbersIndex[6] + 1]);
					finallValuesEnter.setLblTxtSiedmeOdpoved(textField_16.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_16);
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(544, 450, 185, 44);
		textField_17.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_17.setBackground(SystemColor.menu);
					textField_17.setEditable(false);
					if(textField_17.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[7] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtOsme(fieldsAjString[numbersIndex[7] + 1]);
					finallValuesEnter.setLblTxtOsmeOdpoved(textField_17.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_17);
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(544, 510, 185, 44);
		textField_18.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_18.setBackground(SystemColor.menu);
					textField_18.setEditable(false);
					if(textField_18.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[8] + 1)])){
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						setTimeDefault();
						timer.start();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						timer.stop();
						targetClass.setMessageTimeClassOnnVisibleOff();
						targetClass.setMessageClassMoveNextTextField();
						setTimeDefault();
						timer.start();
					}
					finallValuesEnter.setLblTxtDeviate(fieldsAjString[numbersIndex[8] + 1]);
					finallValuesEnter.setLblTxtDeviateOdpoved(textField_18.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_18);
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(544, 570, 185, 44);
		textField_19.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					textField_19.setBackground(SystemColor.menu);
					textField_19.setEditable(false);
					if(textField_19.getText().equalsIgnoreCase(fieldsAjString[(numbersIndex[9] + 1)])){ 
						countOfScore++;
						int valueTimeString = Integer.parseInt(secondString);
						int finallScore = targetClass.getFinallScore(valueTimeString);
						targetClass.setPlatnoScoreAndClassOn(finallScore);
						targetClass.setVisibilityTrue();
						targetClass.setPlatnoVisibleTrue();
						targetClass.setMessageClassOnTxtForUser(finallScore);
						targetClass.setTimerClassOnn();
						targetClass.setVisibilityMessageClassOn();
						timer.stop();
						fieldsForAllScoreUser[nextField] = finallScore;
						nextField++;
					}
					else {
						targetClass.setMessageClassOnTxtForUser(0);
						targetClass.setMessageTimeClassOnnVisibleOff();
						timer.stop();
					}
					finallValuesEnter.setLblTxtDesiate(fieldsAjString[numbersIndex[9] + 1]);
					finallValuesEnter.setLblTxtDesiateOdpoved(textField_19.getText());
					String value = "  Your Score in this trial:  " + countOfScore;
					finallValuesEnter.setTxtArea(value);
					finallValuesEnter.setCountOfScore(countOfScore);
					finallValuesEnter.setNameOfSection(nameOfSection);
					stopTime = (System.currentTimeMillis() / 1000) - startTime;  // dostaneme vysledok v secundach
					finallValuesEnter.setScore(countOfScore);
					finallValuesEnter.setPlatnoScore();
					finallValuesEnter.setPLatnoAllScore(fieldsForAllScoreUser);
					finallValuesEnter.setFinallTime(secondString);                          // secontString cas...
					finallValuesEnter.setVisibleTrue();
					finallValuesEnter.setTxtAreaFInallScore(allFinallScore);
					frame.dispose();					
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		frame.getContentPane().add(textField_19);
		lblWont1 = new JLabel();
		lblWont1.setBounds(109, 30, 293, 44);
		frame.getContentPane().add(lblWont1);
		lblWont2 = new JLabel();
		lblWont2.setBounds(109, 90, 293, 44);
		frame.getContentPane().add(lblWont2);
		lblWont3 = new JLabel();		
		lblWont3.setBounds(109, 150, 293, 44);
		frame.getContentPane().add(lblWont3);
		lblWont4 = new JLabel();
		lblWont4.setBounds(109, 210, 293, 44);
		frame.getContentPane().add(lblWont4);
		lblWont5 = new JLabel();		
		lblWont5.setBounds(109, 270, 293, 44);
		frame.getContentPane().add(lblWont5);
		lblWont6 = new JLabel();
		lblWont6.setBounds(109, 330, 293, 44);
		frame.getContentPane().add(lblWont6);
		lblWont7 = new JLabel();
		lblWont7.setBounds(109, 390, 293, 44);
		frame.getContentPane().add(lblWont7);
		lblWont8 = new JLabel();
		lblWont8.setBounds(109, 450, 293, 44);
		frame.getContentPane().add(lblWont8);
		lblWont9 = new JLabel();
		lblWont9.setBounds(109, 510, 293, 44);
		frame.getContentPane().add(lblWont9);
	    lblWont10 = new JLabel();
		lblWont10.setBounds(109, 570, 293, 44);
		frame.getContentPane().add(lblWont10);
		btnNewButton = new JButton("I've already finished. (Click on me :)");
		btnNewButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(223, 654, 293, 61);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					finallValuesEnter.setScore(countOfScore);
					finallValuesEnter.setPlatnoScore();
					kodujUtf();
					fieldsAjString = fieldsOfWordAj.get(0);
					finallValuesEnter.setNameOfSection(nameOfSection);
					setUserDataWiev();
					finallValuesEnter.setFinallTime(secondString);  // secontString cas...
					String value =  "  Your Score in this trial:  " + countOfScore;
					finallValuesEnter.setTxtArea(value);
					stopTime = (System.currentTimeMillis() / 1000) - startTime;  // dostaneme vysledok v secundach
					finallValuesEnter.setVisibleTrue();
					finallValuesEnter.setTxtAreaFInallScore(allFinallScore);
					frame.dispose();
				}
			}
		});
		// frame.getContentPane().add(btnNewButton);
		btnNewButton_1 = new JButton("Bye\r\n");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(839, 0, 73, 44);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					timer.stop();
					targetClass.setMessageClassDispose();
					targetClass.dispose();
					finallValuesEnter.setOff();
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		lblTime = new JLabel("00");
		lblTime.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		lblTime.setBounds(10, 5, 352, 34);
		frame.getContentPane().add(lblTime);
		timer = new Timer(1000, (ActionEvent e) -> {
				milis += 1000;
				second = (milis/1000);
				secondString = String.format("%02d", second);
				lblTime.setText(  secondString);
			}
		);
		timer.start();
		frame.setVisible(true);
		ImageIcon icon = new ImageIcon("C:\\Users\\xgelb\\Desktop\\Ikonky na Subory\\ML5.jpg");
		frame.setIconImage(icon.getImage());
	}
	public void setUserDataWiev(){
		finallValuesEnter.setLblTxtPrve(fieldsAjString[numbersIndex[0] + 1]);
		try{
			finallValuesEnter.setLblTxtPrveOdpoved(textField_10.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtDruhe(fieldsAjString[numbersIndex[1] + 1]);
		try{
			finallValuesEnter.setLblTxtDruheOdpoved(textField_11.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtTretie(fieldsAjString[numbersIndex[2] + 1]);
		try{
			finallValuesEnter.setLblTxtTretieOdpoved(textField_12.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtStvrte(fieldsAjString[numbersIndex[3] + 1]);
		try{
			finallValuesEnter.setLblTxtStvrteOdpoved(textField_13.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtPiate(fieldsAjString[numbersIndex[4] + 1 ]);
		try{
			finallValuesEnter.setLblTxtPiateOdpoved(textField_14.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtSieste(fieldsAjString[numbersIndex[5] + 1]);
		try{
			finallValuesEnter.setLblTxtSiesteOdpoved(textField_15.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtSiedme(fieldsAjString[numbersIndex[6] + 1]);
		try{
			finallValuesEnter.setLblTxtSiedmeOdpoved(textField_16.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtOsme(fieldsAjString[numbersIndex[7] + 1]);
		try{
			finallValuesEnter.setLblTxtOsmeOdpoved(textField_17.getText());
		}catch(NullPointerException ex) {}
		finallValuesEnter.setLblTxtDeviate(fieldsAjString[numbersIndex[8] + 1]);
		try{
			finallValuesEnter.setLblTxtDeviateOdpoved(textField_18.getText());
		}catch (NullPointerException ex) {}
		finallValuesEnter.setLblTxtDesiate(fieldsAjString[numbersIndex[9] + 1]);
		try{
			finallValuesEnter.setLblTxtDesiateOdpoved(textField_19.getText());
		}catch (NullPointerException ex) {}
	}
	public void setOff(){
		frame.dispose();
	}
	public void clickFirstKomponent(){
		// nakliknutie prvej komponenty 
	    bot.mouseMove(900, 90);
	    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);	
	}
	public void kodujUtf() {
		   /*
	        *  kodujeme utf8 !! mozno to bude treba az nakonci procesovania vo front-ende
	        */
	       for (AreaOfLive objectAj  : objectyAj) {   	 
	    	   // potrebuje najst txt file ktory ma rovnake data, ale v inom language
	    	   if(objectAj.getFirstWord().equalsIgnoreCase(nameOfSection))
	    	    {
	    	   String[] pole = objectAj.getVeta().split(" ");
	    	   koduj.enKodingUtf(pole);
	    	   fieldsOfWordAj.add(koduj.getUtf8Field());
	    	    }
		     }
	}
	public void setVisibleTrue(){
		frame.setVisible(true);
	}
	public void setVisibleFalse(){
		frame.setVisible(false);
	}
	public void setTimeDefault(){
		milis = 0;
		second = 0;
		secondString = " ";
	}
	public void setLblWont9(String lblWont9) {
		this.lblWont9.setText(lblWont9);
		}
	public void setLblWont8(String lblWont8) {
		this.lblWont8.setText(lblWont8);
	}
	public void setLblWont7(String lblWont7) {
		this.lblWont7.setText(lblWont7);
	}
	public void setLblWont6(String lblWont6) {
		this.lblWont6.setText(lblWont6);
	}
	public void setLblWont5(String lblWont5) {
		this.lblWont5.setText(lblWont5);
	}
	public void setLblWont4(String lblWont4) {
		this.lblWont4.setText(lblWont4);
	}
	public void setLblWont3(String lblWont3) {
		this.lblWont3.setText(lblWont3);
	}
	public void setLblWont10(String lblWont10) {
		this.lblWont10.setText(lblWont10);
	}
	public void setLblWont2(String lblWont2) {
		this.lblWont2.setText(lblWont2);
	}
	public void setLblWont1(String lblWont1) {
		this.lblWont1.setText(lblWont1);
	}
	public void setNameOfSection(String nameOfSection){
		this.nameOfSection = nameOfSection;
	}
	public void setFinallScore(String text){
		allFinallScore = text;
	}
	public void countScore1(){
		this.countOfScore++;
	}
	public void setFieldsIndex(int[] pole){
		numbersIndex = pole;
	}	
	public String getNameOfSection() {
		return nameOfSection;
	}
	public void setTime(long time){
		this.startTime = (time / 1000);
	}
}
