import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Julia on 11.12.2015.
 */
public class MainForm {

    final JFrame frame = new JFrame(); //создаем рамку
    final JMenuBar menuBar = new JMenuBar(); //Создаем основное меню бар
    final JPanel mPanel = new JPanel(); //основная панель

    public static void main(String args[]){

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        new MainForm(); //Create and show the GUI.

    }

    public MainForm(){

        Game gamePa = new Game();
        Welcome welcomePanel = new Welcome();
        RecordsGame recordsGame = new RecordsGame();

        //иконка
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("caticon.png");
        frame.setIconImage(img);

        //Создаем подменю меню бара
        JMenu menuGame = new JMenu("Игра");
        JMenu menuHelp = new JMenu("Помощь");

        //Добавляем подменю в основное меню
        menuBar.add(menuGame);
        menuBar.add(menuHelp);

        //Создаем элементы подменю Game с обработчиками событий
        JMenuItem nGame = new JMenuItem("Новая игра");
        JMenuItem record = new JMenuItem("Рекорды");
        JMenuItem exit = new JMenuItem("Выход");

        //Создаем элемент подменю Help с обработчиками событий
        JMenuItem specification = new JMenuItem("Правила");


        //Добавляем обработчики событий по нажатию кнопок из менюбара
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);//Выход из системы
            }
        });

        specification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,
                        "Пятнашки - головоломка, представляющая собой 15 квадратных костяшек с нанесенными числами от 1 до 15. " + "\n" +
                                "Все костяшки заключены в квадратную коробку размером 4x4. Таким образом при размещении костяшек" + "\n" +
                                "в коробке остается одно пустое место размером с одну костяшку, которое можно использовать" + "\n" +
                                "для перемещения костяшек внутри коробки. Цель игры - упорядочить размещение чисел в коробке," + "\n" +
                                "разместив их по возрастанию слева направо и сверху вниз, начиная с костяшки с номером 1 в левом" + "\n" +
                                "верхнем углу и заканчивая пустым местом в правом нижнем углу коробки. ","Правила",
                        JOptionPane.QUESTION_MESSAGE);
            }
        });

        nGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                gamePa.newGame();

            }
        });

        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                recordsGame.setVisible(true);
                gamePa.setVisible(false);
                frame.setSize(new Dimension(206, 206));
              //  frame.pack();

            }
        });

        recordsGame.okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                recordsGame.setVisible(false);
                gamePa.setVisible(true);
                frame.setSize(new Dimension(206, 206));
            }
        });

        //для основной панельки
        welcomePanel.play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                gamePa.nickname = welcomePanel.textField1.getText();
                gamePa.setVisible(true);
                welcomePanel.setVisible(false);
                frame.setSize(new Dimension(206, 206));
                gamePa.newGame();
            }
        });

        welcomePanel.specificationWelcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                JOptionPane.showMessageDialog(null,
                        "Пятнашки - головоломка, представляющая собой 15 квадратных костяшек с нанесенными числами от 1 до 15. " + "\n" +
                                "Все костяшки заключены в квадратную коробку размером 4x4. Таким образом при размещении костяшек" + "\n" +
                                "в коробке остается одно пустое место размером с одну костяшку, которое можно использовать" + "\n" +
                                "для перемещения костяшек внутри коробки. Цель игры - упорядочить размещение чисел в коробке," + "\n" +
                                "разместив их по возрастанию слева направо и сверху вниз, начиная с костяшки с номером 1 в левом" + "\n" +
                                "верхнем углу и заканчивая пустым местом в правом нижнем углу коробки. ","Правила",
                        JOptionPane.QUESTION_MESSAGE);
            }
        });


        //Добавляем созданные элементы к подменю
        menuGame.add(nGame);
        menuGame.add(record);
        menuGame.add(exit);
        menuHelp.add(specification);

        frame.setLocationRelativeTo(null);//по центру экрана

        frame.setSize(new Dimension(240, 150));
        frame.setTitle("15");
        frame.setResizable(false);
       // frame.getContentPane();

        mPanel.add(welcomePanel);
        mPanel.add(gamePa);
        mPanel.add(recordsGame);
        recordsGame.setVisible(false);
        gamePa.setVisible(false);
        welcomePanel.setVisible(true);

        frame.add(mPanel);

        frame.setJMenuBar(menuBar); //Устанавливаем полученное меню на окно
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}