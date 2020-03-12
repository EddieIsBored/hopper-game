/**
 * Square - determines the position of the square
 * @author Edward Nokes
 */

import javax.swing.*;
import java.io.IOException;

public class Square
{
    private int row;
    private int column;
    private boolean hasFrog;
    private boolean isRedFrog;

    Square(int i, int j, char type){
        row = i;
        column = j;
        switch(type){
            case 'L':
                hasFrog = false;
            case 'G':
                hasFrog = true;
            case 'R':
                hasFrog = true;
                isRedFrog = true;
        }
    }

    public JButton createButton(char type) throws IOException{
        switch(type){
            case 'L':
                return new JButton(new ImageIcon("images/LilyPad.png"));
            case 'G':
                return new JButton(new ImageIcon("images/GreenFrog.png"));
            case 'R':
                return new JButton(new ImageIcon("images/RedFrog.png"));
            default:
                return new JButton(new ImageIcon("images/Water.png"));
        }
    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public boolean hasFrog(){
        return hasFrog;
    }
    public boolean isRedFrog(){
        return isRedFrog;
    }
}