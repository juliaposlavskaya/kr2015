import javax.swing.*;
import java.awt.*;

/**
 * Created by Julia on 11.12.2015.
 */
public class Action extends JFrame {


    JPanel contentPanel = new JPanel();;
    final JPanel gamePanel = new JPanel();
    final JButton[][] buttons = new JButton[4][4];   //массив кнопочек
    final int[][] matrix = new int[4][4];    //матрица для хранения чисел
    Toolkit kit;
    Image img;


   //создаем рамку
    public Action()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try
        {
            initializationFrame();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    private void initializationFrame() throws Exception {
        contentPanel = (JPanel) this.getContentPane();
        contentPanel.setLayout(new BorderLayout());
        this.setSize(new Dimension(206, 275));
        this.setTitle("15");

        kit = Toolkit.getDefaultToolkit();
        img = kit.getImage("caticon.png");
        this.setIconImage(img);

        this.setResizable(false); //запрещаем изменение размера окна

        gamePanel.setLayout(null);

        // добавляем кнопочки
        int count = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton("" + count);
                buttons[i][j].setSize(50, 50);
                buttons[i][j].setLocation(50 * j, 50 * i);
                gamePanel.add(buttons[i][j]);
                matrix[i][j] = count; //задаем матрицу
                count++;
            }
        buttons[0][0].setText(" "); //будет несуществующей, чтобы двигать кнопочки


        //Добавляем на основную панель
        contentPanel.add(gamePanel, BorderLayout.CENTER);
    }
}
