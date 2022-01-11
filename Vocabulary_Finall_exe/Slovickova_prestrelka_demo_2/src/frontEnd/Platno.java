package frontEnd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Platno extends JComponent implements ActionListener {
	private static final long serialVersionUID = 1L;
	Timer time = new Timer(5, this);
	int x = 0, xNext = 2;
	int y = 0, yNext = 2;
	int pocetOpakovani = 0;
	public int scoreUser;
	boolean accesForFinallTarget = false;
	int[] poleAllScoreUser;
	Random random;
	Graphics2D g2;
	TercG terc;
	protected void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		terc = new TercG();
		terc.kresli(g2);
		if(pocetOpakovani < 25 ) g2.fillOval(xNext, yNext, 60, 60);
		if(pocetOpakovani > 25 && pocetOpakovani <= 50) g2.fillOval(xNext, yNext, 45, 45);
		if(pocetOpakovani > 50 && pocetOpakovani <= 75 ) g2.fillOval(xNext, yNext, 30, 30);
		if(pocetOpakovani > 75 && pocetOpakovani <= 99) g2.fillOval(xNext, yNext, 15, 15);
		if(pocetOpakovani!=100)time.start();
		showFinallOval();
		if(accesForFinallTarget==true){
			for(int i = 0; i < poleAllScoreUser.length;i++){
				scoreUser = poleAllScoreUser[i];
				showFinallOval();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		random = new Random();
			 do {
		         xNext = random.nextInt(699) + 1;
		         yNext = random.nextInt(699) + 1;
				 } while(xNext >= 700 || yNext >= 700);
		x = xNext;
		y = yNext;
		pocetOpakovani++;
		if (pocetOpakovani == 101)time.stop();
		if (pocetOpakovani != 101)repaint();
	}
	public void setVisibilityOff(){
		setVisible(false);
	}
	public void setVisibilityOnn(){
		setVisible(true);
	}
	/**
	 * metoda nadstavuje pole a povoluje ukazanie vsetkych striel
	 */
	public void setAllValueFieldScoreForTarget(int[] scoreField){
		poleAllScoreUser = scoreField;
		accesForFinallTarget=true;
	}
	public void setScore(int score)	{
		this.scoreUser = score;
	}
	public void showFinallOval()
	{
		if(pocetOpakovani==100) {
			if(scoreUser == 1)
			{
				g2.fillOval(267, 272, 10, 10);
			}
			if(scoreUser == 2)
			{
				g2.fillOval(289, 294, 10, 10);
			}
			if(scoreUser == 4)
			{
				g2.fillOval(311, 316, 10, 10);
			}
			if(scoreUser == 6)
			{
				g2.fillOval(333, 338, 10, 10);
			}
			if(scoreUser == 8)
			{
				g2.fillOval(355, 360, 10, 10);
			}
			if(scoreUser == 10)
			{
				g2.fillOval(385, 400, 10, 10);
			}
			
		}
		
	}

	


	
	
	

}
