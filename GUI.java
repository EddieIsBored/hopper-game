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

        JButton[][] arr = new JButton[5][5];

        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < 5; j++) { 
                arr[i][j] = new JButton(" R" + i + " C" + j);
                panel.add(arr[i][j]);
            }
        }

        frame.add(panel, BorderLayout.CENTER);
    }
}