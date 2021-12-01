import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class StreamPrinter {
    void print(Reader reader)  {
        try{
        int code = reader.read();

            while (code != -1) {
                System.out.println((char) code);
                code = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Reader example = new StringReader("Hello");
        new StreamPrinter().print(example);
    }
}
