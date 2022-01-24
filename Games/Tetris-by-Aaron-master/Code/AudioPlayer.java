import pkg.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class AudioPlayer 
{
	private long clipTimePosition;
	private Clip clip;
	
	public void play(String filepath) 
	{
		
		try 
		{
			File musicPath = new File(filepath);
			
			//DO NOT CHANGE THIS PIECE OF CODE!!!
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			// if(filepath.equals("results.wav"))
			// {
				// clip.setMicrosecondPosition(100000);
				// System.out.println(clip.getMicrosecondPosition());
			// }
			
			//Loops audio forever.
			// System.out.println("Type, loop, to loop audio");
			// EasyReader joey = new EasyReader();
			// String ivan = joey.readWord();
			// if(ivan.equals("loop")) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
			// }
			
			//Asks user to pause and resume audio.
			// while(true) {
				// Pause and Resume audio
				// System.out.println("Type, p, to pause audio");
				// EasyReader jack = new EasyReader();
				// String mark = jack.readWord();
				// if(mark.equals("p") || mark.equals("P")) {
					// clipTimePosition = clip.getMicrosecondPosition();
					// clip.stop();
				// }
				
				// Resume audio
				// System.out.println("Type, r, to resume audio");
				// EasyReader joe = new EasyReader();
				// String jerry = joe.readWord();
				// if(jerry.equals("r") || jerry.equals("R")) {
					// clip.start();  
					// clip.setMicrosecondPosition(clipTimePosition);
				// }
			// }
			
			//JOptionPane.showMessageDialog(null, "Press OK to stop playing the audio.");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void pause(){
		clip.stop();
	}
}


