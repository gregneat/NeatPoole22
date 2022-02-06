import java.util.ArrayList;

public class Wordle 
{
	MysteryWord bob;
	int wordLen;
	String answer;
		
	public Wordle(String[] words)
	{
		wordLen = (int)(Math.random()*words.length);
		answer = words[wordLen];
		// System.out.println(answer);
		bob = new MysteryWord(words[wordLen]);
	}
	
	public void play()
	{
		String guessHint;
		EasyReader joeIn = new EasyReader();
		System.out.print("\n\nPlease enter your first guess (all caps) \n for a word that has "+ answer.length() +" letters: ");
		String stringGuess = joeIn.readWord();
		guessHint = bob.getHint(stringGuess);
		while(!guessHint.equals(answer))
		{
			System.out.println(stringGuess);
			System.out.println(guessHint);
			System.out.println("Please enter your next guess: ");
			stringGuess = joeIn.readWord();
			guessHint = bob.getHint(stringGuess);
		}
		System.out.println("Congrats, you won!");
	}
			
	public String toString()
	{
		return "The chosen word is: "+answer;
	}		
} 



