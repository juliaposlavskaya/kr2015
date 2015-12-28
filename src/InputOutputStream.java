import java.io.*;

/**
 * Created by Julia on 28.12.2015.
 */
public class InputOutputStream {
    private InputStream inputstream;                     // класс для чтения файла
    private OutputStream outputStream;                  // класс для записи в файл
    public String path;                 // путь к файлу который будем читать и записывать


    public InputOutputStream(String path) {
        this.path = path;
    }


    // чтение файла используя InputStream
    public String read() throws IOException {
        inputstream = new FileInputStream(path);            // инициализируем поток на чтение
        int data = inputstream.read();          // читаем первый символ в байтах (ASCII)
        char content;
        String str = "";
        // по байтово читаем весь файл
        while(data != -1) {

            content = (char) data;               // преобразуем полученный байт в символ
            str = str + content;
            data = inputstream.read();
        }
        inputstream.close();             // закрываем поток
        return str;
    }

    // запись в файл используя OutputStream
    public void write(String st) throws IOException {
        String a = "";
        inputstream = new FileInputStream(path);
        int data = inputstream.read();
        char b;
        while(data != -1) {
            b = (char) data;
            a = a + b;
            data = inputstream.read();
        }
        inputstream.close();

        st = a + st;
        outputStream = new FileOutputStream(path);        // инициализируем поток для вывода данных, что позволит нам записать новые данные в файл
        outputStream.write(st.getBytes());              // передаем полученную строку st и приводим её к byte массиву.
        outputStream.close();               // закрываем поток вывода только после того как мы закроем поток данные попадут в файл.
    }

    public void clean() throws IOException {
        String st="";
        outputStream = new FileOutputStream(path);
        outputStream.write(st.getBytes());
        outputStream.close();
    }
}
