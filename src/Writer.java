import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writeData(String data){
        try {
            FileWriter writer = new FileWriter("result_history.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readData() {
        try {
            FileReader reader = new FileReader("result_history.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
