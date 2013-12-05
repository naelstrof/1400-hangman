/***************************************************************
*
*  Project  :  Hangman
*  File     :  Word
*  Name     :  Justin Behunin, Rachael Hull, Seth Jackson, Sara Jans, Dalton Nell
*  Date     :  12/05/2013
*
*  Description :  The word the player is trying to guess, as well as the player
*                 guesses are compared to see if the guesses are correct.
*                 Any correct letters are stored in the correct location in the 
*                 array that stores the players correct guesses.                
* 
*
*  
****************************************************************/

package hangman;

public class Word
{
	String renderableWord;
	String actualWord;

	public Word( String word )
	{
		actualWord = word;
		renderableWord = renderfy( actualWord, false );
	}

	public boolean guess( String guess )
	{
		boolean CorrectGuess = false;
		// Guessed a letter
		if ( guess.length() == 1 )
		{
			char[] array = actualWord.toCharArray();
			char[] renderable = renderableWord.toCharArray();
			for ( int i=0; i<array.length; i++ )
			{
				if ( guess.charAt(0) == array[i] )
				{
					int j = translateIndex( i );
					renderable[j] = array[i];
					CorrectGuess = true;
				}
			}
			renderableWord = new String( renderable );
			// Guessed a word
		}
		else
		{
			if ( guess.compareTo( actualWord ) == 0 )
			{
				renderableWord = renderfy( actualWord, true );
				CorrectGuess = true;
			}
		}
		return CorrectGuess;
	}

	public boolean isCompleted()
	{ 
		return !renderableWord.contains( "_" );
	}

	private String renderfy ( String word, boolean solved )
	{
		String foo = "";
		char[] array = word.toCharArray();
		for ( int i=0; i<array.length; i++ )
		{
			if ( i != array.length-1 )
			{
				if ( solved )
				{
					foo += array[i] + " ";
				}
				else
				{
					foo += "_ ";
				}
			}
			else
			{
				if ( solved )
				{
					foo += array[i];
				}
				else
				{
					foo += "_";
				}
			}
		}
		return foo;
	}

	private int translateIndex ( int i )
	{
		if ( i == 0 )
		{
			return 0;
		}
		return i*2;
	}

	public String toString()
	{
		return renderableWord;
	}

}
