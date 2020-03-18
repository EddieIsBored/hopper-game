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
    private Boolean isRedFrog;
    private Boolean hasFrog;

    private static ImageIcon water = new ImageIcon("images/Water.png");
    private static ImageIcon lilypad = new ImageIcon("images/LilyPad.png");
    private static ImageIcon greenFrog = new ImageIcon("images/GreenFrog.png");
    private static ImageIcon redFrog = new ImageIcon("images/RedFrog.png");
    private static ImageIcon redFrogS = new ImageIcon("images/RedFrog2.png");
    private static ImageIcon greenFrogS = new ImageIcon("images/GreenFrog2.png");


    /**
     * Defines a square on the board
     * @param i The row of the square
     * @param j The column of the square
     * @param type The type of the square, L is lilypad, G is the green frog, R is the red frog, default is water
     */

    Square(int i, int j, char type){
        this.row = i;
        this.column = j;
        switch(type){
            case 'L':
                this.hasFrog = false;
                this.type = 'L';
                setIcon(lilypad);
                break;
            case 'G':
                this.hasFrog = true;
                this.type = 'G';
                setIcon(greenFrog);
                break;
            case 'R':
                this.hasFrog = true;
                this.isRedFrog = true;
                this.type = 'R';
                setIcon(redFrog);
                break;
            default:
                this.hasFrog = false;
                this.type = 'W';
                setIcon(water);
        }
    }
    /**
     * Swaps a square to the Square input as 
     * @param newSquare The square the original Square will move to.
     */

    public void moveTo(Square newSquare){
        int fromRow = getRow();
        int fromCol = getColumn();
        int toRow = newSquare.getRow();
        int toCol = newSquare.getColumn();
        Icon oldIcon = getIcon();
        Icon newIcon = newSquare.getIcon();

        if(validMove(fromRow,fromCol,toRow,toCol) == true){
            this.hasFrog = false;
            newSquare.hasFrog = true;
            newSquare.setIcon(oldIcon);
            setIcon(newIcon);
        }
    }

    public Boolean validMove(int r1, int c1, int r2, int c2){
        if(r1 - r2 == 0){
            if(Math.abs(c1 - c2) == 4){
                return true;
            }
        }
        if(c1 - c2 == 0){
            if(Math.abs(r1 - r2) == 4){
                return true;
            }
        }
        if(Math.abs(c1 - c2) == 2){
            if(Math.abs(r1 - r2) == 2){
                return true;
            }
        }
        return false;
    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public Boolean hasFrog(){
        return hasFrog;
    }
    public Boolean isRedFrog(){
        return isRedFrog;
    }
    public char getType(){
        return type;
    }
}