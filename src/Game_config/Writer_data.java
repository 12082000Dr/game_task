package Game_config;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Writer_data {

    public void initGame(int count, String strNumber) {
        String dateGame = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        try {
            FileWriter writer = new FileWriter("result_history.txt", true);
            String data = "Game №" + count + " " + dateGame + " Загаданная строка " + strNumber + "\n";
            writer.append(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void endGame(int count, String ending) {
        try {
            FileWriter writer = new FileWriter("result_history.txt", true);
            String data = "Строка была угадана за " + count + ending + "\n";
            writer.append(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeData(String data){
        try {
            FileWriter writer = new FileWriter("result_history.txt", true);
            writer.append(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readData() {
        File file = new File("result_history.txt");
        String data = null;
        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                data = scanner.useDelimiter("\\Z").next();
                scanner.close();
                return data;
            } else {
                return "";
            }
        } catch (FileNotFoundException e) {
            return "";
        }
    }
}