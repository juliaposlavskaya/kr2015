import javax.swing.*;
import java.awt.*;

/**
 * Created by Julia on 16.12.2015.
 */
public class Welcome extends JFrame {

    JPanel welcomePanel = new JPanel();
    JPanel panel = new JPanel();
    final JLabel forText2 = new JLabel();
    final TextField textField1 = new TextField(35);
    final JButton play = new JButton("Играть");
    Toolkit kit;
    Image img;

    public Welcome() {
        welcomePanel = (JPanel) this.getContentPane();
        welcomePanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());

        this.setTitle("15");

        kit = Toolkit.getDefaultToolkit();
        img = kit.getImage("caticon.png");
        this.setIconImage(img);


        forText2.setText("Введите свой ник:");

        textField1.setMaximumSize(new Dimension(40, 25));


        panel.add(forText2, BorderLayout.NORTH);
        panel.add(textField1, BorderLayout.CENTER);
        panel.add(play, BorderLayout.SOUTH);

        welcomePanel.add(panel, BorderLayout.CENTER);
        this.setResizable(false);



    }
}
