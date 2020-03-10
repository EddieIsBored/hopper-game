/**
 * Main - Entrypoint to program
 * @author Edward Nokes
 */
import java.io.*;
public class Main
{
    /**
     * Entrypoint - Begins running the game
     * @param args arguments passed to program
     */
    public static void main(final String[] args)
    {
        try{
            final Board game = new Board();
        }
        catch(IOException ioex){
            System.out.println (ioex.toString());
        }
    }
}