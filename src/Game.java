import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int min = 1000;
        int max = 9999;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + min;
        String strNumber = randomNumber + "";
        System.out.println(strNumber);

        boolean trigger = true;

        while (trigger) {
            int bull = 0;
            int cow = 0;

            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();

            if (strNumber.equals(inputNumber)){
                bull += 4;
                trigger = false;

            } else {
                int counter = 0;
                for (char numberFromInput: inputNumber.toCharArray()) {
                    if (numberFromInput == strNumber.toCharArray()[counter]){
                        bull += 1;
                        counter += 1;
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
                        counter += 1;
                    }
                }
            }

        }
    }
}
