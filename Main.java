/**
 * Main - Entrypoint to program
 * @author Edward Nokes
 */
import java.io.*;
import javax.swing.JOptionPane;

public class Main
{
    static String level;
    /**
     * Entrypoint - Begins running the game
     * @param args arguments passed to program
     */
    public static void main(final String[] args){

        level = JOptionPane.showInputDialog("Pick a level between 1 and 40!");
        if(Integer.parseInt(level) > 40 || Integer.parseInt(level) <= 0){
            System.out.println("INVALID LEVEL!!!");
            return;
        }
        try{
            final Board game = new Board();
        }
        catch(IOException ioex){
            System.out.println (ioex.toString());
        }
    }
}