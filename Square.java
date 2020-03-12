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
    private boolean selected=false;

    ImageIcon water = new ImageIcon("images/Water.png");
    ImageIcon lilypad = new ImageIcon("images/LilyPad.png");
    ImageIcon greenFrog = new ImageIcon("images/GreenFrog.png");
    ImageIcon redFrog = new ImageIcon("images/RedFrog.png");
    ImageIcon greenFrogS = new ImageIcon("images/GreenFrog2.png");
    ImageIcon redFrogS = new ImageIcon("images/RedFrog2.png");

    Square(int i, int j, char type){
        row = i;
        column = j;
        System.out.print(type);
        switch(type){
            case 'L':
                hasFrog = false;
                break;
            case 'G':
                hasFrog = true;
                break;
            case 'R':
                hasFrog = true;
                isRedFrog = true;
                break;
            default:
                hasFrog = false;
        }
    }

    public void modifyButton(JButton x, Square y){
        if (y.hasFrog() == true && y.isRedFrog() == false){
            x.setIcon(greenFrogS);
            selected = true;
        }
        if (y.hasFrog() == true && y.isRedFrog() == true){
            x.setIcon(redFrogS);
            selected = true;
        }
    }

    public JButton createButton(char type) throws IOException{
        switch(type){
            case 'L':
                return new JButton(lilypad);
            case 'G':
                return new JButton(greenFrog);
            case 'R':
                return new JButton(redFrog);
            default:
                return new JButton(water);
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
    public boolean selected(){
        return selected;
    }
}