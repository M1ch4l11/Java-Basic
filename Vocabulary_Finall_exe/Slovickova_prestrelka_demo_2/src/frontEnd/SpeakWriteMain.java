package frontEnd;


import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpeakWriteMain {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SpeakWriteMain window = new SpeakWriteMain();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SpeakWriteMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 255));
		frame.setBounds(100, 100, 640, 135);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnAlone = new JButton("play alone");
		btnAlone.setBackground(SystemColor.info);
		btnAlone.setBorder(null);
		btnAlone.setForeground(SystemColor.desktop);
		btnAlone.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		btnAlone.setBounds(108, 79, 134, 46);
		btnAlone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAlone) {
					AloneProcess alone = new AloneProcess();
					alone.setTime(System.currentTimeMillis());
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnAlone);
		
		JButton btnSomebody = new JButton("play with somebody\r\n");
		btnSomebody.setBackground(SystemColor.info);
		btnSomebody.setBorder(null);
		btnSomebody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSomebody)JOptionPane.showMessageDialog(btnSomebody, "Coming soon");
			}
		});
		btnSomebody.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		btnSomebody.setBounds(332, 79, 218, 46);
		frame.getContentPane().add(btnSomebody);
		
		JButton btnNewButton_1 = new JButton("Bye!");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(573, 0, 67, 34);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Do you want to play alone or vs somebody?");
		lblNewJgoodiesTitle.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesTitle.setBounds(60, 21, 478, 46);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		frame.setVisible(true);
	}
}
