package Finance;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class GUIController {


    public GUIController(OutputStream outputStream) {
        System.setOut(new PrintStream(outputStream));
    }

    public void checkInput(InputStream input) throws IOException {
        Scanner sc = new Scanner(input);
        String text = "";
        while (sc.hasNext()) {
            text = sc.next();
            writeOutput(text);
        }
    }

    public void writeOutput(String text) throws UnsupportedEncodingException, IOException {
        System.out.println(text);
    }
}
