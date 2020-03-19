/**
 * Board - Sets up the GUI of the game
 * @author Edward Nokes
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;

public class Board
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private ReadByChar character = new ReadByChar();
    static Square[][] sqArr = new Square[5][5];
    static int greenFrogTotal = 0;

    /**
     * This is the method for creating the 5x5 board
     * @throws IOException
     */
    public Board() throws IOException
    {
        int k = 2;
        panel.setLayout(new GridLayout(5,5)); 
        frame.setSize(750,750); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setting up a 5x5 window
        
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) {
                sqArr[i][j] = new Square(i,j,character.ReadChars(k));
                if ((k+1)%7 == 0){ 
                    k += 2; //this part is to make sure that the correct character in the file is read
                }
                sqArr[i][j].addActionListener(l); //adds actionlistener to find out which button was pressed
                k++; 
                panel.add(sqArr[i][j]); //addings all the buttons to the window!
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    Square square1 = null;
    Square square2 = null;
    ActionListener l = new ActionListener(){ //listens for buttons pushed
        public void actionPerformed(ActionEvent e){
            if(!(e.getSource() instanceof Square)){
                return;
            }
            if(greenFrogTotal == 0){ //if all green frogs are gone, the game is over!
                JOptionPane.showMessageDialog(frame, "YOU'VE WON!");
                return;
            }
            if(square1 == null){//e.g no first square has been selected.
                square1 = (Square)e.getSource(); //casts the ActionEvent source to a Square object.
                if(square1.hasFrog() == false){ //if it's not a frog, you can't move it.
                    square1 = null; //reset and return
                    return;
                }

                if(square1.isRedFrog()){
                    square1.setIcon(Square.redFrogS);
                }

                else{
                    square1.setIcon(Square.greenFrogS);
                }
                //selecting the icon
            }
            else{ 
                square2 = (Square)e.getSource(); //gets the second square to move to
                if(square2.hasFrog()){  //you're not allowed to move to a frog!
                    if(square1.isRedFrog()){
                        square1.setIcon(Square.redFrog); //resets the icon to the original
                    }
                    else{
                        square1.setIcon(Square.greenFrog); //resets the icon
                    }
                    square2 = null; //resets the pressed buttons
                    square1 = null;
                    return;
                }

                if(square1.isRedFrog()){
                    square1.setIcon(Square.redFrog); //a sneaky swap to the original icon to make it easier to swap icons
                }
                else{
                    square1.setIcon(Square.greenFrog); //a sneaky swap to the original icon to make it easier to swap icons
                }
                square1.moveTo(square2); //moves the icon and properties of square1 to square2.
                square1 = null; //resets
            }

        }
    };
}