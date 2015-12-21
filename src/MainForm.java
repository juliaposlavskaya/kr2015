import javax.swing.*;
import java.awt.*;

/**
 * Created by Julia on 11.12.2015.
 */
public class MainForm {

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

        Action frame = new Action();

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
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
