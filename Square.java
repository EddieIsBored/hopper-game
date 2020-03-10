/**
 * Square - determines the position of the square
 * @author Edward Nokes
 */

import javax.swing.*;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

import java.awt.*;
import java.io.IOException;
import javax.imageio.*;

public class Square
{
    private int row;
    private int column;
    private boolean hasFrog;
    private boolean isRedFrog;

    public JButton createSquare(int i, int j, char type) throws IOException{
        row = i;
        column = j;
        switch(type){
            case 'L':
                hasFrog = false;
                return new JButton(new ImageIcon("images/LilyPad.png"));
            case 'G':
                hasFrog = true;
                return new JButton(new ImageIcon("images/GreenFrog.png"));
            case 'R':
                hasFrog = true;
                isRedFrog = true;
                return new JButton(new ImageIcon("images/RedFrog.png"));
            default:
                return new JButton(new ImageIcon("images/Water.png"));
        }
    }
    public int getRow(Square x){
        return row;
    }
    public int getColumn(Square x){
        return column;
    }
    public boolean hasFrog(Square x){
        return hasFrog;
    }
    public boolean isRedFrog(Square x){
        return isRedFrog;
    }
}