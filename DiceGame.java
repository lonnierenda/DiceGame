// (used when debugging)import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;


public class DiceGame {

	public static void main(String[] args) {
			
	// declare variables
	int numberOfDice = 5;
	int totalPoints = 0;
	int totalRolls = 0;
	boolean haveSix = false;
	boolean haveFive = false;
	boolean haveFour = false;
	
	// play the game
	
	do {
			int[] dice = new int[numberOfDice];
			dice = rollDice(dice);
			
			// (used for debugging)System.out.print(numberOfDice); 
			
			// (used for debugging)System.out.print(Arrays.toString(dice));
			totalPoints = 0;
			for (int i: dice){
				totalPoints = totalPoints + i;
			}
			if (haveSix == false) {
				haveSix = checkForSix(dice);
				if (haveSix == true) {
					numberOfDice = numberOfDice - 1;
					totalPoints = totalPoints - 6; // deducting points in case last role
				}// end nested if
				
				}// end if
			
			if ((haveSix == true) && (haveFive == false)) {
				haveFive = checkForFive(dice);
				if (haveFive == true) {
					numberOfDice = numberOfDice - 1;
					totalPoints = totalPoints - 5; // deducting point in case last role
				}// end nested if
				}// end if
			
			if ((haveSix == true) && (haveFive == true) && (haveFour == false)) {
				haveFour = checkForFour(dice);
				if (haveFour == true) {
					numberOfDice = numberOfDice - 1;
					totalPoints = totalPoints - 4; //deducting points in case last role
				}// end nested if
				}// end if
			
			// (used for debugging) System.out.print(totalPoints + " ");
			totalRolls = totalRolls + 1;
		} //end do
	
	while ((totalRolls < 3) && (haveFour == false)); 
	
	if ((totalRolls != 3) && (haveFour == true)){
		
		//int rollAgain = 0; was originally going to use, but was replaced by askRole
		do {
			int askRole = JOptionPane.showConfirmDialog(null, "Your score is " + totalPoints + ".\nYou have " + (3-totalRolls) + " roll(s) left.\nWould you like to roll again?", "Roll Again", JOptionPane.YES_NO_OPTION);
			if (askRole == 0) {
				int[] dice = new int[numberOfDice];
				dice = rollDice(dice);
				
				
				totalPoints = 0;
				//sum dice left
				for (int i: dice){
					totalPoints = totalPoints + i;
					//rollAgain = 0;
				
				}//end for
				totalRolls = totalRolls + 1;
				} //end if
			else {
				totalRolls = 3;		
				}//end else
		}//end do
		
		while ((totalRolls < 3)); //&& (rollAgain == 0));
			}//end if
	if (haveFour == true) {
		JOptionPane.showMessageDialog(null,"Your score is " + totalPoints + ".", "End of Game", 1);
	}//end if
	else {
		JOptionPane.showMessageDialog(null,"Sorry you did not get a score.", "End of Game", 1);
	}//end else
	}//end class DiceGame
	
	
	
	public static int[] rollDice(int[]dice){
		
		//declare random
		Random diceRoller = new Random();
		
		//set value for each die
		for (int i = 0; i < dice.length; i++) {
		  dice[i] = (diceRoller.nextInt(6) + 1);
		  // this also works: dice[i] = (int) (6*rand.nextDouble() + 1);
		  // but this does not work :dice[i] = (int) (6*rand.nextInt() + 1);
		  }
		
		//Return die values
		return dice;
	}// end rollDice
	
	public static boolean checkForSix(int[]dice){
		boolean six = false;
		for(int i = 0; i < dice.length; i++){
			if (dice[i] == 6) {
				six = true;
			}//end if	
	}//end for
		return six;
	}// end checkForSix
	
	public static boolean checkForFive(int[]dice){
		boolean five = false;
		for(int i = 0; i < dice.length; i++){
			if (dice[i] == 5) {
				five = true;
				}//end if	
	}// end for
		return five;
	}//end checkForFive
	
	public static boolean checkForFour(int[]dice){
		boolean four = false;
		for(int i = 0; i < dice.length; i++){
			if (dice[i] == 4) {
				four = true;
				}	//end if
	}// end for
		return four;
				}// end checkForFour

} // end class DiceGame
