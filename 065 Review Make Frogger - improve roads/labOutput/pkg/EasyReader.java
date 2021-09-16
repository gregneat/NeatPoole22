package pkg;
import java.io.*;

/**
 *  @author Gary Litvin
 *  @version 1.2, 5/30/02
 *  @Edited Richard Cho
 *
 *  Written as part of
 *
 *  <i>Java Methods: An Introduction to Object-Oriented Programming</i>
 *  (Skylight Publishing 2001, ISBN 0-9654853-7-4)
 *
 *   and
 *
 *  <i>Java Methods AB: Data Structures</i>
 *  (Skylight Publishing 2003, ISBN 0-9654853-1-5)
 *
 *  EasyReader provides simple methods for reading the console and
 *  for opening and reading text files.  All exceptions are handled
 *  inside the class and are hidden from the user.
 *
 *  <xmp>
 *  Example:
 *  =======
 *
 *  EasyReader console = new EasyReader();
 *  System.out.print("Enter input file name: ");
 *  String fileName = console.readLine();
 *
 *  EasyReader inFile = new EasyReader(fileName);
 *  if (inFile.bad())
 *  {
 *    System.err.println("Can't open " + fileName);
 *    System.exit(1);
 *  }
 *
 *  String firstLine = inFile.readLine();
 *  if (!inFile.eof())   // or:  if (firstLine != null)
 *    System.out.println("The first line is : " + firstLine);
 *
 *  System.out.print("Enter the maximum number of integers to read: ");
 *  int maxCount = console.readInt();
 *  int k, count = 0;
 *
 *  while (count < maxCount && !inFile.eof())
 *  {
 *    k = inFile.readInt();
 *    if (!inFile.eof())
 *    {
 *      // process or store this number
 *      count++;
 *    }
 *  }
 *
 *  inFile.close();    // optional
 *  System.out.println(count + " numbers read");
 *  </xmp>
 *
 */

public class EasyReader
{
	protected String myFileName;
	protected BufferedReader myInFile;
	protected int myErrorFlags = 0;
	protected static final int OPENERROR = 0x0001;
	protected static final int CLOSEERROR = 0x0002;
	protected static final int READERROR = 0x0004;
	protected static final int EOF = 0x0100;

	/**
	*  Constructor.  Prepares console (System.in) for reading
	*/
	public EasyReader()
	{
		myFileName = null;
		myErrorFlags = 0;
		myInFile = new BufferedReader(new InputStreamReader(System.in), 128);
	}

	/**
	*  Constructor.  opens a file for reading
	*  @param fileName the name or pathname of the file
	*/
	public EasyReader(String fileName)
	{
		myFileName = fileName;
		myErrorFlags = 0;
		try
		{
			myInFile = new BufferedReader(new FileReader(fileName), 1024);
		}
		catch (FileNotFoundException e)
		{
			myErrorFlags |= OPENERROR;
			myErrorFlags |= EOF;
			myFileName = null;
		}
	}

	/**
	*  Closes the file
	*/
	public void close()
	{
		if (myFileName == null)
		{
			return;
		}
		
		try
		{
			myInFile.close();
		}
		catch (IOException e)
		{
			System.err.println("Error closing " + myFileName + "\n");
			myErrorFlags |= CLOSEERROR;
		}
	}

	/**
	*  Checks the status of the file
	*  @return true if en error occurred opening or reading the file,
	*  false otherwise
	*/
	public boolean bad()
	{
		return myErrorFlags != 0;
	}
	
	public boolean good()
	{
		return !this.bad();
	}

	/**
	*  Checks the EOF status of the file
	*  @return true if next read is EOF
	*/
	public boolean eof()
	{
		if(myFileName != null)
		{
			try
			{
				if(!myInFile.ready())
				{
					myErrorFlags |= EOF;
				}
			}
			catch(IOException E)
			{
				myErrorFlags |= READERROR;
			}
		}

		return (myErrorFlags & EOF) != 0;
	}

	private boolean ready() throws IOException
	{
		return myFileName == null || myInFile.ready();
	}

	/**
	*  Reads the next character from a file (any character including
	*  a space or a newline character).
	*  @return character read or <code>null</code> character
	*  (Unicode 0) if trying to read beyond the EOF
	*/
	public Character readChar()
	{
		Character ch = null;
		try
		{
			if (ready())
			{
				ch = (char)myInFile.read();
			}

			//flush console input stream
			if(myFileName == null)
			{
				myInFile.readLine();
			}
		}
		catch (IOException e)
		{
			if (myFileName != null)
			{
				System.err.println("Error reading " + myFileName + "\n");
			}
			
			myErrorFlags |= READERROR;
		}

		if (ch == null)
		{
			myErrorFlags |= EOF;
		}

		return ch;
	}

	/**
	*  Reads from the current position in the file up to and including
	*  the next newline character.  The newline character is thrown away
	*  @return the read string (excluding the newline character) or
	*  null if trying to read beyond the EOF
	*/
	public String readLine()
	{
		String s = null;
		
		try
		{
			s = myInFile.readLine();
		}
		catch (IOException e)
		{
			if (myFileName != null)
			{
				System.err.println("Error reading " + myFileName + "\n");
			}
			myErrorFlags |= READERROR;
		}

		if (s == null)
		{
			myErrorFlags |= EOF;
		}
		
		return s;
	}

	/**
	*  Skips whitespace and reads the next word (a string of consecutive
	*  non-whitespace characters (up to but excluding the next space,
	*  newline, etc.)
	*  @return the read string or null if trying to read beyond the EOF or '\u0000' (null character) if reading whitespace at end of file
	*/
	public String readWord()
	{
		StringBuffer buffer = new StringBuffer(128);
		char ch = ' ';
		int count = 0;
		String s = null;
		boolean hasread = false;
		try
		{
			if(ready())
			{
				hasread = true;
			}
			
			while (ready() && Character.isWhitespace(ch))
			{
				ch = (char)myInFile.read();
			}
			
			//add first non-whitespace character
			if(!Character.isWhitespace(ch))
			{
				buffer.append(ch);
				count++;
				myInFile.mark(1);
			}
			
			//add rest of input stream chars to word
			while(ready() && !Character.isWhitespace(ch))
			{
				ch = (char)myInFile.read();
				if(!Character.isWhitespace(ch))
				{
					buffer.append(ch);
					myInFile.mark(1);
				}
				
				count++;
			}
			
			if (count > 0)
			{
				myInFile.reset();
				s = buffer.toString();
				
				//flush console input stream
				if(myFileName == null)
				{
					myInFile.readLine();
				}
			}
			else
			{
				if(hasread)
				{
					s = "" + '\u0000';
				}
				else
				{
					myErrorFlags |= EOF;
				}
			}
		}
		catch (IOException e)
		{
			if (myFileName != null)
			{
				System.err.println("Error reading " + myFileName + "\n");
			}
			
			myErrorFlags |= READERROR;
		}
		
		
		return s;
	}

	/**
	*  Reads the next integer. null if EOF or invalid format
	*/
	public Integer readInt()
	{
		String s = readWord();
		try
		{
			if (s != null)
			{
				return Integer.parseInt(s);
			}
			
			else
			{
				return null;
			}
		}
		catch(NumberFormatException E)
		{
			return null;
		}
	}

  /**
   *  Reads the next double null if EOF or invalid format
   */
	public Double readDouble()
	{
		String s = readWord();
		try
		{
			if (s != null)
			{
				return Double.parseDouble(s);
			}
			  // in Java 1, use: return Double.valueOf(s).doubleValue();
			else
			{
				return null;
			}
		}
		catch(NumberFormatException E)
		{
			return null;
		}
	}
}

