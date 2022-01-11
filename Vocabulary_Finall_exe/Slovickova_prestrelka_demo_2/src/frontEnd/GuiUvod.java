package frontEnd;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import backEnd.AreaOfLive;
import backEnd.MainClass;
import backEnd.TestMain;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GuiUvod {
	private JFrame frmRun;
	private JLabel lblImage;
	public static void main(String[] args) {
		GuiUvod startAplikation = new GuiUvod();
		startAplikation.initialize();
    }
	/**
	 * Create the application.
	 */
	public GuiUvod() {	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//centruj = new CentrovanieOkna();
		frmRun = new JFrame();
		frmRun.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmRun.setBackground(SystemColor.menu);
		frmRun.getContentPane().setBackground(UIManager.getColor("activeCaption"));
		frmRun.setType(Type.POPUP);
		frmRun.setForeground(Color.WHITE);
		frmRun.setTitle("words shootout");
		frmRun.setBounds(100, 100, 956, 628);
		frmRun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRun.setUndecorated(true);
		frmRun.getContentPane().setLayout(null);
		JLabel lblTxtTitle = DefaultComponentFactory.getInstance().createTitle("Vocabulary Shooting Range");
		lblTxtTitle.setBounds(80, 10, 764, 188);
		lblTxtTitle.setForeground(SystemColor.text);
		lblTxtTitle.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 60));
		frmRun.getContentPane().add(lblTxtTitle);
		JButton btnSpeak = new JButton("Let's go speaking");
		btnSpeak.setBounds(43, 338, 195, 43);
		btnSpeak.setInheritsPopupMenu(true);
		btnSpeak.setIgnoreRepaint(true);
		btnSpeak.setForeground(Color.BLACK);
		btnSpeak.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 28));
		btnSpeak.setBorderPainted(false);
		btnSpeak.setBorder(null);
		btnSpeak.setBackground(SystemColor.menu);
		btnSpeak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSpeak) {
					JOptionPane.showMessageDialog(null, "Coming soon");
				}
			}
		});
		frmRun.getContentPane().add(btnSpeak);
		JLabel lblTxtSpeak = DefaultComponentFactory.getInstance().createTitle("Would you like to take a speaking test?");
		lblTxtSpeak.setBounds(19, 278, 406, 28);
		lblTxtSpeak.setForeground(SystemColor.text);
		lblTxtSpeak.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 28));
		frmRun.getContentPane().add(lblTxtSpeak);
		JLabel lblTxtWriting = DefaultComponentFactory.getInstance().createTitle("Would you like to take a writing test?\r\n");
		lblTxtWriting.setBounds(19, 419, 406, 41);
		frmRun.getContentPane().add(lblTxtWriting);
		lblTxtWriting.setForeground(SystemColor.text);
		lblTxtWriting.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 28));
		JButton btnClose = new JButton("Bye!");
		btnClose.setBorderPainted(false);
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 153, 51));
		btnClose.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		btnClose.setBounds(871, 0, 85, 34);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnClose)frmRun.dispose();
				}
		});
		frmRun.getContentPane().add(btnClose);
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Hello guys,");
		lblNewJgoodiesTitle_1.setBounds(563, 301, 181, 57);
		lblNewJgoodiesTitle_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesTitle_1.setForeground(SystemColor.text);
		frmRun.getContentPane().add(lblNewJgoodiesTitle_1);
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Befor you go to action,I have some information to you. ");
		lblNewJgoodiesTitle.setBounds(328, 341, 597, 57);
		lblNewJgoodiesTitle.setForeground(SystemColor.text);
		lblNewJgoodiesTitle.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		frmRun.getContentPane().add(lblNewJgoodiesTitle);
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("This game is a quick test of your knowledge. ");
		lblNewJgoodiesTitle_2.setBounds(395, 381, 528, 43);
		lblNewJgoodiesTitle_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesTitle_2.setForeground(SystemColor.text);
		frmRun.getContentPane().add(lblNewJgoodiesTitle_2);
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("Do you know who wins at school? \r\n");
		lblNewJgoodiesTitle_3.setBounds(435, 419, 393, 28);
		lblNewJgoodiesTitle_3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesTitle_3.setForeground(SystemColor.text);
		frmRun.getContentPane().add(lblNewJgoodiesTitle_3);
		JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("The one with a better memory.");
		lblNewJgoodiesTitle_4.setBounds(475, 445, 340, 43);
		lblNewJgoodiesTitle_4.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesTitle_4.setForeground(SystemColor.text);
		frmRun.getContentPane().add(lblNewJgoodiesTitle_4);
		JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory.getInstance().createTitle("This game is just like the ones in school.");
		lblNewJgoodiesTitle_5.setBounds(416, 481, 509, 41);
		lblNewJgoodiesTitle_5.setForeground(SystemColor.text);
		lblNewJgoodiesTitle_5.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		frmRun.getContentPane().add(lblNewJgoodiesTitle_5);
		JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory.getInstance().createTitle("When the game is over, you'll see the time,");
		lblNewJgoodiesTitle_6.setBounds(403, 518, 470, 43);
		lblNewJgoodiesTitle_6.setForeground(SystemColor.text);
		lblNewJgoodiesTitle_6.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		frmRun.getContentPane().add(lblNewJgoodiesTitle_6);
		JLabel lblNewJgoodiesTitle_8 = DefaultComponentFactory.getInstance().createTitle("Enjoy!");
		lblNewJgoodiesTitle_8.setBounds(295, 563, 158, 57);
		lblNewJgoodiesTitle_8.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 40));
		lblNewJgoodiesTitle_8.setForeground(SystemColor.text);
		frmRun.getContentPane().add(lblNewJgoodiesTitle_8);
		JLabel lblNewJgoodiesTitle_9 = DefaultComponentFactory.getInstance().createTitle("the score and the name of the winner.");
		lblNewJgoodiesTitle_9.setBounds(463, 548, 406, 57);
		lblNewJgoodiesTitle_9.setForeground(SystemColor.text);
		lblNewJgoodiesTitle_9.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		frmRun.getContentPane().add(lblNewJgoodiesTitle_9);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(43, 480, 195, 43);
		frmRun.getContentPane().add(menuBar);
		JMenu mnNewMenu = new JMenu("  Lets go writing");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnNewMenu.setBorder(null);
		mnNewMenu.setBounds(43, 480, 195, 43);
		mnNewMenu.setBackground(SystemColor.menu);
		mnNewMenu.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 28));
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem = new JMenuItem("Alone");
		mntmNewMenuItem.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmNewMenuItem) {
					// Front -End (objekty)
					UserOptions user = new UserOptions();			
					/*
					 * procesovanie SK files
					 */
					URL url = GuiUvod.class.getResource("/DataSVK_ANJ");
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
				    	if(pocitanieSlov == numberGoNext){
					    	nazvyPreUsera += areaOfLive.getFirstWord() + "; " +"\n";
					    	numberGoNext += 4;
					    	continue;
				    	}
				    	nazvyPreUsera += areaOfLive.getFirstWord() + "; ";
					}
				    user.setTxtArea(nazvyPreUsera);
					frmRun.dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		mnNewMenu.setMnemonic(KeyEvent.VK_ENTER);
		lblImage = new JLabel("\r\n");
		lblImage.setBounds(-2, 0, 958, 630);
		lblImage.setForeground(SystemColor.desktop);
		lblImage.setBackground(SystemColor.menu);
		lblImage.setIcon(new ImageIcon(GuiUvod.class.getResource("/image/krajina2.jpg")));
		frmRun.getContentPane().add(lblImage);
		// nadstavujeme iconu v lavom hornom rohu aplikacie
		ImageIcon icon = new ImageIcon(GuiUvod.class.getResource("/image/ML5.jpg"));
		frmRun.setIconImage(icon.getImage());
		// zobrazenie okna na obrazovke...
		frmRun.setLocationRelativeTo(null);
		frmRun.setVisible(true);
	}
}
