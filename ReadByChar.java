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
    public char ReadChars(int j) throws java.io.IOException
    {
        byte[] bytes = new byte[40];
        char c = 'a';
        try {
            InputStream f = new FileInputStream("board1.txt");   
            f.read(bytes);
            c = (char)(bytes[j]);
            f.close();
        }
        catch(IOException ioex) {
            System.out.println(ioex.toString());
        }
        return c;
    }
}