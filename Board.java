/**
 * Board - Sets up the GUI of the game
 * @author Edward Nokes
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.*;

public class Board
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();

    public Board() throws IOException
    {
        Image water = ImageIO.read(getClass().getResource("/images/Water.png"));
        Image lilypad = ImageIO.read(getClass().getResource("/images/LilyPad.png"));
        Image redFrog = ImageIO.read(getClass().getResource("/images/RedFrog.png"));
        Image greenFrog = ImageIO.read(getClass().getResource("/images/GreenFrog.png"));

        JButton[][] arr = new JButton[5][5];

        int k = 2;

        panel.setLayout(new GridLayout(5,5));
        frame.setSize(750,750); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) { 
                arr[i][j] = new JButton(new ImageIcon(water));
                    if (k%7 == 0){
                        k = k+2;
                    }
                    character.ReadChars(k);
                k++;
                panel.add(arr[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}