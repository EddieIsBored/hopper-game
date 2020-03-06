import javax.swing.*;
import java.awt.*;

public class GUI 
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public GUI()
    {
        panel.setLayout(new GridLayout(5,5));
        frame.setVisible(true);
        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}