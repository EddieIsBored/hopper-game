/**
 * Board - Sets up the GUI of the game
 * @author Edward Nokes
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Board
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();
    private Square tile = new Square();

    public Board() throws IOException
    {
        JButton[][] arr = new JButton[5][5];

        int k = 2;

        panel.setLayout(new GridLayout(5,5));
        frame.setSize(750,750); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) { 
                arr[i][j] = tile.createSquare(i, j, character.ReadChars(k));

                if (k%7 == 0){
                    k = k+2;
                }
                k++;
                panel.add(arr[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}