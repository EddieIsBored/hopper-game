
/**
 * Square - determines the position of the square
 * @author Edward Nokes
 */
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class Square extends JButton
{
    private static final long serialVersionUID = -8172349124212470880L; //THIS STOPS VSCODE FROM SHOUTING AT ME
    private int row;
    private int column;
    private char type;
    private Boolean isRedFrog=false;
    private Boolean hasFrog;

    private static ImageIcon water = new ImageIcon("images/Water.png");
    private static ImageIcon lilypad = new ImageIcon("images/LilyPad.png");
    static ImageIcon greenFrog = new ImageIcon("images/GreenFrog.png");
    static ImageIcon redFrog = new ImageIcon("images/RedFrog.png");
    static ImageIcon redFrogS = new ImageIcon("images/RedFrog2.png");
    static ImageIcon greenFrogS = new ImageIcon("images/GreenFrog2.png");

    /**
     * Defines a square on the board
     * @param i The row of the square
     * @param j The column of the square
     * @param type The type of the square, L is lilypad, G is the green frog, R is the red frog, default is water
     */

    Square(int i, int j, char type){
        this.row = i; //stores row
        this.column = j; //stores column
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
                Board.greenFrogTotal++; //used to track how many frogs there are
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
        //must get all the properties of the previous square, and the properties of the new square it will be moving to.
        int fromRow = getRow();
        int fromCol = getColumn();
        int toRow = newSquare.getRow();
        int toCol = newSquare.getColumn();
        Icon oldIcon = getIcon();
        Icon newIcon = newSquare.getIcon();
        int middleRow = (fromRow + toRow)/2;
        int middleColumn = (fromCol + toCol)/2;
        Boolean isRedFrog = isRedFrog();

        if(validMove(fromRow,fromCol,toRow,toCol) == true){
            if(Board.sqArr[middleRow][middleColumn].hasFrog() && Board.sqArr[middleRow][middleColumn].isRedFrog() == false){ //For a jump to be valid, there must be a frog inbetween it and that frog cannot be red.
                Board.sqArr[middleRow][middleColumn].hasFrog = false; //the frog is removed
                Board.sqArr[middleRow][middleColumn].setIcon(lilypad); 
                Board.greenFrogTotal--; //total frogs be gone
                this.hasFrog = false; //when the frog movies, the frog is gone
                this.isRedFrog = false; //also cannot be the red frog
                newSquare.hasFrog = true; //the frog can only move from 
                if(isRedFrog){
                    newSquare.isRedFrog = true; //if the frog is red originally, it must be red now!
                }
                newSquare.setIcon(oldIcon); 
                setIcon(newIcon);
            }
        }
    }

    public Boolean validMove(int r1, int c1, int r2, int c2){
        if(r1 - r2 == 0){ //Moves of 4 can only be made in the same row or column
            if(Math.abs(c1 - c2) == 4){ //Checks that the move is 4 spaces
                return true;
            }
        }
        if(c1 - c2 == 0){ //Moves of 4 can only be made in the same row or column
            if(Math.abs(r1 - r2) == 4){ //Checks that the move is 4 spaces
                return true;
            }
        }
        if(Math.abs(c1 - c2) == 2){ //has to move 2 vertically
            if(Math.abs(r1 - r2) == 2){ //has to move 2 horizontally to move diagonally 
                return true; //both of these must be true to make a move.
            }
        }
        return false; //else, return false
    }

    /**
     * Returns the current row of the Square
     * @return integer, row
     */
    public int getRow(){
        return row;
    }
    /**
     * Returns the current column of the Square
     * @return integer, column
     */
    public int getColumn(){
        return column;
    }
    /**
     * Returns if the Square has a frog
     * @return boolean, hasFrog
     */
    public Boolean hasFrog(){
        return hasFrog;
    }
    /**
     * Returns if the frog is red or not
     * @return boolean, isRedFrog
     */
    public Boolean isRedFrog(){
        return isRedFrog;
    }
    /**
     * Returns the type of tile, e.g. W = Water, L = Lilypad
     * @return character, type
     */
    public char getType(){
        return type;
    }
}