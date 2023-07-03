import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean doesNumberSuits(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 1000 || intNumber > 9999) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;

                }
            }
        }
        return true;
    }

    public static boolean playGame(String guessNumber, int randomNumber) {
        String theRandom = String.valueOf(randomNumber);
        int countCow = 0;
        int countBull = 0;
        for (int i = 0; i < theRandom.length(); i++) {
            for (int j = 0; j < guessNumber.length(); j++) {
                if (theRandom.charAt(i) == guessNumber.charAt(j)) {
                    countCow++;
                    break;
                }
            }
        }
        for (int i = 0; i < theRandom.length(); i++) {
            if (theRandom.charAt(i) == guessNumber.charAt(i)) {
                countBull++;
            }
        }
        System.out.println("Cows: " + countCow + ", Bulls: " + countBull);
        if (countCow == 4 && countBull == 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("1-> one player, 2-> two players");
        System.out.print("Enter mode: ");
        int mode = sc.nextInt();
        switch (mode) {
            case 1:
                int randomNumber;
                do {
                    randomNumber = random.nextInt(9000) + 1000;
                } while (!doesNumberSuits(String.valueOf(randomNumber)));
                String guessNumber;
                while (true) {
                    do {
                        System.out.print("Enter your guess: ");
                        guessNumber = sc.next();
                        if (!doesNumberSuits(guessNumber)) {
                            System.out.println("Please enter a four-digit number with different digits.");
                        }
                    } while (!doesNumberSuits(guessNumber));
                    while (true) {
                        boolean resultGame = playGame(guessNumber, randomNumber);
                        if (resultGame) {
                            System.out.println("You guessed the number!");
                            break;
                        } else {
                            do {
                                System.out.print("Enter your guess: ");
                                guessNumber = sc.next();
                                if (!doesNumberSuits(guessNumber)) {
                                    System.out.println("Please enter a four-digit number with different digits.");
                                }
                            } while (!doesNumberSuits(guessNumber));
                        }
                    }
                    break;
                }
                break;
        }
    }
}