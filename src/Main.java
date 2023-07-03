public class Main {
    public static boolean doesNumberSuits(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 1000 || intNumber > 9999) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            for (int j = i+1; j < number.length(); j++) {
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

    }
}