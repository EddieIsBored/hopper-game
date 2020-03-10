/**
 * Square - determines the position of the square
 * @author Edward Nokes
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.*;

public class Square
{
    private int row;
    private int column;
    private boolean hasFrog;
    private boolean isRedFrog;

    public JButton createSquare(int y, int x, char type) throws IOException{
        Image water = ImageIO.read(getClass().getResource("/images/Water.png"));
        Image lilypad = ImageIO.read(getClass().getResource("/images/LilyPad.png"));
        Image redFrog = ImageIO.read(getClass().getResource("/images/RedFrog.png"));
        Image greenFrog = ImageIO.read(getClass().getResource("/images/GreenFrog.png"));
        row = y;
        column = x;
        return new JButton(new ImageIcon(water));
    }
}