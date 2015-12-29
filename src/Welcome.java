import javax.swing.*;
import java.awt.*;

/**
 * Created by Julia on 16.12.2015.
 */
public class Welcome extends JPanel {

    JPanel panel = new JPanel();
    final JLabel forText2 = new JLabel();
    final TextField textField1 = new TextField(25);
    final JPanel panelForButtons = new JPanel();
    final JButton play = new JButton("Играть");
    final JButton specificationWelcome = new JButton("Правила");

    public Welcome() {

      //  panel.setSize(new Dimension(206, 206));

        panel.setLayout(new BorderLayout());

        forText2.setText("Введите свой ник:");

        panel.add(forText2, BorderLayout.NORTH);
        panel.add(textField1, BorderLayout.CENTER);
        panel.add(panelForButtons, BorderLayout.SOUTH);

        panelForButtons.add(play);
        panelForButtons.add(specificationWelcome);

        this.add(panel);
    }
}