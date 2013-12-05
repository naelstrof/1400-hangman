/***************************************************************
*
*  Project  :  Hangman
*  File     :  Hangman
*  Name     :  Justin Behunin, Rachael Hull, Seth Jackson, Sara Jans, Dalton Nell
*  Date     :  12/05/2013
*
*  Description :  Creates the game instance for hangman. Includes the main method and
*                 calls the other classes to get a random word, generate the gallows 
*                 and the parts of the hangman for incorrect guesses. Asks for user
*                 to input guesses from the keybored and sends the guesses to the word
*                 class to see if they are correct. Upon either winning the game or losing
*                 the game displays approiate messages.
*
*  
****************************************************************/

package hangman;

import java.util.Scanner;

public class Hangman
{

	public static void main(String[] args)
	{
		Dictionary words = new Dictionary( "english.dic" );
		Player player = new Player();
		Word word = new Word( words.getRandomWord() );
		Scanner s = new Scanner( System.in );
		int state = 0; // Intro state
		boolean running = true;
		System.out.println( "Welcome to Hangman!" );
		while ( running )
		{
			switch ( state )
			{
				case 0: { // Intro
							System.out.println( "Enter one of the following options" );
							System.out.println( " 1. New game" );
							System.out.println( " 2. Quit" );
							int option = s.nextInt();
							switch ( option )
							{
								case 1: state = 1; break;
								case 2: {
											running = false;
											break;
										}
								default: {
											 System.out.println( state + " is not an acceptable option, try again." );
											 break;
										 }
							}
							break;
						}
				case 1: { // Game initialization
							player = new Player();
							word = new Word( words.getRandomWord() );
							state++;
							break;
						}
				case 2: { //Game
							System.out.println( player.getGallows() );
							System.out.println( player.toString() );
							System.out.println( word.toString() );
							System.out.printf( "Please enter a guess (letter or word):" );
							boolean correct = word.guess( s.next() );
							if ( correct )
							{
								System.out.println( "Good guess!" );
								if ( word.isCompleted() )
								{
									state++; // Go to win state
								}
							}
							else
							{
								System.out.println( "Incorrect..." );
								player.hurt( 1 );
								if ( !player.isAlive() )
								{
									state = 4; // Go to lose state
								}
							}
							break;
						}
				case 3: { // Win state
							System.out.println( "Congratulations! You're Winner!" );
							System.out.println( "The word was " + word.actualWord );
							state = 0; // Go to Intro state
							break;
						}
				case 4: { // Lose state
							System.out.println( player.getGallows() );
							System.out.println( "You've met a terrible fate, haven't you?" );
							System.out.println( "The word was " + word.actualWord );
							state = 0;
							break;
						}
			}
		}
		System.out.println( "Thanks for playing hangman!" );
	}
}
