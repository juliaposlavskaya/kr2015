import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Julia on 27.12.2015.
 */
public class RecordsGame extends JPanel {

    private static final String path = "records.txt";
    private static InputOutputStream streamExam;

    public ArrayList<ResultsTable> resultsTable = new ArrayList<>();

    final JPanel panel = new JPanel(); //основная панель
    final JPanel panel2 = new JPanel();
    JTextArea textArea = new JTextArea(); //для списка рекордов
    JLabel forText = new JLabel();
    JButton okayButton = new JButton();

    public RecordsGame(){

        streamExam = new InputOutputStream(path);

        //расположение на панели
        panel.setLayout(new BorderLayout());

        forText.setText("Таблица рекордов: ");

        textArea.setText("просто текст");

        panel.add(forText, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);

        panel2.add(okayButton);

        textArea.setEditable(false);


        this.add(panel);
    }


}
