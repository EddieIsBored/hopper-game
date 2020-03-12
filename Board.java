/**
 * Board - Sets up the GUI of the game
 * @author Edward Nokes
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Board implements ActionListener
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();
    JButton[][] bArr = new JButton[5][5];
    Square[][] sqArr = new Square[5][5];

    public Board() throws IOException
    {
        int k = 2;
        
        panel.setLayout(new GridLayout(5,5));
        frame.setSize(750,750); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) {
                sqArr[i][j] = new Square(i,j,character.ReadChars(k));
                bArr[i][j] = sqArr[i][j].createButton(character.ReadChars(k));
                if ((k+1)%7 == 0){
                    k += 2;
                }
                k++; 
                bArr[i][j].addActionListener(this);
                panel.add(bArr[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

    }
}

