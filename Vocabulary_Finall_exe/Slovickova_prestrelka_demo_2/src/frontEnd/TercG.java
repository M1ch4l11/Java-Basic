package frontEnd;


import java.awt.Color;
import java.awt.Graphics2D;




 

public class TercG {

	public void kresli (Graphics2D g)
	{
		//stena za tercom
		g.setColor(Color.darkGray);
		
		//g.fill3DRect(390, 10, 400, 300, true);
		g.fill3DRect(0, 0, 800, 900, true);	
		
		//terc
		g.setColor(Color.blue);
		g.fillOval(200, 200, 400, 400);
		
		g.setColor(Color.GREEN);
		g.fillOval(260, 260, 280, 280);
		
		g.setColor(Color.yellow);
		g.fillOval(320, 320, 160, 160);
		g.setColor(Color.red);
		g.fillOval(350, 350, 100, 100);
		
		//cisla
		g.setColor(Color.black);
		
		for(int i = 10; i >= 5 ;i--)
		{
			String number = Integer.toString(i);
			 String cisloS = "";
			if(i == 9 ){
				  cisloS = Integer.toString(i - 8);
			     }
			if(i == 8 ){
				  cisloS = Integer.toString(i - 6);
			     }
			if(i == 7 ){
				  cisloS = Integer.toString(i - 3);
			     }
			if(i == 6 ){
				  cisloS = Integer.toString(i);
			     }
			if(i == 5){
				cisloS = Integer.toString(i + 3);
			}
			if(i == 10){
				g.drawString(number, 390 , 400);	
			}
			else {
				g.drawString(cisloS, 470 - (i * 22), 470 - (i * 22));
			}
		}
		
		g.setColor(Color.black);
		g.drawOval(350, 350, 100, 100);
		g.drawOval(320, 320,160, 160);
		g.drawOval(290, 290, 220, 220);
		g.drawOval( 230, 230, 340, 340);
		g.drawOval(260, 260, 280, 280);
		g.drawOval(200, 200, 400, 400);
		
		
		
	
		
		
		
	}


	
	

}
