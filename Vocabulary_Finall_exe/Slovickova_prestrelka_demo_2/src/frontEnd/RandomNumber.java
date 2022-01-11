package frontEnd;

import java.util.Random;

public class RandomNumber {
	public Random processRandom;
	int maxNumber;
	int[] poleZhod;
	int dalsiIndex = 0;
	int FinallNumber;
	
	public RandomNumber(int maxNumber)
	{
		processRandom = new Random();
		this.maxNumber = maxNumber;
		poleZhod = new int[10];
		
	}
	public void setFinallNumber(int finalNumber){
		this.FinallNumber = finalNumber;
	}
	
	public int getRandomNumber()
	{
	    FinallNumber = processRandom.nextInt(maxNumber);
		return FinallNumber;
	}
	
	public boolean hladajZhodu()
	{
		// boolean stav = true;
		// while(stav){
		// 	if(FinallNumber == 1){
		// 		getRandomNumber();
		// 		continue;
		// 	}
		// 	else if (FinallNumber !=1)break;

		// }
		boolean naslaSaZhoda = false;
		for(int i = 0; i < poleZhod.length;i++)
		{
			if(poleZhod[i]==this.FinallNumber) {
				return naslaSaZhoda= true; 
			}
		}
		return naslaSaZhoda;
	}
	public void setOneNumber()
	{
		this.poleZhod[this.dalsiIndex] = this.FinallNumber;
		this.dalsiIndex++;
	}
	public int[] getFieldIndex()
	{
		return poleZhod;
	}

}
