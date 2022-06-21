package Game_config;

import java.util.Random;
import java.util.Scanner;


public class Game {
    public static void main(String[] args) {
        int min = 1000;
        int max = 9999;
        Writer_data writer_data = new Writer_data();
        Validate validate = new Validate();
        Random random = new Random();

        //TODO ������ ����� ���������� � ����. ��� ����� ��������� ���� � ������ ���� �� �����
        // � ���������� ������ ����� �� ������ �����������
        int randomNumber = random.nextInt(max - min) + min;
        //TODO � ������ ����� ������������� � ������� Integer.toString(randomNumber)
        String strNumber = randomNumber + "";
        System.out.println(strNumber);
        System.out.println("�������� �������������� ���������� �����: ");

        String dataGame = writer_data.readData();
        int numberGame = dataGame.length() - dataGame.replace("�", "").length();

        int counterGame = 0;
        boolean trigger = true;
        writer_data.initGame(numberGame + 1, strNumber);

        //��������� � ��������� ����� ������������
        while (trigger) {
            int bull = 0;
            int cow = 0;

            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();

            //�������� ����� �� ������
            //TODO ������� ��������. �������
            if (inputNumber.length() != 4) {
                System.out.println("����� ������ ���� ��������������! ������� ������: ");
                continue;
            }

            //�������� ����� �� ������� ����
            //TODO ������� ��������. �������
            if (!inputNumber.matches("[-+]?\\d+")) {
                System.out.println("����� ������ ��������� ������ �����! ������� ������: ");
                continue;
            }

            //�������� ����� �� ������������ ����������� �����
            if (strNumber.equals(inputNumber)){
                bull += 4;
                trigger = false;

            } else {
                int index = 0;

                for (char numberFromInput: inputNumber.toCharArray()) {
                    if (numberFromInput == strNumber.toCharArray()[index]){
                        bull += 1;
                        index += 1;
                    } else {
                        boolean contains = false;
                        for (char item : strNumber.toCharArray()) {
                            if (numberFromInput == item) {
                                contains = true;
                                break;
                            }
                        }
                        if (contains) {
                            cow += 1;
                        }
                        index += 1;
                    }
                }
            }
            //TODO ����� ������ �������� counterGame++
            counterGame += 1;
            writer_data.writeData("\t������: " + inputNumber + " �����: " + validate.validate_animals(bull, cow) + "\n");
            System.out.println(validate.validate_animals(bull, cow));
        }
        writer_data.endGame(counterGame, validate.validate_result_ending(counterGame));
    }
}
