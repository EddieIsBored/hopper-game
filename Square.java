/**
 * Square - determines the position of the square
 * @author Edward Nokes
 */

import javax.swing.*;

public class Square extends JButton
{
    private int row;
    private int column;
    private char type;
    private boolean hasFrog;
    private boolean isRedFrog;
    private boolean selected=false;
    private boolean sSelected=false;

    ImageIcon water = new ImageIcon("images/Water.png");
    ImageIcon lilypad = new ImageIcon("images/LilyPad.png");
    ImageIcon greenFrog = new ImageIcon("images/GreenFrog.png");
    ImageIcon redFrog = new ImageIcon("images/RedFrog.png");
    ImageIcon greenFrogS = new ImageIcon("images/GreenFrog2.png");
    ImageIcon redFrogS = new ImageIcon("images/RedFrog2.png");

    /**
     * Defines a square on the board
     * @param i The row of the square
     * @param j The column of the square
     * @param type The type of the square, L is lilypad, G is the green frog, R is the red frog, default is water
     */

    Square(int i, int j, char type){
        row = i;
        column = j;
        System.out.print(type);
        switch(type){
            case 'L':
                hasFrog = false;
                type = 'L';
                setIcon(lilypad);
                break;
            case 'G':
                hasFrog = true;
                type = 'G';
                setIcon(greenFrog);
                break;
            case 'R':
                hasFrog = true;
                isRedFrog = true;
                type = 'R';
                setIcon(redFrog);
                break;
            default:
                hasFrog = false;
                type = 'W';
                setIcon(water);
        }
    }
    /**
     * Swaps a square to the Square input as 
     * @param x The square the original Square will move to.
     */

    public void moveTo(Square x){
        Icon oldIcon = getIcon();
        Icon newIcon = x.getIcon();
        x.setIcon(oldIcon);
        setIcon(newIcon);
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