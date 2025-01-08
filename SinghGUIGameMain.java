/*
 * Samrath Singh
 * ICS4UO-B
 * GUI Game
 * 2023/02/21
 * This program allows the user to guess a number from 1 to 6 using buttons.
 * A new number is generated every time "Start" is clicked.
 * The user has 3 lives each round.
 * The correct answer will be displayed no matter if the user guesses or doesn't guess the answer.
 * The games played, games won, and games lost is displayed at all times.
 */
import javax.swing.*; //import all items

import java.awt.event.*; //when button is clicked

/**
 * This is the main class
 * @author Samrath
 */
public class SinghGUIGameMain {

	//declare all class variables
	static JFrame frame;
	static JLabel label, welcomeLabel, gamesLabel;
	static JPanel panel;
	static JButton bStart, b1, b2, b3, b4, b5, b6, bQuit, bExit;
	static ImageIcon image;
	static int lifeCounter = 3;
	static int gamesPlayed = 0;
	static int gamesWon = 0;
	static int gamesLost = 0;
	static int number;
	static String WELCOME = ("<html>Welcome to Samrath's Guess the Number Game!<br/><br/>In this game you will have 3 trys to guess a randomly generated number from 1 to 6."
							+ "<br/>A new number is generated every game.<br/><br/> Click Start to begin a new game.<br/>Click Quit to end your current game.<br/ Click Exit to exit "
							+ "the program.<br/><br/>Make your guesses below:<br/><br/><html>");
	static String CORRECT;
	static String LOSE;
	static String END_GAME;
	static String GAMES;
	
	/**
	 * This method is used to generate a random number between the inclusive min number and exclusive max number 
	 * @param min
	 * @param max
	 * @return
	 */
	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min); //formula for returning the random number within a specified range
	}
	
	/**
	 * This main method is used to call other methods
	 * @param args
	 */
	public static void main(String[] args) {
		//Method calls
		buildGUI();
		welcome();
		buttonsConfig(false);
		actionListeners();
	}
	
	/**
	 * This method is used to initialize and build the GUI
	 */
	private static void buildGUI() {
		//initialize and create a main window
		frame = new JFrame("Samrath's Guess the Number Game");
		frame.setSize(495, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//initialize and add a panel to the frame
		panel = new JPanel();
		frame.add(panel);
		
		//initialize and add labels and buttons to the panel
		welcomeLabel = new JLabel();
		panel.add(welcomeLabel);
		bStart = new JButton("Start");
		panel.add(bStart);
		b1 = new JButton("1");
		panel.add(b1);
		b2 = new JButton("2");
		panel.add(b2);
		b3 = new JButton("3");
		panel.add(b3);
		b4 = new JButton("4");
		panel.add(b4);
		b5 = new JButton("5");
		panel.add(b5);
		b6 = new JButton("6");
		panel.add(b6);
		bQuit = new JButton("Quit");
		panel.add(bQuit);
		bExit = new JButton("Exit");
		panel.add(bExit);
		label = new JLabel();
		panel.add(label);
		gamesLabel = new JLabel();
		panel.add(gamesLabel);

		frame.setVisible(true); //Make the frame along with all components in it visible
	}
	
	/**
	 * This method is used to display the welcome message for the program
	 */
	private static void welcome() {
		welcomeLabel.setText(WELCOME); //setting the text for the JLabel welcomeLabel
	}

	/**
	 * This method is used to set or update the status of buttons
	 */
	private static void buttonsConfig(boolean status) {
		  
		//changing the status for buttons
		bStart.setEnabled(!status);
		b1.setEnabled(status);
		b2.setEnabled(status);
		b3.setEnabled(status);
		b4.setEnabled(status);
		b5.setEnabled(status);
		b6.setEnabled(status);
		bQuit.setEnabled(status);
	}

	/**
	 * This method contains action listeners for all buttons and the actions to be performed when each is clicked
	 */
	private static void actionListeners() {
		bStart.addActionListener(new ActionListener() { //listener for the JButton bStart
			public void actionPerformed(ActionEvent e) {
				
				//changing the status for buttons
				buttonsConfig(true); //calling method
				number = getRandomNumber(1, 7); //setting the range and generating the random number
				
				//Setting values for string variables
				CORRECT = ("<html>Your guess is correct! The answer was "+ number +"!<br/>You may click Start to begin a new game, or Exit to exit the program.<html>");
				LOSE = ("<html>You were not able to guess the correct number! The correct number was "+ number +"."
						+ "<br/>You may click Start to begin a new game, or Exit to exit the program.<html>");
				END_GAME = ("<html>The current game has been quit. The answer was "+ number +"!<br/>You may click Start to begin a new game, or Exit to exit the program.<html>");
				GAMES = ("<html>Games played: "+ gamesPlayed +"<br/>Games won: "+ gamesWon +"<br/>Games lost: "+ gamesLost +"<html>");
				
				gamesLabel.setText(GAMES); //setting the text for the JLabel gamesLabel
			}
		});
		b1.addActionListener(new ActionListener() { //listener for the JButton b1
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false); //disabling the button
				checker(1); //calling the checker method using an int of the corresponding button value
			}
		});
		b2.addActionListener(new ActionListener() { //listener for the JButton b2
			public void actionPerformed(ActionEvent e) {
				b2.setEnabled(false); //disabling the button
				checker(2); //calling the checker method using an int of the corresponding button value
			}
		});
		b3.addActionListener(new ActionListener() { //listener for the JButton b3
			public void actionPerformed(ActionEvent e) {
				b3.setEnabled(false); //disabling the button
				checker(3); //calling the checker method using an int of the corresponding button value
			}
		});
		b4.addActionListener(new ActionListener() { //listener for the JButton b4
			public void actionPerformed(ActionEvent e) {
				b4.setEnabled(false); //disabling the button
				checker(4); //calling the checker method using an int of the corresponding button value
			}
		});
		b5.addActionListener(new ActionListener() { //listener for the JButton b5
			public void actionPerformed(ActionEvent e) {
				b5.setEnabled(false); //disabling the button
				checker(5); //calling the checker method using an int of the corresponding button value
			}
		});
		b6.addActionListener(new ActionListener() { //listener for the JButton b6
			public void actionPerformed(ActionEvent e) {
				b6.setEnabled(false); //disabling the button
				checker(6); //calling the checker method using an int of the corresponding button value
			}
		});
		bQuit.addActionListener(new ActionListener() { //listener for the JButton bQuit
			public void actionPerformed(ActionEvent e) {
				
				//changing the status for buttons
				buttonsConfig(false); //calling method
				
				label.setText(END_GAME); //setting the text for the JLabel label
				lifeCounter = 3; //resetting the lifeCounter int back to 3
				updateGameCounters(false);
			}
		});
		bExit.addActionListener(new ActionListener() { //listener for the JButton bExit
			public void actionPerformed(ActionEvent e) {
			  System.exit(0); //ending the program
			}
		});
	}

	/**
	 * This method checks if the guess variable meets any of the conditions in the if statements conditions
	 * @param guess
	 */
	private static void checker(int guess) {

		if (guess == number) { //if condition
			
			//changing the status for buttons
			buttonsConfig(false); //calling method

			label.setText(CORRECT); //setting the text for the JLabel label
			lifeCounter = 3; //resetting the lifeCounter int back to 3
			updateGameCounters(true);	
		} else {
			lifeCounter--; //Reducing the lifeCounter int by 1
			label.setText("Your guess is incorrect! You have " + lifeCounter +" guesses left to try and find the correct answer."); //setting the text for the JLabel label

			if (lifeCounter == 0) { //nested if condition
				
				//changing the status for buttons
				buttonsConfig(false); //calling method

				label.setText(LOSE); //setting the text for the JLabel label
				lifeCounter = 3; //resetting the lifeCounter int back to 3
				updateGameCounters(false);
			}
		}
	}
	
	/**
	 * This method is used to update the game counters
	 * If the user guesses the number, the isWin parameter is passed as true, else false
	 * @param isWin
	 */
	private static void updateGameCounters(boolean isWin) {
		gamesPlayed++; //increasing the counter for games played by 1
		
		if (isWin) {
			gamesWon++; //increasing the counter for games won by 1
		} else {
			gamesLost++; //increasing the counter for games lost by 1
		}
		GAMES = ("<html>Games played: "+ gamesPlayed +"<br/>Games won: "+ gamesWon +"<br/>Games lost: "+ gamesLost +"<html>"); //updating the string variable with new int values
		gamesLabel.setText(GAMES); //setting the text for the JLabel gamesLabel
	}
}//end of class