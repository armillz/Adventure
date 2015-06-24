import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {

	public static final int line_width = 45;

	/***
	 * println - print a message in the game, similar to System.out.println
	 * @param s
	 */
	public static void println(String s) { System.out.println(s); }
	
	/***
	 * message - display a message in the game and wrap long lines
	 * @param m
	 */
	public static void message(String m) {
		println(m);
	}
			
	public static void wrapMessage(String m) {

		// TODO: Debug this and figure out why it crashes on different string lengths.
		
		if (m.length() <= line_width) {
			println(m);
		} else {
			// string is longer than line width
			
			// loop through the long message string, looking for spaces
			// where we can split the line.
			int start = 0;  // beginning portion of string to print
			int pos = line_width; // current 'break' position for end of line
			while (pos < m.length()) {
				// the end position is still less than the string length, so loop from
				// here until we find a space.
				while (pos < m.length() && m.charAt(pos) != ' ') {
					pos++;
				}	
				if (m.charAt(pos) == ' ') pos++; // advance past the current space
				println(m.substring(start,pos));
				// advance to next line
				start = pos;
				pos += line_width;
			}
			println(m.substring(start, m.length()));
		}
	
	}

	/***
	 * Prompt the user for input and return whatever string they input
	 * @param prompt
	 * @return
	 * @throws IOException
	 */
	public static String readInput(String prompt) throws IOException {
		String s = null;
		System.out.print(prompt + " ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine();

		} catch(IOException ioe) {
			System.err.println("Unable to read input");	
			ioe.printStackTrace();
			throw ioe; // exit program
		}
		return s;

	}
}
