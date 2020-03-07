/**
 * ReadByChar - creates an array of all the characters from a text file
 * To do: make it so the function takes an input of a file... currently too tired to bother
 * @author Edward Nokes
 */
import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadByChar
{
    public char[] ReadChars() throws java.io.IOException
    {
        byte[] bytes = new byte[33];
        char c;
        int i=0;
        char charArray[] = new char[33];
        try {
            InputStream f = new FileInputStream("board1.txt");   
            f.read(bytes);
            for(byte b:bytes) {   
                c = (char)b;
                charArray[i] = c;

                i++;
            }
            f.close();
        }
        catch(IOException ioex) {
            System.out.println(ioex.toString());
        }
        return charArray;
    }
}