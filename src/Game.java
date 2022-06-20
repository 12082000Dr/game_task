import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public String validate(int bull, int cow) {
        String v_bull = null;
        String v_cow = null;

        if (cow == 1) {
            v_cow = cow + " корова";
        } else if (cow > 1) {
            v_cow = cow + " коровы";
        }

        if (bull == 1) {
            v_bull = bull + " бык";
        } else {
            v_bull = bull + " быка";
        }

        if (bull == 0) {
            return v_cow;
        } else if (cow == 0) {
            return v_bull;
        } else {
            return v_bull + " " + v_cow;
        }
    }

    public static void main(String[] args) {
        int min = 1000;
        int max = 9999;
        Game game = new Game();
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
            System.out.println(game.validate(bull, cow));
        }
    }
}
