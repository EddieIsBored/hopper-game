/**
 * GUI - Sets up the GUI of the game
 * @author Edward Nokes
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI 
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();
    
    public GUI() {
        panel.setLayout(new GridLayout(5,5));
        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int k = 2;

        JButton[][] arr = new JButton[5][5];

        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) { 
                arr[i][j] = new JButton(" R" + i + " C" + j);
                try{
                    if (k%7 == 0){
                        k = k+2;
                    }
                    System.out.print(character.ReadChars(k));
                }
                catch(IOException ioex){
                    System.out.println (ioex.toString());
                }
                k++;
                panel.add(arr[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}