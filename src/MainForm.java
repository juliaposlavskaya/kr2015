import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Julia on 11.12.2015.
 */
public class MainForm {

    final JFrame frame = new JFrame();
    final JMenuBar menuBar = new JMenuBar(); //Создаем основное меню бар

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

        Action gamePa = new Action();


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


        //Добавляем обработчики событий по нажатию
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);//Выход из системы
            }
        });

        specification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,
                        "Правила игры лалала","Правила",
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
                //для рекордов
            }
        });


        //Добавляем созданные элементы к подменю
        menuGame.add(nGame);
        menuGame.add(record);
        menuGame.add(exit);
        menuHelp.add(specification);


        //по центру экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height){
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width){
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);

        frame.setSize(new Dimension(206, 206));
        frame.setTitle("15");
        frame.getContentPane();



        frame.add(gamePa);
        gamePa.setVisible(true);

     //   frame.pack();
        frame.setJMenuBar(menuBar); //Устанавливаем полученное меню на окно
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
