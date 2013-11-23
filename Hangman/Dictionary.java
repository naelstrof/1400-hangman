import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary
{
	ArrayList<String> words;
	public Dictionary( String dir )
	{
		// Create an empty array list
		words = new ArrayList<>();
		BufferedReader reader;
		// This tries to read the given file (dir) via a buffered reader.
		try
		{
			reader = new BufferedReader( new FileReader( dir ) );
		}
        catch ( FileNotFoundException ex )
		{
			// If the file wasn't found, just catch the exception immediately.
			// I don't want our main code covered in try and catch statements due to
			// the coding convention making them incredibly spacious.
			System.out.printf( "Couldn't find file %s! This is a fatal error!\n", dir );
			return;
		}
		String line = null;
		try
		{
			// Now make the reader grab a new line, once the line is null we have ran out of lines to go through.
			while ( ( line = reader.readLine() ) != null )
			{
				// Make sure there's no capitals in the word.
				if ( line.compareTo( line.toLowerCase() ) != 0 )
				{
					continue;
				}
				// Make sure there's no ' in the word either.
				if ( line.contains( "\'" ) == true )
				{
					continue;
				}
				// Add the word to our list of words.
				words.add( line );
			}
		}
        catch ( IOException ex )
		{
			// If we couldn't open the file for somereason, just print an error and stop.
			System.out.printf( "Couldn't open file %s! This is a fatal error!\n", dir );
			return;
		}
	}
	// Just grabs a random word from our loaded dictionary.
	public String getRandomWord()
	{
		int rand = (int) ( Math.round( Math.random() * words.size() ) - 1 );
		return words.get( rand );
	}
}
