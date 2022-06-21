package Game_config;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Game {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            runGame();
            System.out.println("’отите сыграть еще раз? да/нет");
            String YesNo = scanner.nextLine();
            if (YesNo.toUpperCase().equals("Ќ≈“")) {
                flag = false;
            }
        }
    }

    private static void runGame() {
        InputOutputData iodate = new InputOutputData();
        Validate validate = new Validate();
        Random random = new Random();

        //TODO строка может начинаться с нуля. При такой генерации нуля в начале быть не может
        // в загаданной строке цифры не должны повторяться
        //String заменен на List, включена проверка, каждый разр€д генерируетс€ отдельно
        List<Integer> randomInt = new ArrayList<>(List.of(random.nextInt(9)));
        for (int i = 0; i < 3; i ++) {
            int item = random.nextInt(9);
            while (randomInt.contains(item)) {
                item = random.nextInt(9);
            }
            randomInt.add(item);
        }
        String randomNumber = randomInt.stream().map(Object::toString).collect(Collectors.joining());
        //TODO В строку можно преобразовать с помощью Integer.toString(randomNumber)
        //ѕреобразование int в String заменил склейкой списка
        System.out.println(randomNumber);
        System.out.println("”гадайте четырехзначное загаданное число: ");

        String dataGame = iodate.readData();
        int numberGame = dataGame.length() - dataGame.replace("є", "").length();

        int counterGame = 0;
        boolean trigger = true;
        iodate.initGame(numberGame + 1, randomNumber);

        while (trigger) {
            int bull = 0;
            int cow = 0;

            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();

            //ѕроверка ввода на длинну
            //TODO хорошие проверки. Молодец
            if (inputNumber.length() != 4) {
                System.out.println("„исло должно быть четырехзначным! ¬ведите заново: ");
                continue;
            }

            //ѕроверка ввода на наличие букв
            //TODO хорошие проверки. Молодец
            if (!inputNumber.matches("[-+]?\\d+")) {
                System.out.println("ќтвет должен содержать только цифры! ¬ведите заново: ");
                continue;
            }

            //ѕроверка ввода на соответствие загаданному числу
            if (randomNumber.equals(inputNumber)){
                bull += 4;
                trigger = false;

            } else {
                int index = 0;

                for (char numberFromInput: inputNumber.toCharArray()) {
                    if (numberFromInput == randomNumber.toCharArray()[index]){
                        bull += 1;
                        index += 1;
                    } else {
                        boolean contains = false;
                        for (char item : randomNumber.toCharArray()) {
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
            //TODO можно просто написать counterGame++
            counterGame++;
            iodate.writeData("\t«апрос: " + inputNumber + " ќтвет: " + validate.validate_animals(bull, cow) + "\n");
            System.out.println(validate.validate_animals(bull, cow));
        }
        iodate.endGame(counterGame, validate.validate_result_ending(counterGame));
    }
}
