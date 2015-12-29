import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Julia on 11.12.2015.
 */
public class Game extends JPanel {

    JPanel contentPanel = new JPanel();
    final JPanel gamePanel = new JPanel(); //панель с кнопочками
    final JButton[][] buttons = new JButton[4][4];   //массив кнопочек
    final int[][] matrix = new int[4][4];    //матрица для хранения чисел
    final JLabel status= new JLabel(); //линия статус бара
    String nickname;
    int account;

    //создаем панель
    public Game(){
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try{
            initializationFrame();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    private void initializationFrame() throws Exception {

        contentPanel.setLayout(new BorderLayout());

        gamePanel.setLayout(null);

        // добавляем кнопочки
        gamePanel.setLayout(new GridLayout(4, 4));

        int count = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton(""+count);
                //устанавливаем обработчик событий
                buttons[i][j].addMouseListener(new AdapterForButtons(i,j));

                buttons[i][j].setSize(50,50);
                buttons[i][j].setLocation(50*j,50*i);
                buttons[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                gamePanel.add(buttons[i][j]);
                matrix[i][j]=count;//задаем матрицу
                count++;

                buttons[i][j].setBackground(Color.getHSBColor(150,256,170));
                buttons[i][j].setForeground(Color.WHITE);
            }
        buttons[0][0].setText(" "); //будет несуществующей, чтобы двигать кнопочки

        //Добавляем на основную панель
        contentPanel.add(gamePanel, BorderLayout.CENTER);

        //статус
        status.setBorder(BorderFactory.createEtchedBorder());
        contentPanel.add(status,BorderLayout.SOUTH);

        this.add(contentPanel);
    }

    //Случайным образом переставляем элементы матрицы
    public void randomizeMatrix(){
        for(int i = 0;i<100;i++){

            int a = (int)(Math.random()*4);
            int b = (int)(Math.random()*4);
            int a2 = (int)(Math.random()*4);
            int b2 = (int)(Math.random()*4);

            int c = matrix[a][b];
            matrix[a][b] = matrix[a2][b2];
            matrix[a2][b2] = c;
        }
    }

    //новая игра
    public void newGame(){

        account = 0;

        randomizeMatrix();
        for(int i = 0;i<4;i++)
            for(int j = 0;j<4;j++){
                //пишем на кнопочках числа из матрицы
                if(matrix[i][j]!=0) {
                    buttons[i][j].setText("" + matrix[i][j]);
                }
                else if(matrix[i][j]==0) {
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(false);
                }
            }

        status.setText(nickname + ": новая игра");
        gamePanel.setVisible(true);
    }

    //класс для перемещения кнопочек
    class AdapterForButtons  extends java.awt.event.MouseAdapter{
        int posi, posj;
        int startx = 0;
        int starty = 0;

        //позиция кнопочки
        AdapterForButtons(int posI,int posJ){

            this.posi=posI;
            this.posj=posJ;
        }

        //При нажатой кнопке мыши
        public void mousePressed(MouseEvent e){

            //меняем курсор
            buttons[posi][posj].setCursor(new Cursor(Cursor.MOVE_CURSOR));

            //запоминаем точку начала переноса кнопки
            startx = e.getX();
            starty = e.getY();
        }

        //При отпускании кнопки мыши
        public void mouseReleased(MouseEvent e){

            //меняем курсор
            buttons[posi][posj].setCursor(new Cursor(Cursor.HAND_CURSOR));

            //запоминаем точку окончания переноса кнопки
            int endx = e.getX();
            int endy = e.getY();

            //определяем направление переноса если абсолютная величина (shiftx) больше абсолютной величины (shifty) значит передвигаемся по оси х
            int shiftx = endx-startx;
            int shifty = endy-starty;
            if(Math.abs(shiftx)>Math.abs(shifty)){

                //определяем направление движения по оси х
                if(shiftx>0){

                    //впрово если это не крайние правые кнопки и правая кнопка пустая меняем местами кнопку с пустой кнопкой
                    if((posj != 3) && (matrix[posi][posj+1] == 0)){
                        matrix[posi][posj+1] = matrix[posi][posj];
                        matrix[posi][posj]=0;
                        buttons[posi][posj].setText("");

                        buttons[posi][posj].setEnabled(false);
                        buttons[posi][posj].setBackground(Color.getHSBColor(150,256,160));

                        buttons[posi][posj+1].setText(""+matrix[posi][posj+1]);

                        buttons[posi][posj+1].setEnabled(true);
                        buttons[posi][posj+1].setBackground(Color.getHSBColor(150,256,170));
                        buttons[posi][posj+1].setForeground(Color.WHITE);

                        account++;

                        status.setText(nickname + ": отличный ход: " +account + " шагов");
                    }else status.setText(nickname + ": это невозможно");
                }
                else{

                    //влево если это не крайние левые кнопки и левая кнопка пустая меняем местами кнопку с пустой кнопкой
                    if((posj != 0) && (matrix[posi][posj-1] == 0)){
                        matrix[posi][posj-1] = matrix[posi][posj];
                        matrix[posi][posj]=0;
                        buttons[posi][posj].setText("");

                        buttons[posi][posj].setEnabled(false);
                        buttons[posi][posj].setBackground(Color.getHSBColor(150,256,160));

                        buttons[posi][posj-1].setText(""+matrix[posi][posj-1]);

                        buttons[posi][posj-1].setEnabled(true);
                        buttons[posi][posj-1].setBackground(Color.getHSBColor(150,256,170));
                        buttons[posi][posj-1].setForeground(Color.WHITE);

                        account++;

                        status.setText(nickname + ": отличный ход: " +account + " шагов");
                    }else status.setText(nickname + ": это невозможно");
                }
            }
            else{

                //определяем направление движения по оси y
                if(shifty>0){

                    //вниз если это не крайние нижние кнопки и нижняя кнопка пустая меняем местами кнопку с пустой кнопкой
                    if((posi != 3) && (matrix[posi+1][posj] == 0)){
                        matrix[posi+1][posj] = matrix[posi][posj];
                        matrix[posi][posj]=0;
                        buttons[posi][posj].setText("");

                        buttons[posi][posj].setEnabled(false);
                        buttons[posi][posj].setBackground(Color.getHSBColor(150,256,160));

                        buttons[posi+1][posj].setText(""+matrix[posi+1][posj]);

                        buttons[posi+1][posj].setEnabled(true);
                        buttons[posi+1][posj].setBackground(Color.getHSBColor(150,256,170));
                        buttons[posi+1][posj].setForeground(Color.WHITE);

                        account++;
                        status.setText(nickname + ": отличный ход: " +account + " шагов");
                    }else status.setText(nickname + ": это невозможно");
                }
                else{

                    //вверх если это не крайние верхние кнопки и верхняя кнопка пустая меняем местами кнопку с пустой кнопкой
                    if((posi != 0) && (matrix[posi-1][posj] == 0)){
                        matrix[posi-1][posj] = matrix[posi][posj];
                        matrix[posi][posj]=0;
                        buttons[posi][posj].setText("");

                        buttons[posi][posj].setEnabled(false);
                        buttons[posi][posj].setBackground(Color.getHSBColor(150,256,160));

                        buttons[posi-1][posj].setText(""+matrix[posi-1][posj]);

                        buttons[posi-1][posj].setEnabled(true);
                        buttons[posi-1][posj].setBackground(Color.getHSBColor(150,256,170));
                        buttons[posi-1][posj].setForeground(Color.WHITE);

                        account++;
                        status.setText(nickname + ": отличный ход: " +account + " шагов");
                    }else
                        status.setText(nickname + ": это невозможно");
                }
            }
            //проверяем все ли числа стоят на своих местах если да то победа
            int count=1;
            int error=0;
            for(int i = 0;i<4;i++)
                for(int j = 0;j<4;j++){
                    if(matrix[i][j]!=count)
                        error++;
                    count++;
                }
            if(error == 1) {
                status.setText("1!!!");
                int result = JOptionPane.showConfirmDialog(null,
                        "Победа!!!","Победа!!! Поздравляем! Вы выиграли за " + account + " шагов!!" + "\n"  +
                                "Желаете ли сыграть еще раз?",JOptionPane.YES_NO_OPTION);
                RecordsGame.resultsTable.add(new ResultsTable(nickname, account));
                try {
                    RecordsGame.recordsToString();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (result == JOptionPane.YES_OPTION)
                    newGame();
                else
                    gamePanel.setVisible(false);
            }
        }
    }
}


