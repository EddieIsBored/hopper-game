/**
 * ReadByChar - method to find a specific character in a text file
 * To do: make it so the function takes an input of a file... currently too tired to bother
 * @author Edward Nokes
 */
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class ReadByChar
{
    /**
     * Description - 
     * @param j The offset of the character to be found in the text file.
     * @return Returns a character
     * @throws java.io.IOException When file not found
     */

    public char ReadChars(int j) throws IOException
    {
        byte[] bytes = new byte[64];
        char c = 'a';
        try {
            InputStream f = new FileInputStream("boards/board" + Main.level + ".hop");   //loads the level
            f.read(bytes);  //stores the read file into the array bytes.
            c = (char)(bytes[j]); //finds the character c in the file with an offset of j
            f.close(); 
        }
        catch(IOException ioex) {
            System.out.println(ioex.toString());
        }
        return c;
    }
}