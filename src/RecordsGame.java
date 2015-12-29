import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Julia on 27.12.2015.
 */
public class RecordsGame extends JPanel {

    private static final String path = "records.txt";
    private static InputOutputStream streamExam;

    public static ArrayList<ResultsTable> resultsTable = new ArrayList<>();

    final JPanel panel = new JPanel(); //основная панель
    final JPanel panel2 = new JPanel();
    JTextArea textArea = new JTextArea(); //для списка рекордов
    JLabel forText = new JLabel();
    JButton okayButton = new JButton();


    public RecordsGame(){

        String str = null;

        streamExam = new InputOutputStream(path);

        //расположение на панели
        panel.setLayout(new BorderLayout());

        forText.setText("Таблица рекордов: ");

       // textArea.setText("просто текст");

        panel.add(forText, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);

        panel2.add(okayButton);

        textArea.setEditable(false);

        try {
            //adds("Julia", 145);
            //adds("Nick", 155);
            readRecord();
            toScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.add(panel);
    }

    //добавляем в одну ячейку эрей листа
    public void adds(String nickname, int account) throws IOException {

        ResultsTable tmoRecord = new ResultsTable(nickname,account);
        resultsTable.add(tmoRecord);
        recordsToString();

        /*for(int i=0; i < resultsTable.size(); i++){
            String str = i+1 + ". " + nickname + " - " + account +" шагов." + "\n";
            textArea.append(str);
        }*/
    }


    public void toScreen(){
        textArea.setText("");
        for(int i=0; i < resultsTable.size(); i++){
            String str = i+1 + ". " + resultsTable.get(i).nickname + " - " + resultsTable.get(i).account +" шагов." + "\n";
            textArea.append(str);
        }

    }


    public void adds1(ResultsTable rt) throws IOException {
       // ResultsTable tmoRecord = new ResultsTable(nickname,account);
        resultsTable.add(rt);
        //recordsToString();
    }

    //преобразование всех рекордов в стринг, запись в файл
    public static void recordsToString() throws IOException {
        streamExam.clean();
        String str = "";
        for(int i=0; i < resultsTable.size();i++) {
            str = str + resultsTable.get(i).toString() + "!";
        }
        streamExam.write(str);
    }

    //чтение с файла запись в массив
    public void readRecord() throws IOException {
        String str = streamExam.read();

        String recordArr[] = str.split("!");
       // System.out.println(recordArr.length);
        for(int i=0;i < recordArr.length;i++){
            ResultsTable tmpRec = new ResultsTable();
            tmpRec.createRec(recordArr[i]);
            //System.out.println(recordArr[i]);
            adds1(tmpRec);
        }
    }
}
