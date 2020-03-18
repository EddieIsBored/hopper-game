/**
 * Board - Sets up the GUI of the game
 * @author Edward Nokes
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Board
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();
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
                if ((k+1)%7 == 0){
                    k += 2;
                }
                sqArr[i][j].addActionListener(l);
                k++; 
                panel.add(sqArr[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    Square square1 = null;
    Square square2 = null;

    // ImageIcon greenFrogS = new ImageIcon("images/GreenFrog2.png");
    // ImageIcon greenFrog = new ImageIcon("images/GreenFrog.png");
    // ImageIcon redFrog = new ImageIcon("images/RedFrog.png");
    // ImageIcon redFrogS = new ImageIcon("images/RedFrog2.png");

    ActionListener l = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if(!(e.getSource() instanceof Square)){
                return;
            }
            if(square1 == null){
                square1 = (Square)e.getSource();
                if(square1.hasFrog() == false){
                    square1 = null;
                    return;
                }
            }
            else{ 
                square2 = (Square)e.getSource();
                if(square2.hasFrog() == true){
                    square2 = null;
                    return;
                }
                square1.moveTo(square2);
                square1 = null;
            }

        }
    };
}